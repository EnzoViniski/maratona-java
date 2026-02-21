package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aula169_ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);

        mangas.add("Naruto");
        mangas.add("Goku");
        mangas.add("Pokemon");
        mangas.add("Atack");

        Collections.sort(mangas);

        for (String manga : mangas) {
            System.out.println(manga);
        }

        List<Double> numeros = new ArrayList<>();
        numeros.add(1.2);
        numeros.add(5.2);
        numeros.add(1.42);
        numeros.add(81.2);

        Collections.sort(numeros);

        for (Double numero : numeros) {
            System.out.println(numero);
        }

//        Manga manga = new Manga(2L, null, 2);

    }
}
