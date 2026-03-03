package classes;

import java.util.Arrays;

public class ParameterList implements ASTNode {

    private String[] parameters = new String[0];

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nParameterList{");
        if (parameters != null) {
            for (String param : parameters) {
                sb.append("\n").append(param);
            }
        }
        sb.append("\n}");
        return sb.toString();
    }
}
