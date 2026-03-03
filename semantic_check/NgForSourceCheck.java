package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NgForSourceCheck implements SemanticCheck {

    @Override
    public void check(SymbolTable symbolTable, List<SemanticError> errors) {
        List<Row> rows = symbolTable.getRows();

        Pattern forPattern = Pattern.compile("\\{%\\s*for\\s+\\w+\\s+in\\s+(\\w+)\\s*%\\}");

        for (Row row : rows) {
            if ("template".equals(row.getType()) && row.getValue() != null) {
                Matcher matcher = forPattern.matcher(row.getValue());
                while (matcher.find()) {
                    String sourceVar = matcher.group(1);
                    boolean found = false;

                    for (Row r : rows) {
                        if ("classProperty".equals(r.getType()) && sourceVar.equals(r.getValue())) {
                            found = true;
                            break;
                        }
                        if ("importedVar".equals(r.getType()) && sourceVar.equals(r.getValue())) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        errors.add(new SemanticError(
                            "{% for %} iterates over undefined source: '" + sourceVar + "'",
                            "Variable '" + sourceVar + "' used in for loop is not defined in component",
                            row.getLine(), row.getColumn(), ErrorType.REFERENCE
                        ));
                    }
                }
            }
        }
    }
}
