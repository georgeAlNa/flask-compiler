package python_ast;

import classes.ASTNode;

public class ListNode extends ASTNode {

    private final String name;
    private final String rawValue;

    public ListNode(String name, String rawValue, int line, int column) {
        this.name = name;
        this.rawValue = rawValue;
        setLine(line);
        setColumn(column);
    }

    public String getName() {
        return name;
    }

    public String getRawValue() {
        return rawValue;
    }

    @Override
    protected String getPrintLabel() {
        return "ListNode(name=" + quote(name) + ", value=" + quote(rawValue) + ")";
    }
}
