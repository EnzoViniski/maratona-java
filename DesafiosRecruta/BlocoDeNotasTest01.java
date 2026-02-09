package DesafiosRecruta;

import java.io.*;
import java.util.Scanner;

public class BlocoDeNotasTest01 {
    public static void main(String[] args) {
        File file = new File("bloconotas.txt");
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o que quer colocar no bloco de notas");
        String texto = input.nextLine();
        try(FileWriter fw = new FileWriter(file)) {
            fw.write(texto);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Deseja ler o arquivo? (1 - SIM, 2 - NAO)");
        int j = input.nextInt();
        if(j == 1) {
            try (FileReader fr = new FileReader(file)) {
                int i;
                while ((i = fr.read()) != -1) {
                    System.out.print((char) i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Fechando Arquivo");
        }
    }
}
