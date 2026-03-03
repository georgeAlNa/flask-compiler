package classes;

import java.util.ArrayList;
import java.util.List;

public class StylesContent implements ASTNode {

    private String rawCss;
    private List<CssContent> cssContents = new ArrayList<>();

    public StylesContent() {
    }

    public StylesContent(String rawCss) {
        this.rawCss = rawCss;
    }

    public String getRawCss() {
        return rawCss;
    }

    public void setRawCss(String rawCss) {
        this.rawCss = rawCss;
    }

    public List<CssContent> getCssContents() {
        return cssContents;
    }

    public void setCssContents(List<CssContent> cssContents) {
        this.cssContents = cssContents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nStylesContent{");
        if (cssContents != null && !cssContents.isEmpty()) {
            for (CssContent content : cssContents) {
                sb.append("\n").append(content);
            }
        } else if (rawCss != null) {
            sb.append("\nrawCss='").append(rawCss).append('\'');
        }
        sb.append("\n}");
        return sb.toString();
    }
}
