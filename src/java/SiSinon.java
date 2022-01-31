/*
 * Represent an if-else node inside the AST.
 */

public class SiSinon extends Instruction {
    /**
     * The condition operand
     */
    protected Expression condition;

    /**
     * The thenBody bloc
     */
    protected Bloc thenBody;

    /**
     * The elseBody bloc
     */
    protected Bloc elseBody;

    /**
     * Constructor
     */
    public SiSinon(Expression exp, Bloc thenBody, Bloc elseBody, String fl, int line, int col) {
        super(fl, line, col);
        this.lierCondition(exp);
        this.lierThenBody(thenBody);
        this.lierElseBody(elseBody);
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
     * Get the elseBody bloc
     */
    public Bloc getElseBody() {
        return this.elseBody;
    }

    /**
     * Set the condition
     */
    public void lierCondition(Expression exp) {
        this.condition = exp;
    }

    /**
     * Set then bloc body
     */
    public void lierThenBody(Bloc thenBody) {
        this.thenBody = thenBody;
    }

    /**
     * Set else bloc body
     */
    public void lierElseBody(Bloc elseBody) {
        this.elseBody = elseBody;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
