/*
 * Represent a function declaration instruction node inside the AST.
 */

import java.util.HashMap;

public class DeclarationProgramme extends Instruction {
    private HashMap<String, Type> vars;

    /**
     * The declared variable identifier
     */
    protected String identifier;
    /**
     * The declaration section of the function (list of DeclarationVariable)
     */
    protected Bloc declarations;
    /**
     * The body of the function
     */
    protected Bloc instructions;

    /**
     * Constructor
     */
    public DeclarationProgramme(String identifier, HashMap<String, Type> vars, String fl, int line, int col) {
        super(fl, line, col);
        this.vars = vars;
        this.identifier = identifier;
    }

    /**
     * Get the declared variable identifier
     */
    public String getIdentifier() {
        return this.identifier;
    }

    /**
     * Get the declaration section of the function
     */
    public Bloc getDeclaration() {
        return this.declarations;
    }

    /**
     * Get the body of the function
     */
    public Bloc getInstructions() {
        return this.instructions;
    }

    /**
     * Set the body of the function
     */
    public void setInstructions(Bloc instructions) {
        this.instructions = instructions;
    }

    /**
     * Set the declarations section of the function
     */
    public void setDeclarations(Bloc declarations) {
        this.declarations = declarations;
    }

    public HashMap<String, Type> getVars() {
        return this.vars;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
