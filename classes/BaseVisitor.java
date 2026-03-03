package classes;

import FlaskGen.FlaskParser;
import FlaskGen.FlaskParserBaseVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import semantic_check.SemanticAnalyzer;
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
    /**
     * Stores raw Python text of global variable declarations for emission in app.py
     */
    private final List<String> globalDeclarationLines = new ArrayList<>();

    // â”€â”€â”€ Application Root
    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

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
            FlaskComponent component = (FlaskComponent) visit(rd);
            if (component != null) {
                application.getComponents().add(component);
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
        return application;
    }

    // â”€â”€â”€ Import Statement
    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

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

    // â”€â”€â”€ App Declaration
    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

    @Override
    public Object visitAppDef(FlaskParser.AppDefContext ctx) {
        String text = ctx.IDENTIFIER(0).getText() + " = " +
                ctx.IDENTIFIER(1).getText() + "(" +
                ctx.DUNDER_NAME().getText() + ")";
        addRow("appDeclaration", text, ctx.start);
        return null;
    }

    // â”€â”€â”€ Global Assignment
    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

    @Override
    public Object visitGlobalListDef(FlaskParser.GlobalListDefContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        addRow("globalVariable", varName, ctx.start);
        // Capture the raw source text of the entire global declaration for code gen
        String rawDecl = getRawText(ctx);
        globalDeclarationLines.add(rawDecl);
        return null;
    }

    // â”€â”€â”€ Main Guard
    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

    @Override
    public Object visitMainGuardDef(FlaskParser.MainGuardDefContext ctx) {
        addRow("mainGuard", "if __name__ == \"__main__\"", ctx.start);
        return null;
    }

    // â”€â”€â”€ Route Definition
    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

    @Override
    public FlaskComponent visitRouteDef(FlaskParser.RouteDefContext ctx) {
        FlaskComponent component = new FlaskComponent();
        ComponentMetadata metadata = new ComponentMetadata();

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
                    addRow("classProperty", varName, vaCtx.start);

                    // Detect complex expressions (function calls, generators, list access, etc.)
                    // Simple values are: string literals, numbers, None/True/False, plain
                    // identifiers
                    boolean isComplex = varValue.contains("(") || varValue.contains("[")
                            || varValue.contains("{") || varValue.contains(".");
                    if (isComplex) {
                        // Store as raw pre-return line for verbatim emission
                        String rawLine = varName + " = " + varValue;
                        component.getPreReturnRawLines().add(rawLine);
                    }

                    PropertyDeclaration prop = new PropertyDeclaration();
                    prop.setIdentifier(varName);
                    prop.setValue(varValue);

                    ClassMember member = new ClassMember(vaCtx);
                    member.setPropertyDeclaration(prop);
                    members.add(member);

                } else if (stmtCtx instanceof FlaskParser.BodyTemplateAssignmentContext taCtx) {
                    String templateContent = taCtx.TRIPLE_QUOTE_STRING().getText();
                    addRow("template", templateContent, taCtx.start);

                    InlineTemplate inlineTemplate = new InlineTemplate(templateContent);
                    metadata.getMetadataEntries().add(new TemplateEntry(inlineTemplate));

                } else if (stmtCtx instanceof FlaskParser.BodyReturnStatementContext rsCtx) {
                    String returnText = getRawText(rsCtx.pyExpression());
                    addRow("returnStatement", returnText, rsCtx.start);

                    // Parse keyword arguments: e.g. render_template_string(template,
                    // items=products_data, label=label)
                    Pattern kwArgPattern = Pattern.compile("(\\w+)=(\\w+(?:\\.\\w+)*)");
                    Matcher m = kwArgPattern.matcher(returnText);
                    while (m.find()) {
                        String kwKey = m.group(1);
                        String kwValue = m.group(2);
                        if (!kwKey.equals("template") && !kwKey.equals("debug")) {
                            returnKwArgs.put(kwKey, kwValue);
                        }
                    }

                } else if (stmtCtx instanceof FlaskParser.BodyIfBlockContext ibCtx) {
                    FlaskParser.IfBlockDefContext ifDef = (FlaskParser.IfBlockDefContext) ibCtx.ifBlock();
                    String ifExprText = getRawText(ifDef.pyExpression(0));
                    addRow("ifBlock", "if " + ifExprText, ibCtx.start);

                    // Capture the entire if-block as raw Python source text
                    String rawIfBlock = getRawText(ifDef);
                    component.getIfBlockRawCode().add(rawIfBlock);

                    // Visit nested statements inside if block for symbol table
                    for (FlaskParser.InnerBodyStatementContext innerStmt : ifDef.innerBodyStatement()) {
                        if (innerStmt instanceof FlaskParser.InnerBodyVarAssignmentContext innerVa) {
                            addRow("classProperty", innerVa.IDENTIFIER().getText(), innerVa.start);
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
                    addRow("classProperty", kwKey, bodyCtx.start);
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

        component.setComponentMetadata(metadata);
        component.setFlaskClass(flaskClass);
        return component;
    }

    // â”€â”€â”€ Helpers
    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

    private void addRow(String type, String value, Token token) {
        Row row = new Row();
        row.setType(type);
        row.setValue(value);
        row.setLine(token.getLine());
        row.setColumn(token.getCharPositionInLine());
        symbolTable.getRows().add(row);
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

    private String stripQuotes(String s) {
        if (s == null)
            return null;
        if ((s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'"))) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }
}
