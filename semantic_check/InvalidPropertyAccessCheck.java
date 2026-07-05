package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvalidPropertyAccessCheck implements SemanticCheck {

    @Override
    public void check(SymbolTable symbolTable, List<SemanticError> errors) {
        Map<String, Set<String>> dataKeys = collectGlobalListKeys(symbolTable);
        Map<String, String> aliases = collectPythonAliases(symbolTable);
        Map<String, String> loopSources = collectLoopSources(symbolTable);

        for (Row row : symbolTable.getRows()) {
            if (!"jinjaVariable".equals(row.getType()) || !(row.getAdditionalData() instanceof String property)) {
                continue;
            }
            String variable = row.getValue();
            String source = loopSources.getOrDefault(variable, aliases.get(variable));
            source = aliases.getOrDefault(source, source);
            if (source == null || !dataKeys.containsKey(source)) {
                continue;
            }
            if (!dataKeys.get(source).contains(property)) {
                errors.add(new SemanticError(
                        "Invalid property access: '" + variable + "." + property + "'",
                        "Property '" + property + "' does not exist in data source '" + source + "'",
                        row.getLine(), row.getColumn(), ErrorType.REFERENCE));
            }
        }
    }

    private Map<String, Set<String>> collectGlobalListKeys(SymbolTable symbolTable) {
        Map<String, Set<String>> result = new HashMap<>();
        for (Row row : symbolTable.getRows()) {
            if ("globalVariable".equals(row.getType()) && row.getAdditionalData() != null) {
                Set<String> keys = new HashSet<>();
                Matcher matcher = Pattern.compile("[\"']([a-zA-Z_][a-zA-Z0-9_]*)[\"']\\s*:").matcher(row.getAdditionalData().toString());
                while (matcher.find()) {
                    keys.add(matcher.group(1));
                }
                result.put(row.getValue(), keys);
            }
        }
        return result;
    }

    private Map<String, String> collectPythonAliases(SymbolTable symbolTable) {
        Map<String, String> aliases = new HashMap<>();
        for (Row row : symbolTable.getRows()) {
            if ("classProperty".equals(row.getType()) && row.getAdditionalData() != null) {
                String value = row.getAdditionalData().toString();
                Matcher sourceMatcher = Pattern.compile("(\\w+_data)").matcher(value);
                if (sourceMatcher.find()) {
                    aliases.put(row.getValue(), sourceMatcher.group(1));
                }
            }
        }
        return aliases;
    }

    private Map<String, String> collectLoopSources(SymbolTable symbolTable) {
        Map<String, String> loopSources = new HashMap<>();
        for (Row row : symbolTable.getRows()) {
            if ("jinjaFor".equals(row.getType()) && row.getAdditionalData() instanceof String loopVar) {
                loopSources.put(loopVar, row.getValue());
            }
        }
        return loopSources;
    }
}
