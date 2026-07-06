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
        checks.add(new UndefinedJinjaVariableCheck());
        checks.add(new UndefinedPythonVariableCheck());
        checks.add(new ForLoopSourceCheck());
        checks.add(new RouteUniquenessCheck());
        checks.add(new RouteFunctionUniquenessCheck());
        checks.add(new JinjaIfConditionCheck());
        checks.add(new ProductRequiredFieldsCheck());
        checks.add(new InvalidPropertyAccessCheck());
        checks.add(new EmptyDataListCheck());
        checks.add(new RouteTemplateRequirementsCheck());
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
                System.out.println("| Type:     " + error.getType());
                System.out.println("| Message:  " + error.getMessage());
                System.out.println("| Details:  " + error.getTitle());
                System.out.println("| Location: Line " + error.getLine() + ", Column " + error.getColumn());
                System.out.println("+--------------------------------------------------");
            }
        } else {
            System.out.println("\n[OK] No semantic errors found.");
        }
    }
}
