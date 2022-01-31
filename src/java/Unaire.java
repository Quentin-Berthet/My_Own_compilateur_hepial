/*
 * Base class that represent a unary expression node inside the AST.
 */

public abstract class Unaire extends Expression {
    /**
     * The expression at its right
     */
    protected Expression operandeDroite;

    /**
     * Constructor
     */
    public Unaire(String fl, int line, int col) {
        super(fl, line, col);
    }

    /**
     * Get the right expression
     */
    public Expression getDroite() {
        return this.operandeDroite;
    }

    /**
     * Get the unary operator.
     * Must be implemented by the child class.
     */
    public abstract String operateur();

    /**
     * Set the right expression
     */
    public void lierDroite(Expression exp) {
        this.operandeDroite = exp;
    }

    /**
     * Apply the operator on the value.
     * Must be implemented by the child class.
     */
    public abstract int apply(int droite);

    /**
     * Transform this node into a visualisable string
     */
    public String toString() {
        return this.operateur() + " " + this.operandeDroite;
    }
}
