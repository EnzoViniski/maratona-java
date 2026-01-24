package academy.devdojo.maratonajava.introducao;

public class Aula07Arrays03 {
    static void main() {
        int[] numeros = new int[13];
        int[] numeros2 = {1,2,3,4,5};
        int[] numeros3 = new int[]{1,2,3,4,5};


        for (int i = 0; i < numeros3.length; i++){
            System.out.println(numeros3[i]);
        }
        System.out.println();

        //foreach
        for(int num : numeros3) {
            System.out.println(num);
        }
        for ( int num : numeros){
            System.out.println(num);
        }
    }
}
