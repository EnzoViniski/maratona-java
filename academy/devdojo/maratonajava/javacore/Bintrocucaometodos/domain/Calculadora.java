package academy.devdojo.maratonajava.javacore.Bintrocucaometodos.domain;

public class Calculadora {

    public void somaDoisNumeros() {
        System.out.println(10 + 10);
    }

    public void subtraiDoisNumeros() {
        System.out.println(21 - 2);
    }

    public void multiplicaDoisNumeros(int num1, float num2) {
        //Se vc tem uma função (método) com mais de 3 argumentos, ela ta fazendo muita coisa
        System.out.println(num1 * num2);
    }

    public double divideDoisNumeros(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Não existe divisão por zero");
            return 0;

        } else {
            return num1 / num2;
        }
    }

    public void imprimeDivisaoDeDoisNumeros(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Não existe divisão por zero");
            return;
        }

        System.out.println(num1 / num2);

    }

    public void alteraDoisNumeros(int num1, int num2) {
        num1 = 99;
        num2 = 33;
        System.out.println("Dentro do altera dois números");
        System.out.println("Num1: " + num1);
        System.out.println("Num2: " + num2);
    }

    public void somaArray (int[] numeros){
        int sum = 0;
        for(int temp : numeros ){
            sum += temp;
        }
        System.out.println(sum);
    }

    public void somaVarArgs (int num, int... numeros ){ // nao pode ter argumentos depois, apenas antes
        int sum = 0;
        for(int temp : numeros ){
            sum += temp;
        }
        System.out.println(sum);
    }
}
