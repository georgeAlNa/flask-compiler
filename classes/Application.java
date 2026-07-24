package classes;

import jinja_ast.TemplateNode;
import python_ast.PythonProgramNode;

import java.util.ArrayList;
import java.util.List;

public class Application extends CompilerAstNode {

    private List<FlaskRouteView> routeViews = new ArrayList<>();
    private PythonProgramNode pythonProgramNode;
    /**
     * Raw Python text of global variable declarations, e.g. "products_data = [...]"
     */
    private List<String> globalDeclarations = new ArrayList<>();

    public List<FlaskRouteView> getRouteViews() {
        return routeViews;
    }

    public void addRouteView(FlaskRouteView routeView) {
        if (routeView != null) {
            routeViews.add(routeView);
            addChild(routeView);
        }
    }

    public void setRouteViews(List<FlaskRouteView> routeViews) {
        this.routeViews = routeViews;
        if (routeViews != null) {
            for (FlaskRouteView routeView : routeViews) {
                addChild(routeView);
            }
        }
    }

    public List<String> getGlobalDeclarations() {
        return globalDeclarations;
    }

    public PythonProgramNode getPythonProgramNode() {
        return pythonProgramNode;
    }

    public void setPythonProgramNode(PythonProgramNode pythonProgramNode) {
        this.pythonProgramNode = pythonProgramNode;
        addChild(pythonProgramNode);
    }

    public String printPythonAst() {
        return pythonProgramNode != null ? pythonProgramNode.print() : "Python AST is empty";
    }

    public String printJinjaAst() {
        StringBuilder builder = new StringBuilder();
        for (TemplateNode templateNode : getJinjaTemplateNodes()) {
            builder.append(templateNode.print()).append("\n");
        }
        return builder.length() == 0 ? "Jinja2 AST is empty" : builder.toString();
    }

    public String pythonAstJson() {
        return pythonProgramNode != null
                ? pythonProgramNode.toJson()
                : "{\n  \"type\": \"PythonProgramNode\",\n  \"label\": \"Python AST is empty\",\n  \"children\": []\n}";
    }

    public String jinjaAstJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        builder.append("  \"type\": \"JinjaAst\",\n");
        builder.append("  \"templates\": [");
        List<TemplateNode> templates = getJinjaTemplateNodes();
        if (!templates.isEmpty()) {
            builder.append("\n");
            for (int i = 0; i < templates.size(); i++) {
                builder.append(indentJson(templates.get(i).toJson(), "    "));
                if (i < templates.size() - 1) {
                    builder.append(",");
                }
                builder.append("\n");
            }
            builder.append("  ");
        }
        builder.append("]\n");
        builder.append("}\n");
        return builder.toString();
    }

    private List<TemplateNode> getJinjaTemplateNodes() {
        List<TemplateNode> templates = new ArrayList<>();
        if (routeViews == null) {
            return templates;
        }
        for (FlaskRouteView routeView : routeViews) {
            if (routeView.getRouteViewMetadata() == null) {
                continue;
            }
            for (MetadataEntry entry : routeView.getRouteViewMetadata().getMetadataEntries()) {
                if (entry instanceof TemplateEntry templateEntry
                        && templateEntry.getInlineTemplate() != null
                        && templateEntry.getInlineTemplate().getTemplateNode() != null) {
                    templates.add(templateEntry.getInlineTemplate().getTemplateNode());
                }
            }
        }
        return templates;
    }

    private String indentJson(String json, String indent) {
        return indent + json.replace("\n", "\n" + indent);
    }

    public String printFullAst() {
        return print();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nApplication{");
        sb.append("\npythonAst=\n").append(printPythonAst());
        if (routeViews != null) {
            for (FlaskRouteView routeView : routeViews) {
                sb.append("\n").append(routeView);
            }
        }
        sb.append("\n}");
        return sb.toString();
    }
}
