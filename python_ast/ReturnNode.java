package python_ast;

import classes.ASTNode;

public class ReturnNode extends ASTNode {

    private final String expression;

    public ReturnNode(String expression, int line, int column) {
        this.expression = expression;
        setLine(line);
        setColumn(column);
    }

    public String getExpression() {
        return expression;
    }

    @Override
    protected String getPrintLabel() {
        return "ReturnNode(expression=" + quote(expression) + ")";
    }
}
