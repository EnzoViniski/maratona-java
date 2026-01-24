package academy.devdojo.maratonajava.javacore.Aintrocucaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintrocucaoclasses.domain.CandidatoDev;

public class CandidatoDevTest01 {
    public static void main(String[] args) {
        CandidatoDev candidatoDev = new CandidatoDev();
        CandidatoDev candidato2 = new CandidatoDev();
        candidato2.age = 12;
        candidato2.name = "Luiz";
        candidato2.linguagemFoco = "Go lang";
        candidatoDev.name = "Enzo";
        candidatoDev.age = 18;
        candidatoDev.linguagemFoco = "Java";
        candidatoDev.imprime();
        candidatoDev.verificarStatus();
        System.out.println("-----");
        candidato2.imprime();
        candidato2.verificarStatus();

    }

}
