/*
 * Represent an if node inside the AST.
 */

public class Si extends Instruction {
    /**
     * The condition operand
     */
    protected Expression condition;

    /**
     * The thenBody bloc
     */
    protected Bloc thenBody;

    /**
     * Constructor
     */
    public Si(Expression exp, Bloc thenBody, String fl, int line, int col) {
        super(fl, line, col);
        this.lierCondition(exp);
        this.lierThenBody(thenBody);
    }

    /**
     * Get the condition operand
     */
    public Expression getCondition() {
        return this.condition;
    }

    /**
     * Get the thenBody bloc
     */
    public Bloc getThenBody() {
        return this.thenBody;
    }

    /**
     * Set the condition
     */
    public void lierCondition(Expression exp) {
        this.condition = exp;
    }

    /**
     * Set then bloc Body
     */
    public void lierThenBody(Bloc thenBody) {
        this.thenBody = thenBody;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
