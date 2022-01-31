/*
 * Represent a tilda expression node inside the AST.
 */

public class Tilda extends ArithmetiqueUnaire {
    /**
     * Constructor
     */
    public Tilda(String fl, int line, int col) {
        super(fl, line, col);
        this.type = new TypeInteger(fl, line, col);
    }

    /**
     * Get the unary operator
     */
    public String operateur() {
        return "~";
    }

    /**
     * Apply the operator on the given value.
     */
    public int apply(int droite) {
        return ~droite;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
