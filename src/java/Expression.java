/*
 * Base class that represent an expression node inside the AST.
 */

public abstract class Expression extends ASTNode {

    protected Type type;

    /**
     * Constructor
     */
    public Expression(String fl, int line, int col) {
        super(fl, line, col);
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
