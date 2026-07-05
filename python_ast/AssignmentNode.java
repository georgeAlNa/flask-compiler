package python_ast;

import classes.ASTNode;

public class AssignmentNode extends ASTNode {

    private final String variableName;
    private final String value;

    public AssignmentNode(String variableName, String value, int line, int column) {
        this.variableName = variableName;
        this.value = value;
        setLine(line);
        setColumn(column);
    }

    public String getVariableName() {
        return variableName;
    }

    public String getValue() {
        return value;
    }

    @Override
    protected String getPrintLabel() {
        return "AssignmentNode(name=" + quote(variableName) + ", value=" + quote(value) + ")";
    }
}
