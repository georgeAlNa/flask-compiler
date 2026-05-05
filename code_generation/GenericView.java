package code_generation;

public class GenericView extends BaseComponentView {

    private final String endpointName;
    private final String className;
    private final String template;
    private final String styles;
    private final String logic;
    private final String route;
    private final java.util.List<String> routeMethods;
    private final String ifBlockCode;
    private final String preReturnCode;

    public GenericView(String endpointName, String className, String template, String styles, String logic,
            String route) {
        this(endpointName, className, template, styles, logic, route, null, "", "");
    }

    public GenericView(String endpointName, String className, String template, String styles, String logic,
            String route, java.util.List<String> routeMethods) {
        this(endpointName, className, template, styles, logic, route, routeMethods, "", "");
    }

    public GenericView(String endpointName, String className, String template, String styles, String logic,
            String route, java.util.List<String> routeMethods, String ifBlockCode, String preReturnCode) {
        this.endpointName = endpointName;
        this.className = className;
        this.template = template;
        this.styles = styles;
        this.logic = logic;
        this.route = route;
        this.routeMethods = routeMethods;
        this.ifBlockCode = ifBlockCode != null ? ifBlockCode : "";
        this.preReturnCode = preReturnCode != null ? preReturnCode : "";
    }

    @Override
    protected String getClassName() {
        return className.isEmpty() ? "CustomComponent" : className;
    }

    @Override
    protected String getRoute() {
        return route.isEmpty() ? "/" + endpointName : route;
    }

    @Override
    protected java.util.List<String> getRouteMethods() {
        return routeMethods;
    }

    @Override
    protected String generateTemplate() {
        return template;
    }

    @Override
    protected String generateStyles() {
        return styles;
    }

    @Override
    protected String generateLogic() {
        return logic;
    }

    @Override
    protected String generateImports() {
        return "from flask import Flask, render_template";
    }

    public String getIfBlockCode() {
        return ifBlockCode;
    }

    public String getPreReturnCode() {
        return preReturnCode;
    }
}
