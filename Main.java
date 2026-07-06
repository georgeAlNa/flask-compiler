import FlaskGen.FlaskLexer;
import FlaskGen.FlaskParser;
import classes.Application;
import classes.BaseVisitor;
import classes.FlaskRouteView;
import code_generation.BaseGeneratedView;
import code_generation.GeneratedFlaskAppSaver;
import code_generation.GeneratedRouteView;
import code_generation.ViewFactory;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import syntax_check.SyntaxErrorListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String source = args.length > 0 ? args[0] : "samples/sample.txt";
        final String OUTPUT_DIR = "generated_components";

        CharStream charStream = CharStreams.fromFileName(source);
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
            return;
        }

        List<FlaskRouteView> routeViews = program.getRouteViews();
        List<GeneratedRouteView> generatedList = new ArrayList<>();

        for (FlaskRouteView routeView : routeViews) {
            BaseGeneratedView view = ViewFactory.createView(routeView);
            GeneratedRouteView generated = withDeleteButton(view.generate());
            generatedList.add(generated);

            System.out.println("=== " + view.getClass().getSimpleName() + " ===");
            System.out.println("Python:\n" + generated.getPy());
            System.out.println("HTML:\n" + generated.getHtml());
            System.out.println("CSS:\n" + generated.getCss());
            System.out.println("\n" + "-".repeat(50) + "\n");
        }

        if (hasProductsData(program.getGlobalDeclarations())) {
            GeneratedRouteView deleteProduct = new GeneratedRouteView(
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

        GeneratedFlaskAppSaver.saveGeneratedViews(generatedList, OUTPUT_DIR, program.getGlobalDeclarations());

        printAst(program);

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

    private static String generateDeleteProductRoute() {
        return """
                @app.route('/product/delete/<int:id>', methods=['POST'])
                def delete_product(id):
                    global products_data
                    products_data = [p for p in products_data if p["id"] != id]
                    return redirect("/products")
                """;
    }

    private static GeneratedRouteView withDeleteButton(GeneratedRouteView routeView) {
        String html = routeView.getHtml();
        if (html == null || html.isBlank()) {
            return routeView;
        }

        if ("Products".equals(routeView.getViewName())) {
            html = addDeleteButtonToProductsTemplate(html);
        } else if ("ProductDetail".equals(routeView.getViewName())) {
            html = addDeleteButtonToProductDetailTemplate(html);
        }

        return new GeneratedRouteView(routeView.getPy(), html, routeView.getCss(), routeView.getViewName());
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
