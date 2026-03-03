package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jinja2VariablesCheck implements SemanticCheck {

    @Override
    public void check(SymbolTable symbolTable, List<SemanticError> errors) {
        List<String> classProperties = new ArrayList<>();
        List<Row> templateRows = new ArrayList<>();

        for (Row row : symbolTable.getRows()) {
            if ("classProperty".equals(row.getType())) {
                classProperties.add(row.getValue());
            }
            if ("template".equals(row.getType())) {
                templateRows.add(row);
            }
        }

        Pattern pattern = Pattern.compile("\\{\\{\\s*([a-zA-Z_][a-zA-Z0-9_]*)");
        Pattern forPattern = Pattern.compile("\\{%\\s*for\\s+(\\w+)\\s+in");

        for (Row templateRow : templateRows) {
            String templateContent = templateRow.getValue();
            if (templateContent == null)
                continue;

            // Extract variables defined in {% for VAR in ... %} blocks
            List<String> forLoopVars = new ArrayList<>();
            Matcher forMatcher = forPattern.matcher(templateContent);
            while (forMatcher.find()) {
                forLoopVars.add(forMatcher.group(1));
            }

            Matcher matcher = pattern.matcher(templateContent);
            while (matcher.find()) {
                String varName = matcher.group(1);
                if (varName.equals("loop") || varName.equals("self") || varName.equals("super"))
                    continue;

                // Skip variables defined in for loops (e.g., 'p' from '{% for p in items %}')
                if (forLoopVars.contains(varName))
                    continue;

                if (!classProperties.contains(varName) && !isDefinedInSymbolTable(varName, symbolTable)) {
                    SemanticError err = new SemanticError(
                            "Undefined variable in template: '{{ " + varName + " }}'",
                            "Variable '" + varName + "' is used in template but not defined in component class",
                            templateRow.getLine(), templateRow.getColumn(), ErrorType.REFERENCE);
                    errors.add(err);
                }
            }
        }
    }

    private boolean isDefinedInSymbolTable(String varName, SymbolTable symbolTable) {
        for (Row row : symbolTable.getRows()) {
            if (row.getValue() != null && row.getValue().equals(varName))
                return true;
        }
        return false;
    }
}
