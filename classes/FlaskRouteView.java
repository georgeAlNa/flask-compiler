package classes;

import java.util.ArrayList;
import java.util.List;

public class FlaskRouteView extends CompilerAstNode {

    private RouteViewMetadata routeViewMetadata;
    private FlaskClass flaskClass;

    /**
     * Raw Python source text of if-blocks inside the route (e.g. POST handling, 404 checks).
     * Each entry is the verbatim source of one if-block.
     */
    private final List<String> ifBlockRawCode = new ArrayList<>();

    /**
     * Raw Python source text of pre-return statements that use complex expressions
     * (e.g. generator expressions, function calls) that should be emitted verbatim.
     */
    private final List<String> preReturnRawLines = new ArrayList<>();

    public RouteViewMetadata getRouteViewMetadata() {
        return routeViewMetadata;
    }

    public void setRouteViewMetadata(RouteViewMetadata routeViewMetadata) {
        this.routeViewMetadata = routeViewMetadata;
    }

    public FlaskClass getFlaskClass() {
        return flaskClass;
    }

    public void setFlaskClass(FlaskClass flaskClass) {
        this.flaskClass = flaskClass;
    }

    public List<String> getIfBlockRawCode() {
        return ifBlockRawCode;
    }

    public List<String> getPreReturnRawLines() {
        return preReturnRawLines;
    }

    @Override
    public String toString() {
        return "\nFlaskRouteView{" +
                "\nrouteViewMetadata=" + routeViewMetadata +
                ", \nflaskClass=" + flaskClass +
                ", \nifBlockRawCode=" + ifBlockRawCode +
                ", \npreReturnRawLines=" + preReturnRawLines +
                "\n}";
    }
}
