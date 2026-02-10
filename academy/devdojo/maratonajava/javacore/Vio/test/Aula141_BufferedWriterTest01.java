package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Aula141_BufferedWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write("O DevDojo é top, o melhor curso do ");
            bw.newLine(); //pula a linha de acordo com o sistema operacional
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
