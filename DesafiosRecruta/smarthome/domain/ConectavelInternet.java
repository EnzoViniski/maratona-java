package DesafiosRecruta.smarthome.domain;

public interface ConectavelInternet {
    void conectarWifi(String nomeRede);

    static void validarSinal(){
        System.out.println("Validando intensidade do sinal...");
    }

}
