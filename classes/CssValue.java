package classes;

public class CssValue implements ASTNode {

    private String percentageValue;
    private String numberValue;
    private String colorValue;
    private String stringValue;
    private String alphabetValue;
    private String functionValue;

    public String getPercentageValue() {
        return percentageValue;
    }

    public void setPercentageValue(String percentageValue) {
        this.percentageValue = percentageValue;
    }

    public String getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(String numberValue) {
        this.numberValue = numberValue;
    }

    public String getColorValue() {
        return colorValue;
    }

    public void setColorValue(String colorValue) {
        this.colorValue = colorValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getAlphabetValue() {
        return alphabetValue;
    }

    public void setAlphabetValue(String alphabetValue) {
        this.alphabetValue = alphabetValue;
    }

    public String getFunctionValue() {
        return functionValue;
    }

    public void setFunctionValue(String functionValue) {
        this.functionValue = functionValue;
    }

    @Override
    public String toString() {
        if (percentageValue != null) return percentageValue;
        if (numberValue     != null) return numberValue;
        if (colorValue      != null) return colorValue;
        if (stringValue     != null) return stringValue;
        if (functionValue   != null) return functionValue;
        return alphabetValue != null ? alphabetValue : "";
    }
}
