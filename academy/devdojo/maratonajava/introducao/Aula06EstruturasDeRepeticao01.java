package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao01 {
    static void main() {
        // while, do while, for
        int i = 0;
        while (i < 10) {
            i++;
            System.out.println("while =" + i);
        }
        i = 0;

        do {
            i++;
            System.out.println("do while =" + i);
        } while (i < 10);

        for (i = 1; i <= 10; i++) {
            System.out.println("for =" + i);
        }
    }
}
