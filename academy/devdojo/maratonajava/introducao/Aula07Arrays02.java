package academy.devdojo.maratonajava.introducao;

public class Aula07Arrays02 {
    static void main() {
        // byte, short, int, long, float e double 0
        // char '/u0000' '  '
        // String null
        // boolean false


        String[] nomes = new String[4];
        nomes[0] = "Enzo";
        nomes[1] = "Maria";
        nomes[2] = "Alcione";
        nomes[3] = "Andre";

        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }
    }
}
