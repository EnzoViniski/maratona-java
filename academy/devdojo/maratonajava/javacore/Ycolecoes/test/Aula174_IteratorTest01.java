package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Comparator implements java.util.Comparator<Manga>{
    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getNome().compareTo(manga2.getNome());
    }
}

public class Aula174_IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(1L, "Naruto", 19.99, 3));
        mangas.add(new Manga(2L, "Dragon Ball", 34.2, 2));
        mangas.add(new Manga(3L, "Pokemon", 15.6, 0));
        mangas.add(new Manga(4L, "Apenas um Show", 3.2, 1));
        mangas.add(new Manga(5L, "Incrivel Mundo de Gumball", 2.99, 0));

//        Collections.sort(mangas, new Comparator());
//        for (Manga manga : mangas) {
//            System.out.println(manga);
//        }

//        Iterator<Manga> mangaIterator = mangas.iterator();
//        while (mangaIterator.hasNext()) {
//            if (mangaIterator.next().getQuantidade() == 0) {
//                mangaIterator.remove();
//            }
//        }

        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        System.out.println(mangas);

    }
}
