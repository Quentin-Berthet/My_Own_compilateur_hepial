/*
 * Represent a while node inside the AST.
 */

public class TantQue extends Instruction {
    /**
     * The condition operand
     */
    protected Expression condition;

    /**
     * The body bloc
     */
    protected Bloc body;

    /**
     * Constructor
     */
    public TantQue(Expression exp, Bloc body, String fl, int line, int col) {
        super(fl, line, col);
        this.lierCondition(exp);
        this.lierBody(body);
    }

    /**
     * Get the condition operand
     */
    public Expression getCondition() {
        return this.condition;
    }

    /**
     * Get the body bloc
     */
    public Bloc getBody() {
        return this.body;
    }

    /**
     * Set the source operand (at its right)
     */
    public void lierCondition(Expression exp) {
        this.condition = exp;
    }

    /**
     * Set the destination variable or array (at its left)
     */
    public void lierBody(Bloc body) {
        this.body = body;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
