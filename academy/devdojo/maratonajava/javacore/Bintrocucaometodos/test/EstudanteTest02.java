package academy.devdojo.maratonajava.javacore.Bintrocucaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintrocucaometodos.domain.Estudante;
import academy.devdojo.maratonajava.javacore.Bintrocucaometodos.domain.ImpressoraEstudante;

public class EstudanteTest02 {
    public static void main(String[] args) {
        Estudante estudante1 = new Estudante();
        Estudante estudante2 = new Estudante();
        estudante1.name = "Heitor";
        estudante1.age = 22;
        estudante1.sex = 'M';

        estudante2.name = "Ramos";
        estudante2.age = 32;
        estudante2.sex = 'F';

        estudante1.imprime();
        estudante2.imprime();
    }
}