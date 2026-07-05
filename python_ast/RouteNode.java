package python_ast;

import classes.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class RouteNode extends ASTNode {

    private final String routePath;
    private final String functionName;
    private final List<String> methods;

    public RouteNode(String routePath, String functionName, List<String> methods, int line, int column) {
        this.routePath = routePath;
        this.functionName = functionName;
        this.methods = methods != null ? new ArrayList<>(methods) : new ArrayList<>();
        setLine(line);
        setColumn(column);
    }

    public String getRoutePath() {
        return routePath;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<String> getMethods() {
        return methods;
    }
}
