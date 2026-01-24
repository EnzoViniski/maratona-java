package DesafiosRecruta.ecomerce.domain;

import academy.devdojo.maratonajava.javacore.Kenum.domain.TipoPagamento;

public class Produto {
    private String nome;
    private double preco;
    private Categoria categoria;
    private static int TOTAL_PRODUTOS;

    {
        TOTAL_PRODUTOS += 1;
    }
    public Produto(String nome, double preco, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public void imprime(){
        System.out.println("Nome produto: " + this.nome);
        System.out.println("Preço: "+this.preco);
        System.out.println("Categoria: "+this.categoria);
        System.out.println("Preço com imposto: ");
        System.out.println(categoria.calcularImposto(this.preco) + this.preco);


    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
