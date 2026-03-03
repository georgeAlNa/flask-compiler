package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class RouteUniquenessCheck implements SemanticCheck {

    @Override
    public void check(SymbolTable symbolTable, List<SemanticError> errors) {
        List<String> routes = new ArrayList<>();

        for (Row row : symbolTable.getRows()) {
            if ("route".equals(row.getType())) {
                String route = row.getValue();
                if (routes.contains(route)) {
                    errors.add(new SemanticError(
                        "Duplicate route defined: '" + route + "'",
                        "Each Flask component must have a unique route",
                        row.getLine(), row.getColumn(), ErrorType.SEMANTIC
                    ));
                } else {
                    routes.add(route);
                }
            }
        }
    }
}
