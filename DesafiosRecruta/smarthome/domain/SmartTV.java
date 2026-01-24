package DesafiosRecruta.smarthome.domain;

public class SmartTV extends Dispositivo implements ConectavelInternet, AssistenteVoz{
    public SmartTV(String nome) {
        super(nome);
    }

    @Override
    public void ouvirComando(String comando) {
        System.out.println("TV processando comando: "+ comando);
    }

    @Override
    public void ativarFuncaoPrincipal() {
        System.out.println("Abrindo menu de streaming");
    }

    @Override
    public void conectarWifi(String nomeRede) {
        System.out.println("SmartTV conectada no Wifi: " + nomeRede);
    }

}
