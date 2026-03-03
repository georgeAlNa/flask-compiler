package semantic_check;

public class SemanticError {

    private String message;
    private String title;
    private int line;
    private int column;
    private ErrorType type;

    public SemanticError(String message, String title, int line, int column, ErrorType type) {
        this.message = message;
        this.title   = title;
        this.line    = line;
        this.column  = column;
        this.type    = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public ErrorType getType() {
        return type;
    }

    public void setType(ErrorType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s (Line: %d, Column: %d)",
                type, title, message, line, column);
    }
}
