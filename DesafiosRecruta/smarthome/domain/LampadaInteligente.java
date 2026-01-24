package DesafiosRecruta.smarthome.domain;

public class LampadaInteligente extends Dispositivo implements ConectavelInternet {

    public LampadaInteligente(String nome) {
        super(nome);
    }

    @Override
    public void ativarFuncaoPrincipal() {
        System.out.println("Mudando para luz ambiente quente");
    }

    @Override
    public void conectarWifi(String nomeRede) {
        System.out.println("Lâmpada conectada na rede: " + nomeRede);
    }
}
