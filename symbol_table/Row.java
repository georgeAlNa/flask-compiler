package symbol_table;

public class Row {

    private String type;
    private String value;
    private int line;
    private int column;
    private Object additionalData;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Object getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Object additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public String toString() {
        return "\nRow{" +
                "\ntype='" + type + '\'' +
                ", \nvalue='" + value + '\'' +
                ", \nline=" + line +
                ", \ncolumn=" + column +
                "\n}";
    }
}
