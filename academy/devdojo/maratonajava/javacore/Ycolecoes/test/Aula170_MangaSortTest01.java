package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MangaByIdComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getId().compareTo(manga2.getId());
    }
}
public class Aula170_MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(3L, "Naruto", 12.2));
        mangas.add(new Manga(5L, "Goku", 19.9));
        mangas.add(new Manga(4L, "Atack", 20.1));
        mangas.add(new Manga(1L, "Dragon Ball", 3.22));
        mangas.add(new Manga(2L, "Pokemon", 4.90));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("-----------");

        Collections.sort(mangas);
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        System.out.println("-----------");

        Collections.sort(mangas , new MangaByIdComparator());
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}
