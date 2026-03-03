package code_generation;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComponentView implements View {

    protected abstract String getSelector();

    protected abstract String getClassName();

    protected abstract String generateTemplate();

    protected abstract String generateStyles();

    protected abstract String generateLogic();

    protected abstract String generateImports();

    protected abstract String getRoute();

    /**
     * Override to provide HTTP methods for the route decorator.
     * Returns null by default (no methods clause).
     */
    protected java.util.List<String> getRouteMethods() {
        return null;
    }

    /**
     * Generate the Flask route function for app.py
     */
    protected String assembleComponent() {
        StringBuilder sb = new StringBuilder();
        String funcName = toSnakeCase(getClassName());
        if (funcName.equals("app"))
            funcName = "index";

        String route = getRoute();
        sb.append("@app.route('").append(route).append("'");
        java.util.List<String> routeMethods = getRouteMethods();
        if (routeMethods != null && !routeMethods.isEmpty()) {
            sb.append(", methods=[");
            for (int i = 0; i < routeMethods.size(); i++) {
                if (i > 0)
                    sb.append(", ");
                sb.append("'").append(routeMethods.get(i)).append("'");
            }
            sb.append("]");
        }
        sb.append(")\n");

        if (route.contains("<int:id>")) {
            sb.append("def ").append(funcName).append("(id):\n");
        } else {
            sb.append("def ").append(funcName).append("():\n");
        }

        // Emit pre-return raw code lines (complex expressions like generator
        // expressions)
        // These come before if-blocks because they may set up variables used in
        // conditions
        String preReturnCode = "";
        String ifBlockCode = "";
        if (this instanceof GenericView gv) {
            preReturnCode = gv.getPreReturnCode();
            ifBlockCode = gv.getIfBlockCode();
        }
        if (!preReturnCode.isEmpty()) {
            for (String line : preReturnCode.split("\n")) {
                sb.append("    ").append(line).append("\n");
            }
        }

        // Emit raw if-block code (POST handling, 404 checks, etc.)
        if (!ifBlockCode.isEmpty()) {
            for (String line : ifBlockCode.split("\n")) {
                sb.append("    ").append(line).append("\n");
            }
        }

        // Emit GET-path variables and return
        String logic = generateLogic();
        List<String> varNames = new ArrayList<>();

        if (!logic.isEmpty()) {
            String[] lines = logic.split("\n");
            for (String line : lines) {
                line = line.trim();
                if (line.contains("=") && !line.startsWith("}") && !line.isEmpty()) {
                    if (line.endsWith(";"))
                        line = line.substring(0, line.length() - 1);
                    String varName = line.split("=")[0].trim();
                    String varValue = line.substring(line.indexOf("=") + 1).trim();
                    if (varValue.equals("null"))
                        varValue = "None";
                    sb.append("    ").append(varName).append(" = ").append(varValue).append("\n");
                    varNames.add(varName);
                }
            }
        }

        sb.append("    return render_template('").append(getClassName()).append(".html'");
        if (!varNames.isEmpty()) {
            for (String v : varNames) {
                sb.append(", ").append(v).append("=").append(v);
            }
        }
        // Also include pre-return variables in the render_template call
        if (!preReturnCode.isEmpty()) {
            for (String line : preReturnCode.split("\n")) {
                line = line.trim();
                if (line.contains("=")) {
                    String varName = line.split("=")[0].trim();
                    if (!varNames.contains(varName)) {
                        sb.append(", ").append(varName).append("=").append(varName);
                    }
                }
            }
        }
        sb.append(")\n");

        return sb.toString();
    }

    /**
     * Generate Jinja2 template that extends base.html
     */
    protected String assembleHtml() {
        String template = generateTemplate();

        StringBuilder html = new StringBuilder();
        html.append("{% extends 'base.html' %}\n\n");
        html.append("{% block title %}").append(formatTitle(getClassName())).append("{% endblock %}\n\n");
        html.append("{% block content %}\n");

        if (template != null && !template.trim().isEmpty()) {
            String[] lines = template.split("\n");
            for (String line : lines) {
                html.append(line).append("\n");
            }
        }

        html.append("{% endblock %}\n");
        return html.toString();
    }

    /**
     * Format CSS from minified to readable multiline format
     */
    protected String assembleCss() {
        String raw = generateStyles();
        if (raw == null || raw.trim().isEmpty())
            return "";

        // Add spaces between compound CSS value tokens
        raw = raw.replaceAll("(\\d+(?:px|em|rem|%|vh|vw|pt|cm|mm|in|ex|ch|vmin|vmax))([a-zA-Z#])", "$1 $2");
        raw = raw.replaceAll("([a-zA-Z])(#[0-9a-fA-F])", "$1 $2");
        raw = raw.replaceAll(":", ": ");
        raw = raw.replaceAll("  +", " ");

        StringBuilder formatted = new StringBuilder();
        int indent = 0;

        for (int i = 0; i < raw.length(); i++) {
            char c = raw.charAt(i);
            if (c == '{') {
                formatted.append(" {\n");
                indent++;
                appendIndent(formatted, indent);
            } else if (c == '}') {
                formatted.append("\n");
                indent--;
                appendIndent(formatted, indent);
                formatted.append("}\n\n");
                if (i + 1 < raw.length() && raw.charAt(i + 1) != '}') {
                    appendIndent(formatted, indent);
                }
            } else if (c == ';') {
                formatted.append(";\n");
                if (i + 1 < raw.length() && raw.charAt(i + 1) != '}') {
                    appendIndent(formatted, indent);
                }
            } else {
                formatted.append(c);
            }
        }

        return formatted.toString().trim() + "\n";
    }

    private void appendIndent(StringBuilder sb, int level) {
        for (int i = 0; i < level; i++)
            sb.append("    ");
    }

    @Override
    public final GeneratedComponent generate() {
        String pyCode = assembleComponent();
        String htmlCode = assembleHtml();
        String cssCode = assembleCss();
        return new GeneratedComponent(pyCode, htmlCode, cssCode, getClassName());
    }

    private String toSnakeCase(String className) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < className.length(); i++) {
            char c = className.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i > 0)
                    sb.append('_');
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String formatTitle(String className) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < className.length(); i++) {
            char c = className.charAt(i);
            if (Character.isUpperCase(c) && i > 0)
                sb.append(' ');
            sb.append(c);
        }
        return sb.toString();
    }
}
