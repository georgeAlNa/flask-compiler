package python_ast;

import classes.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class PythonProgramNode extends ASTNode {

    private final List<RouteNode> routes = new ArrayList<>();

    public void addRoute(RouteNode route) {
        if (route != null) {
            routes.add(route);
            addChild(route);
        }
    }

    public List<RouteNode> getRoutes() {
        return routes;
    }
}
