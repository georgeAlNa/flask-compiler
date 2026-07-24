import FlaskGen.FlaskLexer;
import FlaskGen.FlaskParser;
import classes.Application;
import classes.BaseVisitor;
import classes.FlaskRouteView;
import classes.ProjectInputLoader;
import code_generation.BaseGeneratedView;
import code_generation.CompilerOutputSaver;
import code_generation.GeneratedFlaskAppSaver;
import code_generation.GeneratedRouteView;
import code_generation.StaticOutputSaver;
import code_generation.ViewFactory;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import syntax_check.SyntaxErrorListener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String source = args.length > 0 ? args[0] : "samples/sample.txt";
        final String OUTPUT_DIR = "generated_components";
        final String STATIC_OUTPUT_DIR = "output";
        final String COMPILER_OUTPUT_DIR = "compiler_output";

        Path sourcePath = Path.of(source);
        boolean projectDirectoryInput = Files.isDirectory(sourcePath);
        CharStream charStream = projectDirectoryInput
                ? CharStreams.fromString(ProjectInputLoader.loadProjectDirectory(sourcePath), source)
                : CharStreams.fromFileName(source);
        FlaskLexer lexer = new FlaskLexer(charStream);
        SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener();
        lexer.removeErrorListeners();
        lexer.addErrorListener(syntaxErrorListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FlaskParser parser = new FlaskParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(syntaxErrorListener);

        ParseTree ast = parser.application();
        if (syntaxErrorListener.hasErrors()) {
            syntaxErrorListener.printErrors();
            System.out.println("\nCode generation skipped because syntax errors were found.");
            return;
        }

        BaseVisitor visitor = new BaseVisitor();
        Application program = (Application) visitor.visit(ast);

        if (visitor.hasSemanticErrors()) {
            System.out.println("\nCode generation skipped because semantic errors were found.");
            printAst(program);
            CompilerOutputSaver.save(program, visitor.getSemanticErrors(),
                    List.of("Code generation skipped because semantic errors were found."),
                    COMPILER_OUTPUT_DIR);
            return;
        }

        List<FlaskRouteView> routeViews = program.getRouteViews();
        List<GeneratedRouteView> generatedList = new ArrayList<>();
        List<String> generationLogLines = new ArrayList<>();
        generationLogLines.add("Source file: " + source);
        generationLogLines.add("Generation status: success");
        generationLogLines.add("Generated Flask route count: " + routeViews.size());

        for (FlaskRouteView routeView : routeViews) {
            BaseGeneratedView view = ViewFactory.createView(routeView);
            GeneratedRouteView generated = withProductActions(view.generate());
            generatedList.add(generated);
            generationLogLines.add("Generated route view: " + generated.getViewName());

            System.out.println("=== " + view.getClass().getSimpleName() + " ===");
            System.out.println("Python:\n" + generated.getPy());
            System.out.println("HTML:\n" + generated.getHtml());
            System.out.println("CSS:\n" + generated.getCss());
            System.out.println("\n" + "-".repeat(50) + "\n");
        }

        if (hasProductsData(program.getGlobalDeclarations())) {
            GeneratedRouteView editProduct = new GeneratedRouteView(
                    generateEditProductRoute(),
                    generateEditProductTemplate(loadExternalEditProductTemplate(sourcePath, projectDirectoryInput)),
                    "",
                    "EditProduct");
            generatedList.add(editProduct);
            generationLogLines.add("Generated route view: EditProduct");

            System.out.println("=== EditProductView ===");
            System.out.println("Python:\n" + editProduct.getPy());
            System.out.println("HTML:\n" + editProduct.getHtml());
            System.out.println("CSS:\n");
            System.out.println("\n" + "-".repeat(50) + "\n");

            GeneratedRouteView deleteProduct = new GeneratedRouteView(
                    generateDeleteProductRoute(),
                    "",
                    "",
                    "DeleteProduct");
            generatedList.add(deleteProduct);
            generationLogLines.add("Generated route view: DeleteProduct");

            System.out.println("=== DeleteProductView ===");
            System.out.println("Python:\n" + deleteProduct.getPy());
            System.out.println("HTML:\n");
            System.out.println("CSS:\n");
            System.out.println("\n" + "-".repeat(50) + "\n");
        }

        GeneratedFlaskAppSaver.saveGeneratedViews(generatedList, OUTPUT_DIR, program.getGlobalDeclarations());
        generationLogLines.add("Generated support file: " + OUTPUT_DIR + "/app.py");
        generationLogLines.add("Generated support file: " + OUTPUT_DIR + "/static/style.css");
        generationLogLines.add("Generated template directory: " + OUTPUT_DIR + "/templates");

        List<String> staticOutputFiles = StaticOutputSaver.saveStaticOutput(generatedList, STATIC_OUTPUT_DIR,
                OUTPUT_DIR, program.getGlobalDeclarations(),
                projectDirectoryInput ? sourcePath : null);
        for (String file : staticOutputFiles) {
            generationLogLines.add("Generated translator output file: " + file);
        }

        printAst(program);
        CompilerOutputSaver.save(program, visitor.getSemanticErrors(), generationLogLines, COMPILER_OUTPUT_DIR);

        System.out.println(program);
    }

    private static void printAst(Application program) {
        System.out.println("\n=== Python AST ===");
        System.out.println(program.printPythonAst());

        System.out.println("\n=== Jinja2 AST ===");
        System.out.println(program.printJinjaAst());

        System.out.println("\n=== Full AST ===");
        System.out.println(program.printFullAst());
    }

    private static boolean hasProductsData(List<String> globalDeclarations) {
        if (globalDeclarations == null) {
            return false;
        }
        for (String declaration : globalDeclarations) {
            if (declaration != null && declaration.contains("products_data")) {
                return true;
            }
        }
        return false;
    }

    private static String generateEditProductRoute() {
        return """
                @app.route('/product/edit/<int:id>', methods=['GET', 'POST'])
                def edit_product(id):
                    product = next((p for p in products_data if p["id"] == id), None)
                    if not product:
                        return "Product not found", 404
                    if request.method == "POST":
                        product["name"] = request.form["name"]
                        product["price"] = request.form["price"]
                        product["image"] = request.form["image"]
                        product["details"] = request.form["description"]
                        return redirect("/product/" + str(id))
                    editTitle = "Edit Product"
                    saveLabel = "Save Changes"
                    backLabel = "Back to Product"
                    return render_template('EditProduct.html', product=product, editTitle=editTitle, saveLabel=saveLabel, backLabel=backLabel)
                """;
    }

    private static String generateEditProductTemplate(String externalTemplateContent) {
        if (externalTemplateContent != null && !externalTemplateContent.isBlank()) {
            return wrapTemplate("Edit Product", externalTemplateContent);
        }
        return """
                {% extends 'base.html' %}

                {% block title %}Edit Product{% endblock %}

                {% block content %}
                <section>
                    <h2>{{ editTitle }}</h2>
                    <form method="post">
                        <input name="name" value="{{ product.name }}" required />
                        <input type="number" name="price" value="{{ product.price }}" required />
                        <input name="image" value="{{ product.image }}" required />
                        <textarea name="description">{{ product.details }}</textarea>
                        <button type="submit">{{ saveLabel }}</button>
                        <a href="/product/{{ product.id }}">{{ backLabel }}</a>
                    </form>
                </section>
                {% endblock %}
                """;
    }

    private static String wrapTemplate(String title, String content) {
        return "{% extends 'base.html' %}\n\n"
                + "{% block title %}" + title + "{% endblock %}\n\n"
                + "{% block content %}\n"
                + content.strip() + "\n"
                + "{% endblock %}\n";
    }

    private static String loadExternalEditProductTemplate(Path sourcePath, boolean projectDirectoryInput) {
        if (!projectDirectoryInput) {
            return "";
        }
        Path templatePath = sourcePath.resolve("templates").resolve("edit_product.jinja");
        if (!Files.exists(templatePath)) {
            return "";
        }
        try {
            return Files.readString(templatePath);
        } catch (IOException e) {
            System.err.println("Could not read external edit_product.jinja: " + e.getMessage());
            return "";
        }
    }

    private static String generateDeleteProductRoute() {
        return """
                @app.route('/product/delete/<int:id>', methods=['POST'])
                def delete_product(id):
                    global products_data
                    products_data = [p for p in products_data if p["id"] != id]
                    return redirect("/products")
                """;
    }

    private static GeneratedRouteView withProductActions(GeneratedRouteView routeView) {
        String html = routeView.getHtml();
        if (html == null || html.isBlank()) {
            return routeView;
        }

        if ("Products".equals(routeView.getViewName())) {
            html = addProductActionsToProductsTemplate(html);
        } else if ("ProductDetail".equals(routeView.getViewName())) {
            html = addProductActionsToProductDetailTemplate(html);
        }

        return new GeneratedRouteView(routeView.getPy(), html, routeView.getCss(), routeView.getViewName());
    }

    private static String addProductActionsToProductsTemplate(String html) {
        if (html.contains("/product/edit/") && html.contains("/product/delete/")) {
            return html;
        }
        String marker = "<a href=\"/product/{{ p.id }}\">{{ detailsLabel }}</a>";
        String replacement = marker + "\n" +
                "                <a href=\"/product/edit/{{ p.id }}\">Edit</a>\n" +
                "                <form method=\"post\" action=\"/product/delete/{{ p.id }}\" class=\"inline-form\">\n" +
                "                    <button type=\"submit\" class=\"btn btn-danger\">Delete</button>\n" +
                "                </form>";
        return html.replace(marker, replacement);
    }

    private static String addProductActionsToProductDetailTemplate(String html) {
        if (html.contains("/product/edit/") && html.contains("/product/delete/")) {
            return html;
        }
        String marker = "<a href=\"/products\">{{ backLabel }}</a>";
        String replacement = marker + "\n" +
                "        <a href=\"/product/edit/{{ product.id }}\">Edit</a>\n" +
                "        <form method=\"post\" action=\"/product/delete/{{ product.id }}\" class=\"inline-form\">\n" +
                "            <button type=\"submit\" class=\"btn btn-danger\">Delete</button>\n" +
                "        </form>";
        return html.replace(marker, replacement);
    }
}
