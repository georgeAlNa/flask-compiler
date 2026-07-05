package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductRequiredFieldsCheck implements SemanticCheck {

    @Override
    public void check(SymbolTable symbolTable, List<SemanticError> errors) {
        for (Row row : symbolTable.getRows()) {
            if (!"globalVariable".equals(row.getType()) || row.getAdditionalData() == null) {
                continue;
            }
            String raw = row.getAdditionalData().toString();
            if (!row.getValue().toLowerCase().contains("product")) {
                continue;
            }

            Matcher dictMatcher = Pattern.compile("\\{([^{}]*)\\}", Pattern.DOTALL).matcher(raw);
            int index = 0;
            while (dictMatcher.find()) {
                index++;
                String dict = dictMatcher.group(1);
                if (!hasKey(dict, "name") || !hasKey(dict, "price")) {
                    errors.add(new SemanticError(
                            "Product item is missing required fields",
                            "Product #" + index + " must contain both 'name' and 'price'",
                            row.getLine(), row.getColumn(), ErrorType.STRUCTURAL));
                }
            }
        }
    }

    private boolean hasKey(String dict, String key) {
        return dict.contains("\"" + key + "\"") || dict.contains("'" + key + "'");
    }
}
