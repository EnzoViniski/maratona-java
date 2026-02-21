package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aula172_BinarySearchTest02 {
    public static void main(String[] args) {
        MangaByIdComparator mangaByIdComparator = new MangaByIdComparator();
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(3L, "Naruto", 12.2));
        mangas.add(new Manga(5L, "Goku", 19.9));
        mangas.add(new Manga(4L, "Atack", 20.1));
        mangas.add(new Manga(1L, "Dragon Ball", 3.22));
        mangas.add(new Manga(2L, "Pokemon", 4.90));

//        Collections.sort(mangas);
        mangas.sort(mangaByIdComparator);
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga mangaSearch = new Manga(5L, "Goku", 19.9);
        System.out.println(Collections.binarySearch(mangas,mangaSearch, mangaByIdComparator));

    }
}
