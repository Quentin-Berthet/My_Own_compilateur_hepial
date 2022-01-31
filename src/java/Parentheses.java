/*
 * Represent a round brackets expression node inside the AST.
 */

public class Parentheses extends Expression {
    /**
     * Expression contained in this round brackets node
     */
    private Expression expression;

    /**
     * Constructor
     */
    public Parentheses(Expression expr, String fl, int line, int col) {
        super(fl, line, col);
        this.expression = expr;
        this.type = this.expression.type;
    }

    /**
     * Get the node expression
     */
    public Expression getExpression() {
        return this.expression;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
