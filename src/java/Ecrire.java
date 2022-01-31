/*
 * Represent a write node inside the AST.
 */

public class Ecrire extends Instruction {
    /**
     * The source operand
     */
    protected Expression source;

    /**
     * Constructor
     */
    public Ecrire(Expression src, String fl, int line, int col) {
        super(fl, line, col);
        this.lierSource(src);
    }

    /**
     * Get the source operand
     */
    public Expression getSource() {
        return this.source;
    }

    /**
     * Set the source operand
     */
    public void lierSource(Expression exp) {
        this.source = exp;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
