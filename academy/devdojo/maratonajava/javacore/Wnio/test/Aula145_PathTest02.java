package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Aula145_PathTest02 {
    public static void main(String[] args) throws IOException {
        Path pasta = Paths.get("pasta");
        if(Files.notExists(pasta)){
            Path pastaPath = Files.createDirectory(pasta);
        }
        Path subPastaPath = Paths.get("pasta/subasta/subsubpasta");
        Path createSubPasta = Files.createDirectories(subPastaPath);
        Path filePath = Paths.get(subPastaPath.toString(), "test.txt");

        if(Files.notExists(filePath)){
            Path createFilePath = Files.createFile(filePath);
        }

        Path source = filePath;
        Path target = Paths.get(filePath.getParent().toString(), "test_renamed.txt");

        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}
