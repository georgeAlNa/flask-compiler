package syntax_check;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyntaxErrorListener extends BaseErrorListener {

    private final List<String> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
            int charPositionInLine, String msg, RecognitionException e) {
        errors.add("Syntax error at line " + line + ", column " + charPositionInLine + ": " + msg);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public void printErrors() {
        if (errors.isEmpty()) {
            return;
        }
        System.out.println("\n=== Syntax Errors (" + errors.size() + ") ===");
        for (int i = 0; i < errors.size(); i++) {
            System.out.println("Error #" + (i + 1) + ": " + errors.get(i));
        }
    }
}
