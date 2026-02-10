package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class Aula143_FileTest02 {
    public static void main(String[] args) throws IOException {
        File fileDiretorio = new File("pasta");
        boolean isDiretorioCreated = fileDiretorio.mkdir();
        System.out.println("Pasta criada? "+isDiretorioCreated);

        File fileArquivoDiretorio = new File(fileDiretorio, "arquivo.txt");
        boolean isArquivoCreated = fileArquivoDiretorio.createNewFile();
        System.out.println("Arquivo criado? "+isArquivoCreated);

        File renamedFile = new File(fileDiretorio, "arquivo_renomeado.txt");
        boolean isArquivoRenamed = fileArquivoDiretorio.renameTo(renamedFile);
        System.out.println("Arquivo renomeado? "+isArquivoRenamed);

        File renamedDiretorio = new File("pasta2");
        boolean isDiretorioRenamed = fileDiretorio.renameTo(renamedDiretorio);
        System.out.println("Pasta renomeada? "+isDiretorioRenamed);
    }
}
