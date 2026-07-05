package python_ast;

import classes.ASTNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class RenderTemplateNode extends ASTNode {

    private final String templateName;
    private final Map<String, String> contextVariables = new LinkedHashMap<>();

    public RenderTemplateNode(String templateName, int line, int column) {
        this.templateName = templateName;
        setLine(line);
        setColumn(column);
    }

    public String getTemplateName() {
        return templateName;
    }

    public Map<String, String> getContextVariables() {
        return contextVariables;
    }

    public void addContextVariable(String name, String source) {
        contextVariables.put(name, source);
    }
}
