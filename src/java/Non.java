/*
 * Represent a not expression node inside the AST.
 */


public class Non extends ArithmetiqueUnaire {

    public Non(String fl, int line, int col) {
        super(fl, line, col);
        this.type = new TypeBooleen(fl, line, col);
    }

    public int apply(int droite) {
        throw new RuntimeException("int non traitable.");
    }

    public boolean apply(boolean droite) {
        return !droite;
    }

    public String operateur() {
        return "!";
    }

    Object accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }

}
