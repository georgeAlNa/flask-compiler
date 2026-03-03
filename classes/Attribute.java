package classes;

public class Attribute implements ASTNode {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nAttribute{");
        sb.append("\nname='").append(name).append('\'');
        sb.append(", \nvalue='").append(value).append('\'');
        sb.append("\n}");
        return sb.toString();
    }
}
