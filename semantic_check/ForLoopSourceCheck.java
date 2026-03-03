package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForLoopSourceCheck implements SemanticCheck {

    @Override
    public void check(SymbolTable symbolTable, List<SemanticError> errors) {
        List<Row> rows = symbolTable.getRows();

        Pattern forPattern = Pattern.compile("\\{%\\s*for\\s+\\w+\\s+in\\s+(\\w+)\\s*%\\}");
        // Pattern to extract keyword argument keys from return statements (e.g.
        // items=products_data)
        Pattern kwArgPattern = Pattern.compile("(\\w+)=\\w+");

        // Collect all keyword arg keys used in return statements (these are valid
        // template context vars)
        Set<String> returnKwArgKeys = new HashSet<>();
        for (Row r : rows) {
            if ("returnStatement".equals(r.getType()) && r.getValue() != null) {
                Matcher km = kwArgPattern.matcher(r.getValue());
                while (km.find()) {
                    returnKwArgKeys.add(km.group(1));
                }
            }
        }

        for (Row row : rows) {
            if ("template".equals(row.getType()) && row.getValue() != null) {
                Matcher matcher = forPattern.matcher(row.getValue());
                while (matcher.find()) {
                    String sourceVar = matcher.group(1);
                    boolean found = false;

                    // Check declared local properties, imported vars, global vars,
                    // and keyword args passed in render_template_string calls
                    for (Row r : rows) {
                        if ("classProperty".equals(r.getType()) && sourceVar.equals(r.getValue())) {
                            found = true;
                            break;
                        }
                        if ("importedVar".equals(r.getType()) && sourceVar.equals(r.getValue())) {
                            found = true;
                            break;
                        }
                        if ("globalVariable".equals(r.getType()) && sourceVar.equals(r.getValue())) {
                            found = true;
                            break;
                        }
                    }
                    // Also valid if it appears as a keyword arg key in a return statement
                    if (!found && returnKwArgKeys.contains(sourceVar)) {
                        found = true;
                    }

                    if (!found) {
                        errors.add(new SemanticError(
                                "{% for %} iterates over undefined source: '" + sourceVar + "'",
                                "Variable '" + sourceVar + "' used in for loop is not defined in component",
                                row.getLine(), row.getColumn(), ErrorType.REFERENCE));
                    }
                }
            }
        }
    }
}
