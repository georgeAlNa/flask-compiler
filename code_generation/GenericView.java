package code_generation;

public class GenericView extends BaseComponentView {

    private final String selector;
    private final String className;
    private final String template;
    private final String styles;
    private final String logic;
    private final String route;
    private final java.util.List<String> routeMethods;
    private final String ifBlockCode;
    private final String preReturnCode;

    public GenericView(String selector, String className, String template, String styles, String logic, String route) {
        this(selector, className, template, styles, logic, route, null, "", "");
    }

    public GenericView(String selector, String className, String template, String styles, String logic, String route,
            java.util.List<String> routeMethods) {
        this(selector, className, template, styles, logic, route, routeMethods, "", "");
    }

    public GenericView(String selector, String className, String template, String styles, String logic, String route,
            java.util.List<String> routeMethods, String ifBlockCode, String preReturnCode) {
        this.selector = selector;
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
    protected String getSelector() {
        return selector;
    }

    @Override
    protected String getClassName() {
        return className.isEmpty() ? "CustomComponent" : className;
    }

    @Override
    protected String getRoute() {
        return route.isEmpty() ? "/" + selector : route;
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
