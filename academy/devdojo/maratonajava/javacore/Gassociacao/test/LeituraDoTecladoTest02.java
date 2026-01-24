package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import java.util.Scanner;

public class LeituraDoTecladoTest02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("O programa do sim ou não!");
        System.out.println("Faça sua pergunta:");
        String entrada = input.nextLine();
        if (entrada.charAt(0) == ' '){
            System.out.println("Não");
        } else {
            System.out.println("Sim");
        }
    }
}
