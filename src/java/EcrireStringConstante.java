/*
 * Represent a write string const node inside the AST.
 */

public class EcrireStringConstante extends Instruction {
    /**
     * The source operand
     */
    protected String source;

    /**
     * Constructor
     */
    public EcrireStringConstante(String src, String fl, int line, int col) {
        super(fl, line, col);
        this.lierSource(src);
    }

    /**
     * Get the source operand
     */
    public String getSource() {
        return this.source;
    }

    /**
     * Set the source operand
     */
    public void lierSource(String exp) {
        this.source = exp;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
