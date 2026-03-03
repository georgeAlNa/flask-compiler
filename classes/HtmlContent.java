package classes;

public class HtmlContent implements ASTNode {

    private String text;

    public HtmlContent() {
    }

    public HtmlContent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "\nHtmlContent{" +
                "\ntext='" + text + '\'' +
                "\n}";
    }
}
