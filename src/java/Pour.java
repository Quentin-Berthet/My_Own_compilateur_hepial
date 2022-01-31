/*
 * Represent a for node inside the AST.
 */

public class Pour extends Instruction {
    /**
     * The ident
     */
    protected Idf ident;

    /**
     * The from bloc operand
     */
    protected Expression from;

    /**
     * The to bloc operand
     */
    protected Expression to;

    /**
     * The body bloc
     */
    protected Bloc body;

    /**
     * Constructor
     */
    public Pour(Idf ident, Expression from, Expression to, Bloc body, String fl, int line, int col) {
        super(fl, line, col);
        this.lierIdent(ident);
        this.lierFrom(from);
        this.lierTo(to);
        this.lierBody(body);
    }

    /**
     * Get the ident operand
     */
    public Idf getIdent() {
        return this.ident;
    }

    /**
     * Get the condition operand
     */
    public Expression getFrom() {
        return this.from;
    }

    /**
     * Get the condition operand
     */
    public Expression getTo() {
        return this.to;
    }

    /**
     * Get the body bloc
     */
    public Bloc getBody() {
        return this.body;
    }

    /**
     * Set the ident
     */
    public void lierIdent(Idf ident) {
        this.ident = ident;
    }

    /**
     * Set the from expression
     */
    public void lierFrom(Expression from) {
        this.from = from;
    }

    /**
     * Set the to expression
     */
    public void lierTo(Expression to) {
        this.to = to;
    }

    /**
     * Set the destination variable or array (at its left)
     */
    public void lierBody(Bloc body) {
        this.body = body;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
