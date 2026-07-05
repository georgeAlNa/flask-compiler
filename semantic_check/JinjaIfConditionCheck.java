package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JinjaIfConditionCheck implements SemanticCheck {

    private static final Pattern IDENTIFIER = Pattern.compile("\\b[a-zA-Z_][a-zA-Z0-9_]*\\b");

    @Override
    public void check(SymbolTable symbolTable, List<SemanticError> errors) {
        Set<String> defined = new HashSet<>();
        Set<String> loopVariables = new HashSet<>();

        for (Row row : symbolTable.getRows()) {
            if ("PYTHON".equals(row.getOrigin())
                    && ("classProperty".equals(row.getType())
                    || "globalVariable".equals(row.getType())
                    || "parameter".equals(row.getType()))) {
                defined.add(row.getValue());
            }
            if ("templateBinding".equals(row.getType())) {
                defined.add(row.getValue());
            }
            if ("jinjaFor".equals(row.getType()) && row.getAdditionalData() instanceof String loopVar) {
                loopVariables.add(loopVar);
            }
        }

        for (Row row : symbolTable.getRows()) {
            if (!"jinjaIf".equals(row.getType()) || row.getValue() == null) {
                continue;
            }
            Matcher matcher = IDENTIFIER.matcher(row.getValue());
            while (matcher.find()) {
                String name = matcher.group();
                if (isKeyword(name) || defined.contains(name) || loopVariables.contains(name)) {
                    continue;
                }
                errors.add(new SemanticError(
                        "Undefined variable in Jinja2 if condition: '" + name + "'",
                        "The if condition references a variable that is not defined in Python data or template scope",
                        row.getLine(), row.getColumn(), ErrorType.REFERENCE));
            }
        }
    }

    private boolean isKeyword(String name) {
        return name.equals("and") || name.equals("or") || name.equals("not")
                || name.equals("true") || name.equals("false")
                || name.equals("True") || name.equals("False")
                || name.equals("none") || name.equals("None")
                || name.equals("is") || name.equals("defined");
    }
}
