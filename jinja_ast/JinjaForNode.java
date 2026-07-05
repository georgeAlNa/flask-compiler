package jinja_ast;

import classes.ASTNode;

public class JinjaForNode extends ASTNode {

    private final String itemName;
    private final String sourceName;

    public JinjaForNode(String itemName, String sourceName, int line, int column) {
        this.itemName = itemName;
        this.sourceName = sourceName;
        setLine(line);
        setColumn(column);
    }

    public String getItemName() {
        return itemName;
    }

    public String getSourceName() {
        return sourceName;
    }

    @Override
    protected String getPrintLabel() {
        return "JinjaForNode(variable=" + quote(itemName) + ", source=" + quote(sourceName) + ")";
    }
}
