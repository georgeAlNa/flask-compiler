package jinja_ast;

import classes.ASTNode;

public class TemplateNode extends ASTNode {

    private final String rawContent;

    public TemplateNode(String rawContent, int line, int column) {
        this.rawContent = rawContent;
        setLine(line);
        setColumn(column);
    }

    public String getRawContent() {
        return rawContent;
    }

    @Override
    protected String getPrintLabel() {
        return "TemplateNode(content=" + quote(rawContent) + ")";
    }
}
