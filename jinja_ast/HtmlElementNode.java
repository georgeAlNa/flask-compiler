package jinja_ast;

import classes.ASTNode;

public class HtmlElementNode extends ASTNode {

    private final String tagName;

    public HtmlElementNode(String tagName, int line, int column) {
        this.tagName = tagName;
        setLine(line);
        setColumn(column);
    }

    public String getTagName() {
        return tagName;
    }
}
