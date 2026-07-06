package classes;

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
        if (routeViews != null) {
            for (FlaskRouteView routeView : routeViews) {
                if (routeView.getRouteViewMetadata() == null) {
                    continue;
                }
                for (MetadataEntry entry : routeView.getRouteViewMetadata().getMetadataEntries()) {
                    if (entry instanceof TemplateEntry templateEntry
                            && templateEntry.getInlineTemplate() != null
                            && templateEntry.getInlineTemplate().getTemplateNode() != null) {
                        builder.append(templateEntry.getInlineTemplate().getTemplateNode().print()).append("\n");
                    }
                }
            }
        }
        return builder.length() == 0 ? "Jinja2 AST is empty" : builder.toString();
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
