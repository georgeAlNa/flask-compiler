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
            if (!"jinjaFor".equals(row.getType())) {
                continue;
            }

            String sourceVar = row.getValue();
            Row sourceRow = null;

            // Check declared local properties, imported vars, global vars,
            // and keyword args passed in render_template_string calls.
            for (Row r : rows) {
                if ("classProperty".equals(r.getType())
                        && sourceVar.equals(r.getValue())
                        && sameScope(row, r)) {
                    sourceRow = r;
                    break;
                }
                if ("importedVar".equals(r.getType()) && sourceVar.equals(r.getValue())) {
                    sourceRow = r;
                    break;
                }
                if ("globalVariable".equals(r.getType()) && sourceVar.equals(r.getValue())) {
                    sourceRow = r;
                    break;
                }
                if ("templateBinding".equals(r.getType())
                        && sourceVar.equals(r.getValue())
                        && sameScope(row, r)) {
                    sourceRow = resolveBindingTarget(rows, r);
                    break;
                }
            }

            // Also valid if it appears as a keyword arg key in a return statement.
            if (sourceRow == null && returnKwArgKeys.contains(sourceVar)) {
                sourceRow = new Row();
                sourceRow.setValue(sourceVar);
                sourceRow.setDataType("unknown");
            }

            if (sourceRow == null) {
                errors.add(new SemanticError(
                        "{% for %} iterates over undefined source: '" + sourceVar + "'",
                        "Variable '" + sourceVar + "' used in for loop is not defined in component",
                        row.getLine(), row.getColumn(), ErrorType.REFERENCE));
            } else if (sourceRow.getDataType() != null
                    && !"list".equals(sourceRow.getDataType())
                    && !"unknown".equals(sourceRow.getDataType())) {
                errors.add(new SemanticError(
                        "{% for %} iterates over non-list source: '" + sourceVar + "'",
                        "Variable '" + sourceVar + "' has type '" + sourceRow.getDataType()
                                + "' but a Jinja2 for loop requires a list-like value",
                        row.getLine(), row.getColumn(), ErrorType.TYPE));
            }
        }
    }

    private Row resolveBindingTarget(List<Row> rows, Row bindingRow) {
        if (!(bindingRow.getAdditionalData() instanceof String targetName)) {
            return bindingRow;
        }
        for (Row row : rows) {
            if (targetName.equals(row.getValue())
                    && ("globalVariable".equals(row.getType())
                    || "classProperty".equals(row.getType())
                    || "parameter".equals(row.getType()))) {
                return row;
            }
        }
        return bindingRow;
    }

    private boolean sameScope(Row left, Row right) {
        if (left.getScope() == null || right.getScope() == null) {
            return false;
        }
        return left.getScope().equals(right.getScope());
    }
}
