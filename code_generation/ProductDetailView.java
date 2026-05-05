package code_generation;

public class ProductDetailView extends BaseComponentView {

    private final String template;
    private final String styles;
    private final String logic;
    private final String route;

    public ProductDetailView(String template, String styles, String logic, String route) {
        this.template = template;
        this.styles   = styles;
        this.logic    = logic;
        this.route    = route;
    }

    @Override
    protected String getClassName() {
        return "ProductDetail";
    }

    @Override
    protected String getRoute() {
        return route.isEmpty() ? "/product/<int:id>" : route;
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
        return "from flask import Flask, render_template\nfrom models import Product";
    }
}
