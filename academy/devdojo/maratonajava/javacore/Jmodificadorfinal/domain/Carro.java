package academy.devdojo.maratonajava.javacore.Jmodificadorfinal.domain;

public class Carro {
    private String nome;
    public static final double VELOCIDADE_LIMITE;
    public final Comprador COMPRADOR = new Comprador();
    // Essa referencia (new Comprador()) nunca mais poderá ser alterado
//    public static final double VELOCIDADE_LIMITE = 250;
    static {
        VELOCIDADE_LIMITE = 250;
    }

//    public Carro(){
//        VELOCIDADE_LIMITE = 250;
//    }

    public final void imprime(){
        System.out.println(this.nome);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
