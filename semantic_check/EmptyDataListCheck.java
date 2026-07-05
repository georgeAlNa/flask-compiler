package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.List;

public class EmptyDataListCheck implements SemanticCheck {

    @Override
    public void check(SymbolTable symbolTable, List<SemanticError> errors) {
        for (Row row : symbolTable.getRows()) {
            if (!"globalVariable".equals(row.getType()) || row.getAdditionalData() == null) {
                continue;
            }
            String raw = row.getAdditionalData().toString();
            String compact = raw.replaceAll("\\s+", "");
            if (compact.endsWith("=[]") || compact.contains("=[{}]") || !raw.contains("{")) {
                errors.add(new SemanticError(
                        "Empty or invalid data list: '" + row.getValue() + "'",
                        "Data lists passed to Jinja2 should contain at least one dictionary item",
                        row.getLine(), row.getColumn(), ErrorType.STRUCTURAL));
            }
        }
    }
}
