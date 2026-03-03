package semantic_check;

import symbol_table.SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class SemanticAnalyzer {

    private SymbolTable symbolTable;
    private List<SemanticError> errors;
    private List<SemanticCheck> checks;

    public SemanticAnalyzer(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.errors = new ArrayList<>();
        this.checks = new ArrayList<>();
        registerChecks();
    }

    public void registerChecks() {
        checks.add(new ComponentRequirementsCheck());
        checks.add(new Jinja2VariablesCheck());
        checks.add(new ForLoopSourceCheck());
        checks.add(new RouteUniquenessCheck());
    }

    public void analyze() {
        for (SemanticCheck check : checks) {
            check.check(symbolTable, errors);
        }
    }

    public void addError(String message, String details, int line, int column) {
        errors.add(new SemanticError(message, details, line, column, ErrorType.SEMANTIC));
    }

    public List<SemanticError> getErrors() {
        return errors;
    }

    public void setErrors(List<SemanticError> errors) {
        this.errors = errors;
    }

    public void printErrors() {
        if (!errors.isEmpty()) {
            System.out.println("\n=== Semantic Errors (" + errors.size() + ") ===");
            for (int i = 0; i < errors.size(); i++) {
                SemanticError error = errors.get(i);
                System.out.println("\nError #" + (i + 1) + ":");
                System.out.println("├─ Type:     " + error.getType());
                System.out.println("├─ Message:  " + error.getMessage());
                System.out.println("├─ Details:  " + error.getTitle());
                System.out.println("├─ Location: Line " + error.getLine() + ", Column " + error.getColumn());
                System.out.println("└─" + "─".repeat(50));
            }
        } else {
            System.out.println("\n✓ No semantic errors found.");
        }
    }
}
