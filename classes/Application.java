package classes;

import python_ast.PythonProgramNode;

import java.util.ArrayList;
import java.util.List;

public class Application extends ComponentNode {

    private List<FlaskComponent> components = new ArrayList<>();
    private PythonProgramNode pythonProgramNode;
    /**
     * Raw Python text of global variable declarations, e.g. "products_data = [...]"
     */
    private List<String> globalDeclarations = new ArrayList<>();

    public List<FlaskComponent> getComponents() {
        return components;
    }

    public void addComponent(FlaskComponent component) {
        if (component != null) {
            components.add(component);
            addChild(component);
        }
    }

    public void setComponents(List<FlaskComponent> components) {
        this.components = components;
        if (components != null) {
            for (FlaskComponent component : components) {
                addChild(component);
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
        if (components != null) {
            for (FlaskComponent component : components) {
                if (component.getComponentMetadata() == null) {
                    continue;
                }
                for (MetadataEntry entry : component.getComponentMetadata().getMetadataEntries()) {
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
        if (components != null) {
            for (FlaskComponent component : components) {
                sb.append("\n").append(component);
            }
        }
        sb.append("\n}");
        return sb.toString();
    }
}
