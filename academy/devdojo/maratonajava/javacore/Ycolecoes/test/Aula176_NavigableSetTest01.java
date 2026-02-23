package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;
class comparatorSmartphone implements Comparator<Smartphone>{
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}
public class Aula176_NavigableSetTest01 {
    public static void main(String[] args) {
        // treeset serve quando temos certeza que a classe é comparable ou temos uma classe comparator implementada para ela.
        // ele funciona bem porém ainda nao é o melhor, ele vai ordenar a partir do compareTo definido na classe e não vai permitir a duplicacão de objetos
        NavigableSet<Smartphone> set = new TreeSet<>(new comparatorSmartphone());
        set.add(new Smartphone("12345","Iphone"));
        set.add(new Smartphone("54321","Samsung"));

        NavigableSet<Manga> mangas = new TreeSet<>();

        mangas.add(new Manga(1L, "Naruto", 19.99, 3));
        mangas.add(new Manga(2L, "Dragon Ball", 34.2, 2));
        mangas.add(new Manga(3L, "Pokemon", 15.6, 0));
        mangas.add(new Manga(4L, "Apenas um Show", 3.2, 1));
        mangas.add(new Manga(5L, "Incrivel Mundo de Gumball", 2.99, 0));
        mangas.add(new Manga(5L, "Incrivel Mundo de Gumball", 2.99, 0));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}
