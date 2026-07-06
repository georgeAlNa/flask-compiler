package classes;

import FlaskGen.FlaskParser;
import FlaskGen.FlaskParserBaseVisitor;
import jinja_ast.HtmlElementNode;
import jinja_ast.JinjaExpressionNode;
import jinja_ast.JinjaForNode;
import jinja_ast.JinjaIfNode;
import jinja_ast.JinjaVariableNode;
import jinja_ast.TemplateNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import python_ast.AssignmentNode;
import python_ast.ListNode;
import python_ast.PythonProgramNode;
import python_ast.RenderTemplateNode;
import python_ast.ReturnNode;
import python_ast.RouteNode;
import semantic_check.SemanticAnalyzer;
import semantic_check.SemanticError;
import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseVisitor extends FlaskParserBaseVisitor<Object> {

    private SymbolTable symbolTable = new SymbolTable();
    private SemanticAnalyzer analyzer = new SemanticAnalyzer(symbolTable);
    private final PythonProgramNode pythonProgramNode = new PythonProgramNode();
    private String currentScope = "global";
    /**
     * Stores raw Python text of global variable declarations for emission in app.py
     */
    private final List<String> globalDeclarationLines = new ArrayList<>();

    public boolean hasSemanticErrors() {
        return !analyzer.getErrors().isEmpty();
    }

    public List<SemanticError> getSemanticErrors() {
        return analyzer.getErrors();
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    // Application root

    @Override
    public Application visitApplicationRoot(FlaskParser.ApplicationRootContext ctx) {
        Application application = new Application();

        for (FlaskParser.ImportStatementContext imp : ctx.importStatement()) {
            visit(imp);
        }
        if (ctx.appDeclaration() != null) {
            visit(ctx.appDeclaration());
        }
        for (FlaskParser.GlobalAssignmentContext ga : ctx.globalAssignment()) {
            visit(ga);
        }
        for (FlaskParser.RouteDefinitionContext rd : ctx.routeDefinition()) {
            FlaskRouteView routeView = (FlaskRouteView) visit(rd);
            if (routeView != null) {
                application.addRouteView(routeView);
            }
        }
        if (ctx.mainGuard() != null) {
            visit(ctx.mainGuard());
        }

        analyzer.analyze();
        analyzer.printErrors();
        this.symbolTable.print();
        // Store captured global declarations in the application
        application.getGlobalDeclarations().addAll(globalDeclarationLines);
        application.setPythonProgramNode(pythonProgramNode);
        return application;
    }

    // Import statement

    @Override
    public Object visitImportDef(FlaskParser.ImportDefContext ctx) {
        StringBuilder imports = new StringBuilder();
        for (TerminalNode id : ctx.IDENTIFIER()) {
            if (imports.length() > 0)
                imports.append(", ");
            imports.append(id.getText());
        }
        addRow("import", imports.toString(), ctx.start);
        return null;
    }

    // App declaration

    @Override
    public Object visitAppDef(FlaskParser.AppDefContext ctx) {
        String text = ctx.IDENTIFIER(0).getText() + " = " +
                ctx.IDENTIFIER(1).getText() + "(" +
                ctx.DUNDER_NAME().getText() + ")";
        addRow("appDeclaration", text, ctx.start);
        return null;
    }

    // Global assignment

    @Override
    public Object visitGlobalListDef(FlaskParser.GlobalListDefContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        Row row = addRow("globalVariable", varName, ctx.start, "global", "PYTHON", "list", false, false);
        // Capture the raw source text of the entire global declaration for code gen
        String rawDecl = getRawText(ctx);
        row.setAdditionalData(rawDecl);
        globalDeclarationLines.add(rawDecl);
        pythonProgramNode.addChild(new ListNode(varName, rawDecl, ctx.start.getLine(), ctx.start.getCharPositionInLine()));
        return null;
    }

    // Main guard

    @Override
    public Object visitMainGuardDef(FlaskParser.MainGuardDefContext ctx) {
        addRow("mainGuard", "if __name__ == \"__main__\"", ctx.start);
        return null;
    }

    // Route definition

    @Override
    public FlaskRouteView visitRouteDef(FlaskParser.RouteDefContext ctx) {
        FlaskRouteView routeView = new FlaskRouteView();
        RouteViewMetadata metadata = new RouteViewMetadata();

        // Extract route path and optional methods from decorator
        FlaskParser.RouteDecoratorDefContext decCtx = (FlaskParser.RouteDecoratorDefContext) ctx.routeDecorator();
        String routePath = stripQuotes(decCtx.STRING(0).getText());

        // Capture optional methods=['GET', 'POST'] from decorator
        List<String> methods = null;
        if (decCtx.STRING().size() > 1) {
            methods = new java.util.ArrayList<>();
            // STRING(0) is the route path; STRING(1..) are the method strings
            for (int i = 1; i < decCtx.STRING().size(); i++) {
                methods.add(stripQuotes(decCtx.STRING(i).getText()));
            }
        }
        RouteEntry routeEntry = (methods != null) ? new RouteEntry(routePath, methods) : new RouteEntry(routePath);
        metadata.getMetadataEntries().add(routeEntry);
        addRow("route", routePath, ctx.start);

        // Extract function name
        String funcName = ctx.IDENTIFIER().getText();
        currentScope = funcName;
        RouteNode routeNode = new RouteNode(routePath, funcName, methods, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        pythonProgramNode.addRoute(routeNode);
        FlaskClass flaskClass = new FlaskClass();
        flaskClass.setClassName(funcName);
        addRow("routeFunction", funcName, ctx.DEF().getSymbol());

        // Extract parameters
        if (ctx.parameterList() != null) {
            FlaskParser.ParamListContext pCtx = (FlaskParser.ParamListContext) ctx.parameterList();
            for (TerminalNode id : pCtx.IDENTIFIER()) {
                addRow("parameter", id.getText(), id.getSymbol());
            }
        }

        // Visit route body
        if (ctx.routeBody() != null) {
            FlaskParser.RouteBodyContentContext bodyCtx = (FlaskParser.RouteBodyContentContext) ctx.routeBody();
            ClassBody classBody = new ClassBody();
            List<ClassMember> members = new ArrayList<>();

            // Collect return statement keyword args for later (e.g. items=products_data)
            Map<String, String> returnKwArgs = new LinkedHashMap<>();

            for (FlaskParser.BodyStatementContext stmtCtx : bodyCtx.bodyStatement()) {
                if (stmtCtx instanceof FlaskParser.BodyVarAssignmentContext vaCtx) {
                    String varName = vaCtx.IDENTIFIER().getText();
                    String varValue = getRawText(vaCtx.pyExpression());
                    Row propertyRow = addRow("classProperty", varName, vaCtx.start, currentScope, "PYTHON",
                            inferDataType(varValue), false, false);
                    propertyRow.setAdditionalData(varValue);
                    routeNode.addChild(new AssignmentNode(varName, varValue, vaCtx.start.getLine(),
                            vaCtx.start.getCharPositionInLine()));

                    // Detect complex expressions (function calls, generators, list access, etc.)
                    // Simple values are: string literals, numbers, None/True/False, plain
                    // identifiers
                    boolean isComplex = varValue.contains("(") || varValue.contains("[")
                            || varValue.contains("{") || varValue.contains(".");
                    if (isComplex) {
                        // Store as raw pre-return line for verbatim emission
                        String rawLine = varName + " = " + varValue;
                        routeView.getPreReturnRawLines().add(rawLine);
                    }

                    PropertyDeclaration prop = new PropertyDeclaration();
                    prop.setIdentifier(varName);
                    prop.setValue(varValue);

                    ClassMember member = new ClassMember(vaCtx);
                    member.setPropertyDeclaration(prop);
                    members.add(member);

                } else if (stmtCtx instanceof FlaskParser.BodyTemplateAssignmentContext taCtx) {
                    String templateContent = taCtx.TRIPLE_QUOTE_STRING().getText();
                    addRow("template", templateContent, taCtx.start, currentScope, "JINJA", "template", false, false);

                    InlineTemplate inlineTemplate = new InlineTemplate(templateContent);
                    TemplateNode templateNode = buildTemplateAst(templateContent, taCtx.start, currentScope);
                    inlineTemplate.setTemplateNode(templateNode);
                    routeNode.addChild(templateNode);
                    metadata.getMetadataEntries().add(new TemplateEntry(inlineTemplate));

                } else if (stmtCtx instanceof FlaskParser.BodyReturnStatementContext rsCtx) {
                    String returnText = getRawText(rsCtx.pyExpression());
                    addRow("returnStatement", returnText, rsCtx.start, currentScope, "PYTHON",
                            "return", false, false);
                    ReturnNode returnNode = new ReturnNode(returnText, rsCtx.start.getLine(),
                            rsCtx.start.getCharPositionInLine());
                    routeNode.addChild(returnNode);
                    RenderTemplateNode renderNode = new RenderTemplateNode(extractTemplateName(returnText),
                            rsCtx.start.getLine(), rsCtx.start.getCharPositionInLine());
                    returnNode.addChild(renderNode);

                    // Parse keyword arguments: e.g. render_template_string(template,
                    // items=products_data, label=label)
                    Pattern kwArgPattern = Pattern.compile("(\\w+)=(\\w+(?:\\.\\w+)*)");
                    Matcher m = kwArgPattern.matcher(returnText);
                    while (m.find()) {
                        String kwKey = m.group(1);
                        String kwValue = m.group(2);
                        if (!kwKey.equals("template") && !kwKey.equals("debug")) {
                            returnKwArgs.put(kwKey, kwValue);
                            renderNode.addContextVariable(kwKey, kwValue);
                            Row bindingRow = addRow("templateBinding", kwKey, rsCtx.start, currentScope,
                                    "PYTHON->JINJA", "binding", true, true);
                            bindingRow.setAdditionalData(kwValue);
                            markPassedToTemplate(kwKey);
                            markPassedToTemplate(kwValue);
                        }
                    }

                } else if (stmtCtx instanceof FlaskParser.BodyIfBlockContext ibCtx) {
                    FlaskParser.IfBlockDefContext ifDef = (FlaskParser.IfBlockDefContext) ibCtx.ifBlock();
                    String ifExprText = getRawText(ifDef.pyExpression(0));
                    addRow("ifBlock", "if " + ifExprText, ibCtx.start);

                    // Capture the entire if-block as raw Python source text
                    String rawIfBlock = getRawText(ifDef);
                    routeView.getIfBlockRawCode().add(rawIfBlock);

                    // Visit nested statements inside if block for symbol table
                    for (FlaskParser.InnerBodyStatementContext innerStmt : ifDef.innerBodyStatement()) {
                        if (innerStmt instanceof FlaskParser.InnerBodyVarAssignmentContext innerVa) {
                            String varValue = getRawText(innerVa.pyExpression());
                            Row innerRow = addRow("classProperty", innerVa.IDENTIFIER().getText(), innerVa.start,
                                    currentScope, "PYTHON", inferDataType(varValue), false, false);
                            innerRow.setAdditionalData(varValue);
                        }
                    }
                }
            }

            // For keyword args in return that are NOT already declared as local properties,
            // add them as ClassMember entries so they get emitted in the generated Python.
            java.util.Set<String> declaredVars = new java.util.HashSet<>();
            for (ClassMember cm : members) {
                if (cm.getPropertyDeclaration() != null) {
                    declaredVars.add(cm.getPropertyDeclaration().getIdentifier());
                }
            }
            for (Map.Entry<String, String> entry : returnKwArgs.entrySet()) {
                String kwKey = entry.getKey();
                String kwValue = entry.getValue();
                if (!declaredVars.contains(kwKey)) {
                    Row kwRow = addRow("classProperty", kwKey, bodyCtx.start, currentScope, "PYTHON",
                            inferDataType(kwValue), false, true);
                    kwRow.setAdditionalData(kwValue);
                    PropertyDeclaration prop = new PropertyDeclaration();
                    prop.setIdentifier(kwKey);
                    prop.setValue(kwValue);
                    ClassMember member = new ClassMember(bodyCtx);
                    member.setPropertyDeclaration(prop);
                    members.add(member);
                }
            }

            classBody.setClassMembers(members.toArray(new ClassMember[0]));
            flaskClass.setClassBody(classBody);
        }

        routeView.setRouteViewMetadata(metadata);
        routeView.setFlaskClass(flaskClass);
        currentScope = "global";
        return routeView;
    }

    // Helpers

    private void addRow(String type, String value, Token token) {
        addRow(type, value, token, currentScope, "PYTHON", null, false, false);
    }

    private Row addRow(String type, String value, Token token, String scope, String origin, String dataType,
            boolean usedInTemplate, boolean passedToTemplate) {
        Row row = new Row();
        row.setType(type);
        row.setValue(value);
        row.setLine(token.getLine());
        row.setColumn(token.getCharPositionInLine());
        row.setScope(scope);
        row.setOrigin(origin);
        row.setDataType(dataType);
        row.setUsedInTemplate(usedInTemplate);
        row.setPassedToTemplate(passedToTemplate);
        symbolTable.getRows().add(row);
        return row;
    }

    /**
     * Get the original source text of a parse tree node, preserving whitespace.
     * ANTLR's getText() concatenates tokens without spaces; this method uses the
     * CharStream interval to get the raw input text including spaces.
     */
    private String getRawText(org.antlr.v4.runtime.ParserRuleContext ctx) {
        if (ctx == null)
            return "";
        org.antlr.v4.runtime.Token start = ctx.getStart();
        org.antlr.v4.runtime.Token stop = ctx.getStop();
        if (start == null || stop == null)
            return ctx.getText();
        org.antlr.v4.runtime.CharStream cs = start.getInputStream();
        if (cs == null)
            return ctx.getText();
        return cs.getText(new org.antlr.v4.runtime.misc.Interval(start.getStartIndex(), stop.getStopIndex()));
    }

    private TemplateNode buildTemplateAst(String rawTemplate, Token token, String scope) {
        String content = stripTripleQuotes(rawTemplate);
        TemplateNode templateNode = new TemplateNode(content, token.getLine(), token.getCharPositionInLine());

        Pattern tagPattern = Pattern.compile("<\\s*([a-zA-Z][a-zA-Z0-9]*)\\b");
        Matcher tagMatcher = tagPattern.matcher(content);
        while (tagMatcher.find()) {
            SourcePosition position = templatePosition(content, tagMatcher.start(), token);
            templateNode.addChild(new HtmlElementNode(tagMatcher.group(1), position.line, position.column));
        }

        Pattern forPattern = Pattern.compile("\\{%\\s*for\\s+(\\w+)\\s+in\\s+(\\w+)\\s*%\\}");
        Matcher forMatcher = forPattern.matcher(content);
        while (forMatcher.find()) {
            SourcePosition position = templatePosition(content, forMatcher.start(), token);
            JinjaForNode forNode = new JinjaForNode(forMatcher.group(1), forMatcher.group(2),
                    position.line, position.column);
            templateNode.addChild(forNode);
            Row loopRow = addRow("jinjaFor", forMatcher.group(2), token, scope, "JINJA", "loopSource", true, false);
            loopRow.setLine(position.line);
            loopRow.setColumn(position.column);
            loopRow.setAdditionalData(forMatcher.group(1));
        }

        Pattern ifPattern = Pattern.compile("\\{%\\s*if\\s+([^%]+?)\\s*%\\}");
        Matcher ifMatcher = ifPattern.matcher(content);
        while (ifMatcher.find()) {
            SourcePosition position = templatePosition(content, ifMatcher.start(), token);
            String condition = ifMatcher.group(1).trim();
            templateNode.addChild(new JinjaIfNode(condition, position.line, position.column));
            Row ifRow = addRow("jinjaIf", condition, token, scope, "JINJA", "condition", true, false);
            ifRow.setLine(position.line);
            ifRow.setColumn(position.column);
        }

        Pattern variablePattern = Pattern.compile("\\{\\{\\s*([a-zA-Z_][a-zA-Z0-9_]*)(?:\\.([a-zA-Z_][a-zA-Z0-9_]*))?");
        Matcher variableMatcher = variablePattern.matcher(content);
        while (variableMatcher.find()) {
            SourcePosition position = templatePosition(content, variableMatcher.start(), token);
            String variableName = variableMatcher.group(1);
            String propertyName = variableMatcher.group(2);
            JinjaVariableNode variableNode = new JinjaVariableNode(variableName, propertyName,
                    position.line, position.column);
            templateNode.addChild(variableNode);
            Row variableRow = addRow("jinjaVariable", variableName, token, scope, "JINJA",
                    propertyName == null ? "variable" : "propertyAccess", true, false);
            variableRow.setLine(position.line);
            variableRow.setColumn(position.column);
            variableRow.setAdditionalData(propertyName);
            markUsedInTemplate(variableName);
        }

        Pattern expressionPattern = Pattern.compile("\\{\\{\\s*(.*?)\\s*\\}\\}");
        Matcher expressionMatcher = expressionPattern.matcher(content);
        while (expressionMatcher.find()) {
            SourcePosition position = templatePosition(content, expressionMatcher.start(), token);
            templateNode.addChild(new JinjaExpressionNode(expressionMatcher.group(1).trim(),
                    position.line, position.column));
        }

        return templateNode;
    }

    private SourcePosition templatePosition(String content, int offset, Token token) {
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        int lastLineStart = 0;

        for (int i = 0; i < offset && i < content.length(); i++) {
            if (content.charAt(i) == '\n') {
                line++;
                lastLineStart = i + 1;
                column = 0;
            }
        }

        if (lastLineStart == 0) {
            column += offset;
        } else {
            column = offset - lastLineStart;
        }
        return new SourcePosition(line, column);
    }

    private static class SourcePosition {
        private final int line;
        private final int column;

        private SourcePosition(int line, int column) {
            this.line = line;
            this.column = column;
        }
    }

    private String stripTripleQuotes(String rawTemplate) {
        if (rawTemplate == null) {
            return "";
        }
        String content = rawTemplate.trim();
        if (content.startsWith("\"\"\"")) {
            content = content.substring(3);
        }
        if (content.endsWith("\"\"\"")) {
            content = content.substring(0, content.length() - 3);
        }
        return content;
    }

    private String inferDataType(String value) {
        if (value == null) {
            return "unknown";
        }
        String trimmed = value.trim();
        if (trimmed.startsWith("[") || trimmed.endsWith("_data")) {
            return "list";
        }
        if (trimmed.startsWith("{")) {
            return "dict";
        }
        if (trimmed.startsWith("\"") || trimmed.startsWith("'")) {
            return "string";
        }
        if (trimmed.matches("-?\\d+(\\.\\d+)?")) {
            return "number";
        }
        if (trimmed.equals("True") || trimmed.equals("False") || trimmed.equals("true") || trimmed.equals("false")) {
            return "boolean";
        }
        if (trimmed.startsWith("render_template")) {
            return "templateRender";
        }
        return "expression";
    }

    private String extractTemplateName(String returnText) {
        if (returnText == null) {
            return "";
        }
        Matcher matcher = Pattern.compile("render_template(?:_string)?\\(([^,\\)]+)").matcher(returnText);
        return matcher.find() ? matcher.group(1).trim() : "";
    }

    private void markUsedInTemplate(String variableName) {
        for (Row row : symbolTable.getRows()) {
            if (variableName.equals(row.getValue())) {
                row.setUsedInTemplate(true);
            }
        }
    }

    private void markPassedToTemplate(String variableName) {
        for (Row row : symbolTable.getRows()) {
            if (variableName.equals(row.getValue())) {
                row.setPassedToTemplate(true);
            }
        }
    }

    private String stripQuotes(String s) {
        if (s == null)
            return null;
        if ((s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'"))) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }
}
