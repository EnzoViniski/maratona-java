package DesafiosRecruta.ecomerce.domain;

public class Camiseta extends Produto{
    private String tamanho;

    public Camiseta(String nome, double preco, Categoria categoria, String tamanho) {
        super(nome, preco, categoria);
        this.tamanho = tamanho;
    }

    @Override
    public void imprime() {
        super.imprime();
        System.out.println("Tamanho: " + this.tamanho);
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
