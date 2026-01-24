package academy.devdojo.maratonajava.javacore.Bintrocucaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintrocucaometodos.domain.Calculadora;

public class CalculadoraTest05 {
    public static void main(String... args) {
        Calculadora calculadora = new Calculadora();
        int[] numeros = {1, 2, 3, 4, 5};
        calculadora.somaArray(numeros);
        calculadora.somaVarArgs(1, 2, 3, 4, 5, 6, 7); // pode passar os numeros diretos e sao tranformados em array,
    }
}
