package classes;

import jinja_ast.TemplateNode;

public class InlineTemplate extends ASTNode {

    private String rawContent;
    private HtmlDocument htmlDocument;
    private TemplateNode templateNode;

    public InlineTemplate() {
    }

    public InlineTemplate(String rawContent) {
        this.rawContent = rawContent;
    }

    public String getRawContent() {
        return rawContent;
    }

    public void setRawContent(String rawContent) {
        this.rawContent = rawContent;
    }

    public HtmlDocument getHtmlDocument() {
        return htmlDocument;
    }

    public void setHtmlDocument(HtmlDocument htmlDocument) {
        this.htmlDocument = htmlDocument;
        addChild(htmlDocument);
    }

    public TemplateNode getTemplateNode() {
        return templateNode;
    }

    public void setTemplateNode(TemplateNode templateNode) {
        this.templateNode = templateNode;
        addChild(templateNode);
    }

    @Override
    public String toString() {
        return "\nInlineTemplate{" +
                "\ntemplateNode=\n" + (templateNode != null ? templateNode.print() : "null") +
                "\n}";
    }
}
