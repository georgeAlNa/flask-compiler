package jinja_ast;

import classes.ASTNode;

public class JinjaIfNode extends ASTNode {

    private final String condition;

    public JinjaIfNode(String condition, int line, int column) {
        this.condition = condition;
        setLine(line);
        setColumn(column);
    }

    public String getCondition() {
        return condition;
    }
}
