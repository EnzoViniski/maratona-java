package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;
class mangaComparatorByPreco implements Comparator<Manga>{
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}
public class Aula177_NavigableSetTest02 {
    public static void main(String[] args) {
        NavigableSet<Manga> mangas = new TreeSet<>(new mangaComparatorByPreco());

        mangas.add(new Manga(1L, "Naruto", 19.99, 3));
        mangas.add(new Manga(2L, "Dragon Ball", 34.2, 2));
        mangas.add(new Manga(3L, "Pokemon", 15.6, 0));
        mangas.add(new Manga(4L, "Apenas um Show", 3.2, 1));
        mangas.add(new Manga(5L, "Incrivel Mundo de Gumball", 2.99, 0));
        mangas.add(new Manga(5L, "Incrivel Mundo de Gumball", 2.99, 0));

//        for (Manga manga : mangas.descendingSet()) { // descendingSet retorna de forma decrescente
//            System.out.println(manga);
//        }
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        // lower <
        //floor <=
        // higher >
        // ceiling >=
        System.out.println("---------");
        Manga yuyu = new Manga(7L, "yuyu", 19.99, 3);
        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));

        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst());
        System.out.println(mangas.size());
        System.out.println(mangas.pollLast());
        System.out.println(mangas.size());


    }
}
