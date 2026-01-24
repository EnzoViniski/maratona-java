package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao01ExerciciosBreak {
    static void main() {
        int i = 0;
        int soma = 0;
        for (i = 0; i < 1; ) {
            System.out.println(++soma);
            if (soma > 24) {
                i = 1;
            }
        }
    }
}
