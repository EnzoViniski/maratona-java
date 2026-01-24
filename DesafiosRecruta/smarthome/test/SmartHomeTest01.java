package DesafiosRecruta.smarthome.test;


import DesafiosRecruta.smarthome.domain.ConectavelInternet;
import DesafiosRecruta.smarthome.domain.Dispositivo;
import DesafiosRecruta.smarthome.domain.LampadaInteligente;
import DesafiosRecruta.smarthome.domain.SmartTV;

public class SmartHomeTest01 {
    public static void main(String[] args) {
        LampadaInteligente lampada1 = new LampadaInteligente("Luz da cozinha");
        SmartTV smartTV1 = new SmartTV("LG 65 polegadas");

        lampada1.ligar();
        smartTV1.ligar();

        lampada1.ativarFuncaoPrincipal();
        smartTV1.ativarFuncaoPrincipal();

        System.out.println("-------------");

        lampada1.conectarWifi("DevDojo_5G");
        smartTV1.conectarWifi("DevDojo_5G");

        ConectavelInternet.validarSinal();

        System.out.println("---------------");

        smartTV1.ativarMicrofone();
        smartTV1.ouvirComando("Trocar canal");







    }
}
