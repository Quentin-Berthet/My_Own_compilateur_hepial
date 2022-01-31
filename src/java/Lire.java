/*
 * Represent a read node inside the AST.
 */

public class Lire extends Instruction {
    /**
     * The ident
     */
    protected Idf ident;

    /**
     * Constructor
     */
    public Lire(Idf ident, String fl, int line, int col) {
        super(fl, line, col);
        this.lierIdent(ident);
    }

    /**
     * Get the ident
     */
    public Idf getIdent() {
        return this.ident;
    }

    /**
     * Set the ident
     */
    public void lierIdent(Idf ident) {
        this.ident = ident;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
