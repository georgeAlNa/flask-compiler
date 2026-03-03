package classes;

public class InlineTemplate implements ASTNode {

    private String rawContent;
    private HtmlDocument htmlDocument;

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
    }

    @Override
    public String toString() {
        return "\nInlineTemplate{" +
                "\nhtmlDocument=" + htmlDocument +
                "\n}";
    }
}
