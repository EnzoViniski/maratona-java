package academy.devdojo.maratonajava.javacore.Minterfaces.domain;

public class FileLoader implements DataLoader, DataRemover{
    @Override
    public void load() {
        System.out.println("Carregando dados de um arquivo...");
    }

    @Override
    public void remove() {
        System.out.println("Deletando dados de um arquivo...");
    }

//    @Override
//    public void checkingPermission() {
//        DataRemover.super.checkingPermission();
//    }
}
