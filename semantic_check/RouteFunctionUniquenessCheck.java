package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RouteFunctionUniquenessCheck implements SemanticCheck {

    @Override
    public void check(SymbolTable symbolTable, List<SemanticError> errors) {
        Set<String> functionNames = new HashSet<>();
        for (Row row : symbolTable.getRows()) {
            if (!"routeFunction".equals(row.getType())) {
                continue;
            }
            String functionName = row.getValue();
            if (!functionNames.add(functionName)) {
                errors.add(new SemanticError(
                        "Duplicate route function defined: '" + functionName + "'",
                        "Each Flask route function should have a unique Python function name",
                        row.getLine(), row.getColumn(), ErrorType.SEMANTIC));
            }
        }
    }
}
