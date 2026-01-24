package academy.devdojo.maratonajava.javacore.Minterfaces.domain;

public interface DataRemover {
    void remove();
    public default void checkingPermission(){
        System.out.println("Checando permissões...");
    }
}
