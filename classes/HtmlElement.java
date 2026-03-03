package classes;

public class HtmlElement implements ASTNode {

    private String tagName;
    private HtmlContent[] htmlContents;
    private Attribute[] attributes;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public HtmlContent[] getHtmlContents() {
        return htmlContents;
    }

    public void setHtmlContents(HtmlContent[] htmlContents) {
        this.htmlContents = htmlContents;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nHtmlElement{");
        sb.append("\ntagName='").append(tagName).append('\'');
        if (htmlContents != null) {
            sb.append(", \nhtmlContents=");
            for (HtmlContent content : htmlContents) {
                sb.append("\n").append(content);
            }
        }
        sb.append("\n}");
        return sb.toString();
    }
}
