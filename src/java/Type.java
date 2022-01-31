/*
 * Base class that represent a type node inside the AST.
 */

public abstract class Type extends ASTNode {

    /**
     * Constructor
     */
    public Type(String fl, int line, int col) {
        super(fl, line, col);
    }
}
