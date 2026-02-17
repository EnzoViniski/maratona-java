package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Smartphone;

public class Aula161_EqualsTest01{
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABV2", "iPhone");
        Smartphone s2 = s1;

        System.out.println(s1.equals(s2));
    }
}
