/*
 * Represent a boolean node inside the AST.
 */

public class Booleen extends Expression {
    /**
     * Value contained in this string node
     */
    private boolean valeur;

    /**
     * Constructor
     */
    public Booleen(boolean val, String fl, int line, int col) {
        super(fl, line, col);
        this.valeur = val;
        this.type = new TypeBooleen(fl, line, col);
    }

    /**
     * Get the node value
     */
    public boolean getValeur() {
        return this.valeur;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return this.valeur ? "1" : "0";
    }
}
