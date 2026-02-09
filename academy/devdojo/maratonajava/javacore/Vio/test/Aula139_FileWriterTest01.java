package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// File
// FileWriter
// FileReader
// BufferedWriter
// BufferedReader
public class Aula139_FileWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try(FileWriter fw = new FileWriter(file,true)) {
            fw.write("O DevDojo é top, o melhor curso do Brasiiiiiillllll");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
