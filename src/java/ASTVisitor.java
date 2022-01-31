/*
 * AST visiteur interface
 */

public interface ASTVisitor {
    Object visit(And node);

    Object visit(Or node);

    Object visit(Addition node);

    Object visit(Soustraction node);

    Object visit(Multiplication node);

    Object visit(Division node);

    Object visit(Affectation node);

    Object visit(Bloc node);

    Object visit(Chaine node);

    Object visit(DeclarationProgramme node);

    Object visit(Egal node);

    Object visit(Idf node);

    Object visit(Nombre node);

    Object visit(Booleen node);

    Object visit(Different node);

    Object visit(Inferieur node);

    Object visit(InferieurEgal node);

    Object visit(Superieur node);

    Object visit(SuperieurEgal node);

    Object visit(Tilda node);

    Object visit(Parentheses node);

    Object visit(Ecrire node);

    Object visit(EcrireStringConstante node);

    Object visit(TantQue node);

    Object visit(Pour node);

    Object visit(Non node);

    //Object visit(Minus node);
    Object visit(TypeInteger node);

    Object visit(TypeBooleen node);

    Object visit(Si node);

    Object visit(SiSinon node);

    Object visit(Lire node);
}

















































































