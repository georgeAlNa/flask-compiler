package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UndefinedPythonVariableCheck implements SemanticCheck {

    private static final Pattern IDENTIFIER = Pattern.compile("\\b[a-zA-Z_][a-zA-Z0-9_]*\\b");
    private static final Pattern GENERATOR_LOOP_VAR = Pattern.compile("\\bfor\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s+in\\b");

    @Override
    public void check(SymbolTable symbolTable, List<SemanticError> errors) {
        List<Row> rows = symbolTable.getRows();

        for (Row row : rows) {
            if (!"classProperty".equals(row.getType()) || row.getAdditionalData() == null) {
                continue;
            }

            String expression = stripStrings(row.getAdditionalData().toString());
            if (isLiteralExpression(expression)) {
                continue;
            }

            Set<String> defined = collectDefinedBefore(rows, row);
            defined.addAll(collectGeneratorVariables(expression));

            Matcher matcher = IDENTIFIER.matcher(expression);
            while (matcher.find()) {
                String name = matcher.group();
                if (name.equals(row.getValue()) || isPythonBuiltin(name) || defined.contains(name)) {
                    continue;
                }
                if (isAttributeName(expression, matcher.start())) {
                    continue;
                }
                errors.add(new SemanticError(
                        "Undefined Python variable: '" + name + "'",
                        "Variable is used in expression '" + row.getValue() + " = "
                                + row.getAdditionalData() + "' before being defined in scope",
                        row.getLine(), row.getColumn(), ErrorType.REFERENCE));
            }
        }
    }

    private Set<String> collectDefinedBefore(List<Row> rows, Row current) {
        Set<String> defined = new HashSet<>();
        for (Row row : rows) {
            if (row == current) {
                break;
            }
            if ("globalVariable".equals(row.getType()) || "parameter".equals(row.getType())) {
                defined.add(row.getValue());
            }
            if ("classProperty".equals(row.getType())
                    && current.getScope() != null
                    && current.getScope().equals(row.getScope())) {
                defined.add(row.getValue());
            }
            if ("templateBinding".equals(row.getType())) {
                defined.add(row.getValue());
            }
        }
        return defined;
    }

    private Set<String> collectGeneratorVariables(String expression) {
        Set<String> names = new HashSet<>();
        Matcher matcher = GENERATOR_LOOP_VAR.matcher(expression);
        while (matcher.find()) {
            names.add(matcher.group(1));
        }
        return names;
    }

    private String stripStrings(String value) {
        return value.replaceAll("\"[^\"\\\\]*(?:\\\\.[^\"\\\\]*)*\"", "\"\"")
                .replaceAll("'[^'\\\\]*(?:\\\\.[^'\\\\]*)*'", "''");
    }

    private boolean isLiteralExpression(String expression) {
        String trimmed = expression.trim();
        return trimmed.isEmpty()
                || trimmed.matches("-?\\d+(\\.\\d+)?")
                || trimmed.equals("\"\"")
                || trimmed.equals("''")
                || trimmed.equals("True")
                || trimmed.equals("False")
                || trimmed.equals("None");
    }

    private boolean isAttributeName(String expression, int start) {
        return start > 0 && expression.charAt(start - 1) == '.';
    }

    private boolean isPythonBuiltin(String name) {
        return name.equals("request") || name.equals("redirect") || name.equals("url_for")
                || name.equals("render_template") || name.equals("render_template_string")
                || name.equals("len") || name.equals("next") || name.equals("range")
                || name.equals("int") || name.equals("str") || name.equals("float")
                || name.equals("list") || name.equals("dict") || name.equals("append")
                || name.equals("for") || name.equals("in") || name.equals("if")
                || name.equals("and") || name.equals("or") || name.equals("not")
                || name.equals("True") || name.equals("False") || name.equals("None");
    }
}
