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
        String source = "samples/sample.txt";
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
            GeneratedComponent generated = view.generate();
            generatedList.add(generated);

            System.out.println("=== " + view.getClass().getSimpleName() + " ===");
            System.out.println("Python:\n" + generated.getPy());
            System.out.println("HTML:\n" + generated.getHtml());
            System.out.println("CSS:\n" + generated.getCss());
            System.out.println("\n" + "-".repeat(50) + "\n");
        }

        ComponentFileSaver.saveComponents(generatedList, OUTPUT_DIR, program.getGlobalDeclarations());

        System.out.println(program);
    }
}
