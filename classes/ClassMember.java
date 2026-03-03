package classes;

import org.antlr.v4.runtime.ParserRuleContext;

public class ClassMember implements ASTNode {

    private PropertyDeclaration propertyDeclaration;
    private MethodDeclaration methodDeclaration;
    private ParserRuleContext ctx;

    public ClassMember(ParserRuleContext ctx) {
        this.ctx = ctx;
    }

    public PropertyDeclaration getPropertyDeclaration() {
        return propertyDeclaration;
    }

    public void setPropertyDeclaration(PropertyDeclaration propertyDeclaration) {
        this.propertyDeclaration = propertyDeclaration;
    }

    public MethodDeclaration getMethodDeclaration() {
        return methodDeclaration;
    }

    public void setMethodDeclaration(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
    }

    @Override
    public String toString() {
        return "\nClassMember{" +
                "\npropertyDeclaration=" + propertyDeclaration +
                ", \nmethodDeclaration=" + methodDeclaration +
                "\n}";
    }
}
