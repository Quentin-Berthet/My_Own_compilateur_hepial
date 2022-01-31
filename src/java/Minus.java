public class Minus extends ArithmetiqueUnaire {

    public Minus(String fl, int line, int col) {
        super(fl, line, col);
    }

    public String operateur() {
        return "-";
    }

    public boolean apply(boolean droite) {
        throw new RuntimeException("boolean non taitable.");
    }

    public int apply(int droite) {
        return -droite;
    }

    Object accept(ASTVisitor visitor) {
        return null; //visitor.visit(this);
    }

}
