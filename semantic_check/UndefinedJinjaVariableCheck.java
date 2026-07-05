package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UndefinedJinjaVariableCheck implements SemanticCheck {

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
            if ("jinjaFor".equals(row.getType()) && row.getAdditionalData() instanceof String loopVar) {
                loopVariables.add(loopVar);
            }
        }

        for (Row row : symbolTable.getRows()) {
            if (!"jinjaVariable".equals(row.getType())) {
                continue;
            }
            String variable = row.getValue();
            if (variable == null || isBuiltIn(variable) || defined.contains(variable) || loopVariables.contains(variable)) {
                continue;
            }
            errors.add(new SemanticError(
                    "Undefined Jinja2 variable: '{{ " + variable + " }}'",
                    "Variable is used in a template but was not defined in Python data or route context",
                    row.getLine(), row.getColumn(), ErrorType.REFERENCE));
        }
    }

    private boolean isBuiltIn(String variable) {
        return variable.equals("loop") || variable.equals("self") || variable.equals("super");
    }
}
