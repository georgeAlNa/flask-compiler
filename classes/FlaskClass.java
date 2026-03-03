package classes;

public class FlaskClass implements ASTNode {

    private String className;
    private ClassBody classBody;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ClassBody getClassBody() {
        return classBody;
    }

    public void setClassBody(ClassBody classBody) {
        this.classBody = classBody;
    }

    @Override
    public String toString() {
        return "\nFlaskClass{" +
                "\nclassName='" + className + '\'' +
                ", \nclassBody=" + classBody +
                "\n}";
    }
}
