import FlaskGen.FlaskLexer;
import FlaskGen.FlaskParser;
import classes.Application;
import classes.BaseVisitor;
import classes.FlaskComponent;
import code_generation.BaseComponentView;
import code_generation.ComponentFileSaver;
import code_generation.GeneratedComponent;
import code_generation.ViewFactory;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String source = args.length > 0 ? args[0] : "samples/sample.txt";
        final String OUTPUT_DIR = "generated_components";

        CharStream charStream = CharStreams.fromFileName(source);
        FlaskLexer lexer = new FlaskLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FlaskParser parser = new FlaskParser(tokens);

        ParseTree ast = parser.application();
        BaseVisitor visitor = new BaseVisitor();
        Application program = (Application) visitor.visit(ast);

        List<FlaskComponent> components = program.getComponents();
        List<GeneratedComponent> generatedList = new ArrayList<>();

        for (FlaskComponent component : components) {
            BaseComponentView view = ViewFactory.createView(component);
            GeneratedComponent generated = withDeleteButton(view.generate());
            generatedList.add(generated);

            System.out.println("=== " + view.getClass().getSimpleName() + " ===");
            System.out.println("Python:\n" + generated.getPy());
            System.out.println("HTML:\n" + generated.getHtml());
            System.out.println("CSS:\n" + generated.getCss());
            System.out.println("\n" + "-".repeat(50) + "\n");
        }

        if (hasProductsData(program.getGlobalDeclarations())) {
            GeneratedComponent deleteProduct = new GeneratedComponent(
                    generateDeleteProductRoute(),
                    "",
                    "",
                    "DeleteProduct");
            generatedList.add(deleteProduct);

            System.out.println("=== DeleteProductView ===");
            System.out.println("Python:\n" + deleteProduct.getPy());
            System.out.println("HTML:\n");
            System.out.println("CSS:\n");
            System.out.println("\n" + "-".repeat(50) + "\n");
        }

        ComponentFileSaver.saveComponents(generatedList, OUTPUT_DIR, program.getGlobalDeclarations());

        System.out.println("\n=== Python AST ===");
        System.out.println(program.printPythonAst());

        System.out.println("\n=== Jinja2 AST ===");
        System.out.println(program.printJinjaAst());

        System.out.println("\n=== Full AST ===");
        System.out.println(program.printFullAst());

        System.out.println(program);
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

    private static String generateDeleteProductRoute() {
        return """
                @app.route('/product/delete/<int:id>', methods=['POST'])
                def delete_product(id):
                    global products_data
                    products_data = [p for p in products_data if p["id"] != id]
                    return redirect("/products")
                """;
    }

    private static GeneratedComponent withDeleteButton(GeneratedComponent component) {
        String html = component.getHtml();
        if (html == null || html.isBlank()) {
            return component;
        }

        if ("Products".equals(component.getComponentName())) {
            html = addDeleteButtonToProductsTemplate(html);
        } else if ("ProductDetail".equals(component.getComponentName())) {
            html = addDeleteButtonToProductDetailTemplate(html);
        }

        return new GeneratedComponent(component.getPy(), html, component.getCss(), component.getComponentName());
    }

    private static String addDeleteButtonToProductsTemplate(String html) {
        if (html.contains("/product/delete/")) {
            return html;
        }
        String marker = "<a href=\"/product/{{ p.id }}\">{{ detailsLabel }}</a>";
        String replacement = marker + "\n" +
                "                <form method=\"post\" action=\"/product/delete/{{ p.id }}\" class=\"inline-form\">\n" +
                "                    <button type=\"submit\" class=\"btn btn-danger\">Delete</button>\n" +
                "                </form>";
        return html.replace(marker, replacement);
    }

    private static String addDeleteButtonToProductDetailTemplate(String html) {
        if (html.contains("/product/delete/")) {
            return html;
        }
        String marker = "<a href=\"/products\">{{ backLabel }}</a>";
        String replacement = marker + "\n" +
                "        <form method=\"post\" action=\"/product/delete/{{ product.id }}\" class=\"inline-form\">\n" +
                "            <button type=\"submit\" class=\"btn btn-danger\">Delete</button>\n" +
                "        </form>";
        return html.replace(marker, replacement);
    }
}
