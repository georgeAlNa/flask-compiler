package classes;

import java.util.List;

public class RouteEntry implements MetadataEntry {

    private String route;
    private List<String> methods;

    public RouteEntry(String route) {
        this.route = route;
    }

    public RouteEntry(String route, List<String> methods) {
        this.route = route;
        this.methods = methods;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public List<String> getMethods() {
        return methods;
    }

    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    @Override
    public String toString() {
        return "RouteEntry{" +
                "route='" + route + '\'' +
                (methods != null ? ", methods=" + methods : "") +
                "}";
    }
}
