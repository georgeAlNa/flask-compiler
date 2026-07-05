package python_ast;

import classes.ASTNode;

public class DictNode extends ASTNode {

    private final String rawValue;

    public DictNode(String rawValue, int line, int column) {
        this.rawValue = rawValue;
        setLine(line);
        setColumn(column);
    }

    public String getRawValue() {
        return rawValue;
    }
}
