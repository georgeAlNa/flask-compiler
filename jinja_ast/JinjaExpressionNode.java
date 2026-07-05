package jinja_ast;

import classes.ASTNode;

public class JinjaExpressionNode extends ASTNode {

    private final String expression;

    public JinjaExpressionNode(String expression, int line, int column) {
        this.expression = expression;
        setLine(line);
        setColumn(column);
    }

    public String getExpression() {
        return expression;
    }
}
