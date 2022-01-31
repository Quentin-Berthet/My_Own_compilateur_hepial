/*
 * Represent an integer type node inside the AST.
 */

public class TypeInteger extends Type {
    /**
     * Constructor
     */
    public TypeInteger(String fl, int line, int col) {
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
        return "I";
    }
}
