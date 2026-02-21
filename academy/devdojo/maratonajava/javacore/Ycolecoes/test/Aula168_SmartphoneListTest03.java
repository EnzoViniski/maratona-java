package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class Aula168_SmartphoneListTest03 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("2222", "iPhone");
        Smartphone s2 = new Smartphone("3333", "Pixel");
        Smartphone s3 = new Smartphone("4444", "Samsung");
        List<Smartphone> smartphones = new ArrayList<>(6);
        smartphones.add(s1);
        smartphones.add(s2);
        smartphones.add(0,s3);

        for (Smartphone smartphone : smartphones) {
            System.out.println(smartphone.toString());
        }

        Smartphone s4 = new Smartphone("322333", "Pixel");

        System.out.println(smartphones.contains(s4));
        int indexSmartphone4 = smartphones.indexOf(s4);
        System.out.println(indexSmartphone4);

    }
}
