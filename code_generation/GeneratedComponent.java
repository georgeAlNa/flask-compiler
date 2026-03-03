package code_generation;

public class GeneratedComponent {

    private final String py;
    private final String html;
    private final String css;
    private final String componentName;

    public GeneratedComponent(String py, String html, String css, String componentName) {
        this.py            = py;
        this.html          = html;
        this.css           = css;
        this.componentName = componentName;
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

    public String getComponentName() {
        return componentName;
    }

    public String getTs() {
        return py;
    }
}
