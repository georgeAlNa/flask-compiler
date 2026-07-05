package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ASTNode {

    private final String nodeType;
    private int line;
    private int column;
    private final List<ASTNode> children = new ArrayList<>();

    protected ASTNode() {
        this.nodeType = getClass().getSimpleName();
        this.line = -1;
        this.column = -1;
    }

    protected ASTNode(String nodeType, int line, int column) {
        this.nodeType = nodeType;
        this.line = line;
        this.column = column;
    }

    public String getNodeType() {
        return nodeType;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public List<ASTNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(ASTNode child) {
        if (child != null) {
            children.add(child);
        }
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        print(builder, "");
        return builder.toString();
    }

    protected void print(StringBuilder builder, String indent) {
        builder.append(indent).append(getPrintLabel());
        if (line >= 0) {
            builder.append(" @ ").append(line).append(":").append(column);
        }
        builder.append("\n");
        for (ASTNode child : children) {
            child.print(builder, indent + "  ");
        }
    }

    protected String getPrintLabel() {
        return nodeType;
    }

    protected String quote(String value) {
        if (value == null) {
            return "\"\"";
        }
        return "\"" + shorten(value.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n"), 80) + "\"";
    }

    protected String shorten(String value, int maxLength) {
        if (value == null || value.length() <= maxLength) {
            return value;
        }
        return value.substring(0, Math.max(0, maxLength - 3)) + "...";
    }
}
