/*
 * Represent a boolean type node inside the AST.
 */

public class TypeBooleen extends Type {
    /**
     * Constructor
     */
    public TypeBooleen(String fl, int line, int col) {
        super(fl, line, col);
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Z";
    }
}
