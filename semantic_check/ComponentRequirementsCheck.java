package semantic_check;

import symbol_table.Row;
import symbol_table.SymbolTable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ComponentRequirementsCheck implements SemanticCheck {

    private static final String OUTPUT_FILE = "semantic-errors.txt";

    @Override
    public void check(SymbolTable symbolTable, List<SemanticError> errors) {
        // Track template presence per-route to avoid false positives
        // when a template appears inside an if-block or for routes that
        // handle their own return (e.g. POST handlers with redirect)
        Row currentRouteRow = null;
        boolean hasTemplateForCurrentRoute = false;

        for (Row row : symbolTable.getRows()) {
            switch (row.getType()) {
                case "route" -> {
                    // Before moving to the next route, check if the previous route had a template
                    if (currentRouteRow != null && !hasTemplateForCurrentRoute) {
                        checkRouteTemplate(currentRouteRow, symbolTable, errors);
                    }
                    // Start tracking new route
                    currentRouteRow = row;
                    hasTemplateForCurrentRoute = false;
                }
                case "template" -> hasTemplateForCurrentRoute = true;
            }
        }

        // Check the last route
        if (currentRouteRow != null && !hasTemplateForCurrentRoute) {
            checkRouteTemplate(currentRouteRow, symbolTable, errors);
        }
    }

    private void checkRouteTemplate(Row routeRow, SymbolTable symbolTable, List<SemanticError> errors) {
        // Routes with if-blocks may handle returns themselves (POST handling, 404
        // check),
        // so skip the template requirement check for those
        final int routeLine = routeRow.getLine();
        boolean hasIfBlock = symbolTable.getRows().stream()
                .anyMatch(r -> r.getType().equals("ifBlock") && r.getLine() > routeLine);
        if (!hasIfBlock) {
            SemanticError err = new SemanticError(
                    "Missing required 'template' in route definition",
                    "Flask route must have a Jinja2 template defined",
                    routeRow.getLine(), routeRow.getColumn(), ErrorType.SEMANTIC);
            errors.add(err);
            appendErrorToFile(err);
        }
    }

    private void appendErrorToFile(SemanticError error) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {
            writer.write("Error:\n");
            writer.write("├─ Type: " + error.getType() + "\n");
            writer.write("├─ Message: " + error.getMessage() + "\n");
            writer.write("├─ Details: " + error.getTitle() + "\n");
            writer.write("├─ Location: Line " + error.getLine() + ", Column " + error.getColumn() + "\n");
            writer.write("└─" + "-".repeat(50) + "\n\n");
        } catch (IOException e) {
            System.err.println("Failed to write error to file: " + e.getMessage());
        }
    }
}
