package DesafiosRecruta.ecomerce.domain;

import java.awt.font.TextHitInfo;

public class Notebook extends Produto{
    private int memoriaRam;

    public Notebook(String nome, double preco, Categoria categoria, int memoriaRam) {
        super(nome, preco, categoria);
        this.memoriaRam = memoriaRam;
    }

    public void imprime(){
        super.imprime();
        System.out.println("Memória RAM: "+ this.memoriaRam);
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }
}
