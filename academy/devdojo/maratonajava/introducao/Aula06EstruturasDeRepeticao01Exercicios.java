package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao01Exercicios {
    static void main() {
        int i;
        /* for (i = 1; i <1000001; i++ ){
            System.out.println("FOR = "+i);
        }
         */

        /* i = 0;
        while (i < 1000000) {
            System.out.println(++i);
        }
         */
        i = 0;
        do{
            i++;
            if (i % 2 == 0){
                System.out.println(i);
            }
        } while (i < 1000000);
    }
}
