package DesafiosRecruta.smarthome.domain;

public interface AssistenteVoz {

    void ouvirComando(String comando);

    default void ativarMicrofone(){
        System.out.println("Microfone ativado e pronto para ouvir");
    }
}
