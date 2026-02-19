package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Smartphone;

public class Aula161_EqualsTest01{
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABV2", "iPhone");
        Smartphone s2 = new Smartphone("1ABV2", "Samsung");
        // a comparação está apenas no serialNumber, verificar a partir da regra de negócio

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
