public class AnalyseurSemantique implements ASTVisitor {
    @Override
    public Object visit(And node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getGauche().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[And] Les types ne sont pas compatibles.");
        }
        node.setType(typeGauche);
        return null;
    }

    @Override
    public Object visit(Or node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getGauche().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[Or] Les types ne sont pas compatibles.");
        }
        node.setType(typeGauche);
        return null;
    }

    @Override
    public Object visit(Addition node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getDroite().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[Addition] Les types ne sont pas compatibles.");
        }
        node.setType(typeGauche);
        return null;
    }

    @Override
    public Object visit(Soustraction node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getDroite().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[Soustraction] Les types ne sont pas compatibles.");
        }
        node.setType(typeGauche);
        return null;
    }

    @Override
    public Object visit(Multiplication node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getDroite().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[Multiplication] Les types ne sont pas compatibles.");
        }
        node.setType(typeGauche);
        return null;
    }

    @Override
    public Object visit(Division node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getDroite().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[Division] Les types ne sont pas compatibles.");
        }
        node.setType(typeGauche);
        return null;
    }

    @Override
    public Object visit(Affectation node) {
        node.getDestination().accept(this);
        Type typeDestination = node.getDestination().getType();

        node.getSource().accept(this);
        Type typeSource = node.getSource().getType();

        if (!typeDestination.getClass().equals(typeSource.getClass())) {
            throw new RuntimeException("[Affectation] Les types ne sont pas compatibles.");
        }
        node.setType(typeDestination);
        return null;
    }

    @Override
    public Object visit(Bloc node) {
        node.getInstructions().forEach(i -> i.accept(this));
        return null;
    }

    @Override
    public Object visit(Chaine node) {
        return null;
    }

    @Override
    public Object visit(DeclarationProgramme node) {
        node.getDeclaration().accept(this);
        node.getInstructions().accept(this);
        return null;
    }

    @Override
    public Object visit(Egal node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getDroite().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException(String.format("[Egal] Les types ne sont pas compatibles. (Ligne %d, Colonne %d)", node.getLine(), node.getColumn()));
        }
        return null;
    }

    @Override
    public Object visit(Idf node) {
        return null;
    }

    @Override
    public Object visit(Nombre node) {
        return null;
    }

    @Override
    public Object visit(Booleen node) {
        return null;
    }

    @Override
    public Object visit(Different node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getDroite().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[Different] Les types ne sont pas compatibles.");
        }
        return null;
    }

    @Override
    public Object visit(Inferieur node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getDroite().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[Inferieur] Les types ne sont pas compatibles.");
        }
        return null;
    }

    @Override
    public Object visit(InferieurEgal node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getDroite().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[InferieurEgal] Les types ne sont pas compatibles.");
        }
        return null;
    }

    @Override
    public Object visit(Superieur node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getDroite().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[Superieur] Les types ne sont pas compatibles.");
        }
        return null;
    }

    @Override
    public Object visit(SuperieurEgal node) {
        node.getGauche().accept(this);
        Type typeGauche = node.getDroite().getType();

        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!typeGauche.getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[SuperieurEgal] Les types ne sont pas compatibles.");
        }
        return null;
    }

    @Override
    public Object visit(Tilda node) {
        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!node.getType().getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[Tilda] Les types ne sont pas compatibles.");
        }
        return null;
    }

    @Override
    public Object visit(Parentheses node) {
        node.getExpression().accept(this);
        return null;
    }

    @Override
    public Object visit(Ecrire node) {
        node.getSource().accept(this);
        return null;
    }

    @Override
    public Object visit(EcrireStringConstante node) {
        return null;
    }

    @Override
    public Object visit(TantQue node) {
        node.getCondition().accept(this);
        Type conditionType = node.getCondition().getType();
        if (!conditionType.getClass().equals(TypeBooleen.class)) {
            throw new RuntimeException("[TantQue] Les types ne sont pas compatibles.");
        }
        node.getBody().accept(this);
        return null;
    }

    @Override
    public Object visit(Pour node) {
        node.getIdent().accept(this);
        Type idfType = node.getIdent().getType();
        if (!idfType.getClass().equals(TypeInteger.class)) {
            throw new RuntimeException("[Pour] Les types ne sont pas compatibles.");
        }
        node.getFrom().accept(this);
        Type fromType = node.getFrom().getType();
        if (!fromType.getClass().equals(TypeInteger.class)) {
            throw new RuntimeException("[Pour] Les types ne sont pas compatibles.");
        }
        node.getTo().accept(this);
        Type toType = node.getFrom().getType();
        if (!toType.getClass().equals(TypeInteger.class)) {
            throw new RuntimeException("[Pour] Les types ne sont pas compatibles.");
        }
        node.getBody().accept(this);
        return null;
    }

    @Override
    public Object visit(Non node) {
        node.getDroite().accept(this);
        Type typeDroite = node.getDroite().getType();

        if (!node.getType().getClass().equals(typeDroite.getClass())) {
            throw new RuntimeException("[Non] Les types ne sont pas compatibles.");
        }
        return null;
    }

    @Override
    public Object visit(TypeInteger node) {
        return null;
    }

    @Override
    public Object visit(TypeBooleen node) {
        return null;
    }

    @Override
    public Object visit(Si node) {
        node.getCondition().accept(this);
        if (!node.getCondition().getType().getClass().equals(TypeBooleen.class)) {
            throw new RuntimeException("[Si] Les types ne sont pas compatibles.");
        }
        node.getThenBody().accept(this);
        return null;
    }

    @Override
    public Object visit(SiSinon node) {
        node.getCondition().accept(this);
        if (!node.getCondition().getType().getClass().equals(TypeBooleen.class)) {
            throw new RuntimeException("[SiSinon] Les types ne sont pas compatibles.");
        }
        node.getThenBody().accept(this);
        node.getElseBody().accept(this);
        return null;
    }

    @Override
    public Object visit(Lire node) {
        return null;
    }
}
