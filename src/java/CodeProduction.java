import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CodeProduction implements ASTVisitor {
    public StringBuilder sb;
    private int compteurVariables = 2;
    private int compteurLabels = 0;
    HashMap<String, Integer> varsIds;

    public CodeProduction() {
        this.sb = new StringBuilder();
        this.varsIds = new HashMap<>();
    }

    private void add(String line) {
        this.sb.append(line).append("\n");
    }

    public void toJasminFile(String filenameWithoutExt) throws IOException {
        this.add("return");
        this.add(".end method");
        FileOutputStream oS = new FileOutputStream(new File(String.format("dist/%s.j", filenameWithoutExt)));
        oS.write(this.sb.toString().getBytes());
        oS.close();
    }

    @Override
    public Object visit(And node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.add("iand");
        return null;
    }

    @Override
    public Object visit(Or node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.add("ior");
        return null;
    }

    @Override
    public Object visit(Addition node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.add("iadd");
        return null;
    }

    @Override
    public Object visit(Soustraction node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.add("isub");
        return null;
    }

    @Override
    public Object visit(Multiplication node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.add("imul");
        return null;
    }

    @Override
    public Object visit(Division node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.add("idiv");
        return null;
    }

    @Override
    public Object visit(Affectation node) {
        node.getSource().accept(this);
        Idf idf = (Idf) node.getDestination();
        this.add(String.format("istore %d", this.varsIds.get(idf.getNom())));
        return null;
    }

    @Override
    public Object visit(Bloc node) {
        node.getInstructions().forEach(i -> i.accept(this));
        return null;
    }

    @Override
    public Object visit(Chaine node) {
        this.add("ldc " + node.getValeur());
        return null;
    }

    @Override
    public Object visit(DeclarationProgramme node) {
        this.add(String.format(".class public %s", node.getIdentifier()));
        this.add(".super java/lang/Object");
        this.add(".method public static main([Ljava/lang/String;)V");
        this.add(".limit stack 20000");
        this.add(".limit locals 10000");

        // Initialisation des variables + constantes
        for (Map.Entry<String, Type> entry : node.getVars().entrySet()) {
            String nom = entry.getKey();
            Type type = entry.getValue();
            this.add(String.format(".var %d is %s %s", this.compteurVariables, nom, type));
            this.varsIds.put(nom, this.compteurVariables);
            this.compteurVariables += 1;
        }

        node.getDeclaration().accept(this);
        node.getInstructions().accept(this);
        return null;
    }

    @Override
    public Object visit(Egal node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.sb.append("if_icmpeq ");
        return null;
    }

    @Override
    public Object visit(Idf node) {
        int id = this.varsIds.get(node.getNom());
        this.add(String.format("iload %d", id));
        return null;
    }

    @Override
    public Object visit(Nombre node) {
        this.add(String.format("ldc %d", node.getValeur()));
        return null;
    }

    @Override
    public Object visit(Booleen node) {
        this.add(String.format("ldc %s", node));
        return null;
    }

    @Override
    public Object visit(Different node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.sb.append("if_icmpne ");
        return null;
    }

    @Override
    public Object visit(Inferieur node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.sb.append("if_icmplt ");
        return null;
    }

    @Override
    public Object visit(InferieurEgal node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.sb.append("if_icmple ");
        return null;
    }

    @Override
    public Object visit(Superieur node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.sb.append("if_icmpgt ");
        return null;
    }

    @Override
    public Object visit(SuperieurEgal node) {
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        this.sb.append("if_icmpge ");
        return null;
    }

    @Override
    public Object visit(Tilda node) {
        this.add("ldc -1");
        if (node.getDroite().getClass().equals(Idf.class)) {
            Idf idf = (Idf) node.getDroite();
            int id = this.varsIds.get(idf.getNom());
            this.add(String.format("iload %d", id));
        } else {
            node.getDroite().accept(this);
        }
        this.add("ixor");
        return null;
    }

    @Override
    public Object visit(Parentheses node) {
        node.getExpression().accept(this);
        return null;
    }

    @Override
    public Object visit(Ecrire node) {
        this.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
        node.getSource().accept(this);
        Type sourceType = node.getSource().getType();
        if (sourceType.getClass().equals(TypeInteger.class)) {
            this.add("invokevirtual java/io/PrintStream/println(I)V");
        } else {
            int labelId = this.compteurLabels++;
            String labelElse = String.format("label_else_%d", labelId);
            String labelFin = String.format("label_end_%d", labelId);
            this.add(String.format("ifeq %s", labelElse));
            this.add("ldc \"vrai\"");
            this.add(String.format("goto %s", labelFin));
            this.add(String.format("%s:", labelElse));
            this.add("ldc \"faux\"");
            this.add(String.format("%s:", labelFin));
            this.add("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        }
        return null;
    }

    @Override
    public Object visit(EcrireStringConstante node) {
        this.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
        this.add(String.format("ldc %s", node.getSource()));
        this.add("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        return null;
    }

    @Override
    public Object visit(TantQue node) {
        int loop_id = this.compteurLabels++;
        this.add(String.format("label_loop_%d:", loop_id));
        node.getCondition().accept(this);
        this.sb.append(String.format("label_alors_%d\n", loop_id));
        this.add(String.format("goto label_end_%d", loop_id));
        this.add(String.format("label_alors_%d:", loop_id));
        node.getBody().accept(this);
        this.add(String.format("goto label_loop_%d", loop_id));
        this.add(String.format("label_end_%d:", loop_id));
        return null;
    }

    @Override
    public Object visit(Pour node) {
        int loop_id = this.compteurLabels++;
        Idf idf = node.getIdent();
        int loopVarId = this.varsIds.get(idf.getNom());

        node.getFrom().accept(this);
        this.add(String.format("istore %d", loopVarId));

        this.add(String.format("label_loop%d:", loop_id));
        node.getTo().accept(this);
        node.getIdent().accept(this);

        this.add(String.format("if_icmplt label_end%d", loop_id));
        node.getBody().accept(this);

        node.getIdent().accept(this);
        this.add("ldc 1");
        this.add("iadd");
        this.add(String.format("istore %d", loopVarId));

        this.add(String.format("goto label_loop%d", loop_id));
        this.add(String.format("label_end%d:", loop_id));
        return null;
    }

    @Override
    public Object visit(Non node) {
        node.getDroite().accept(this);
        int labelId = this.compteurLabels++;
        String labelElse = String.format("label_else_%d", labelId);
        String labelFin = String.format("label_end_%d", labelId);

        this.add(String.format("ifeq %s", labelElse));
        this.add("iconst_0");
        this.add(String.format("goto %s", labelFin));
        this.add(String.format("%s:", labelElse));
        this.add("iconst_1");
        this.add(String.format("%s:", labelFin));
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
        int labelId = this.compteurLabels++;
        String labelAlors = String.format("label_alors_%d", labelId);
        String labelFin = String.format("label_end_%d", labelId);
        node.getCondition().accept(this);
        Expression cond = node.getCondition();
        if (cond.getClass().equals(Idf.class) || cond.getClass().equals(Booleen.class) ||
                cond.getClass().equals(And.class) || cond.getClass().equals(Or.class)  || cond.getClass().equals(Non.class)) {
            this.add("ldc 1");
            this.sb.append("if_icmpeq ");
        }
        this.sb.append(String.format("%s\n", labelAlors));
        this.add(String.format("goto %s", labelFin));
        this.add(String.format("%s:", labelAlors));
        node.getThenBody().accept(this);
        this.add(String.format("%s:", labelFin));
        return null;
    }

    @Override
    public Object visit(SiSinon node) {
        int labelId = this.compteurLabels++;
        String labelAlors = String.format("label_alors_%d", labelId);
        String labelFin = String.format("label_end_%d", labelId);
        node.getCondition().accept(this);
        Expression cond = node.getCondition();
        if (cond.getClass().equals(Idf.class) || cond.getClass().equals(Booleen.class) ||
                cond.getClass().equals(And.class) || cond.getClass().equals(Or.class) || cond.getClass().equals(Non.class)) {
            this.add("ldc 1");
            this.sb.append("if_icmpeq ");
        }

        this.sb.append(String.format("%s\n", labelAlors));
        node.getElseBody().accept(this);
        this.add(String.format("goto %s", labelFin));
        this.add(String.format("%s:", labelAlors));
        node.getThenBody().accept(this);
        this.add(String.format("%s:", labelFin));
        return null;
    }

    @Override
    public Object visit(Lire node) {
        Idf idf = node.getIdent();
        int varId = varsIds.get(idf.getNom());
        this.add("new java/util/Scanner");
        this.add("dup");
        this.add("getstatic java/lang/System/in Ljava/io/InputStream;");
        this.add("invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V");
        if (idf.getType().getClass().equals(TypeInteger.class)) {
            this.add("invokevirtual java/util/Scanner/nextInt()I");
        } else {
            this.add("invokevirtual java/util/Scanner/nextBoolean()Z");
        }
        this.add(String.format("istore %d", varId));
        return null;
    }
}
