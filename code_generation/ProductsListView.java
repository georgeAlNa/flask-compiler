package code_generation;

public class ProductsListView extends BaseComponentView {

    private final String template;
    private final String styles;
    private final String logic;
    private final String route;

    public ProductsListView(String template, String styles, String logic, String route) {
        this.template = template;
        this.styles   = styles;
        this.logic    = logic;
        this.route    = route;
    }

    @Override
    protected String getSelector() {
        return "app-products";
    }

    @Override
    protected String getClassName() {
        return "ProductsList";
    }

    @Override
    protected String getRoute() {
        return route.isEmpty() ? "/products" : route;
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
