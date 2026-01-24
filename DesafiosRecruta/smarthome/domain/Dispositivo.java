package DesafiosRecruta.smarthome.domain;

public abstract class Dispositivo{
    private String nome;
    private boolean estado;

    public Dispositivo(String nome) {
        this.nome = nome;
    }

    public void ligar(){
        System.out.println("Ligando "+this.nome);
    }

    public void desligar(){
        System.out.println("Desligando "+this.nome);
    }

    public abstract void ativarFuncaoPrincipal();
}
