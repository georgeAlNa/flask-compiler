package code_generation;

public class GeneratedRouteView {

    private final String py;
    private final String html;
    private final String css;
    private final String viewName;

    public GeneratedRouteView(String py, String html, String css, String viewName) {
        this.py            = py;
        this.html          = html;
        this.css           = css;
        this.viewName = viewName;
    }

    public String getPy() {
        return py;
    }

    public String getHtml() {
        return html;
    }

    public String getCss() {
        return css;
    }

    public String getViewName() {
        return viewName;
    }
}
