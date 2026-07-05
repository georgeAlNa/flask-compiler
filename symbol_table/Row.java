package symbol_table;

public class Row {

    private String type;
    private String value;
    private int line;
    private int column;
    private Object additionalData;
    private String scope;
    private String origin;
    private String dataType;
    private boolean usedInTemplate;
    private boolean passedToTemplate;

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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isUsedInTemplate() {
        return usedInTemplate;
    }

    public void setUsedInTemplate(boolean usedInTemplate) {
        this.usedInTemplate = usedInTemplate;
    }

    public boolean isPassedToTemplate() {
        return passedToTemplate;
    }

    public void setPassedToTemplate(boolean passedToTemplate) {
        this.passedToTemplate = passedToTemplate;
    }

    @Override
    public String toString() {
        return "\nRow{" +
                "\ntype='" + type + '\'' +
                ", \nvalue='" + value + '\'' +
                ", \nline=" + line +
                ", \ncolumn=" + column +
                ", \nscope='" + scope + '\'' +
                ", \norigin='" + origin + '\'' +
                ", \ndataType='" + dataType + '\'' +
                ", \nusedInTemplate=" + usedInTemplate +
                ", \npassedToTemplate=" + passedToTemplate +
                "\n}";
    }
}
