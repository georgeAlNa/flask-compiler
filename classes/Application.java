package classes;

import java.util.ArrayList;
import java.util.List;

public class Application extends ComponentNode {

    private List<FlaskComponent> components = new ArrayList<>();
    /**
     * Raw Python text of global variable declarations, e.g. "products_data = [...]"
     */
    private List<String> globalDeclarations = new ArrayList<>();

    public List<FlaskComponent> getComponents() {
        return components;
    }

    public void setComponents(List<FlaskComponent> components) {
        this.components = components;
    }

    public List<String> getGlobalDeclarations() {
        return globalDeclarations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nApplication{");
        if (components != null) {
            for (FlaskComponent component : components) {
                sb.append("\n").append(component);
            }
        }
        sb.append("\n}");
        return sb.toString();
    }
}
