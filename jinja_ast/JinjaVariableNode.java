package jinja_ast;

import classes.ASTNode;

public class JinjaVariableNode extends ASTNode {

    private final String variableName;
    private final String propertyName;

    public JinjaVariableNode(String variableName, String propertyName, int line, int column) {
        this.variableName = variableName;
        this.propertyName = propertyName;
        setLine(line);
        setColumn(column);
    }

    public String getVariableName() {
        return variableName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    @Override
    protected String getPrintLabel() {
        String expression = propertyName == null ? variableName : variableName + "." + propertyName;
        return "JinjaVariableNode(expression=" + quote(expression) + ")";
    }
}
