/*
 * Base class that represent a unary arithmetique expression node inside the AST.
 */

public abstract class ArithmetiqueUnaire extends Unaire {
    /**
     * Constructor
     */
    public ArithmetiqueUnaire(String fl, int line, int col) {
        super(fl, line, col);
    }
}
