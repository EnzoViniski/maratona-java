package academy.devdojo.maratonajava.javacore.Bintrocucaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintrocucaometodos.domain.Calculadora;

public class CalculadoraTest03 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.divideDoisNumeros(20,1);
        System.out.println(result);
        System.out.println("--------");
        calculadora.imprimeDivisaoDeDoisNumeros(1, 0);
    }
}
