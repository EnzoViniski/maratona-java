package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Aula175_SetTest01 {
    public static void main(String[] args) {
        // o Set permite que criemos a lista de forma a não ter elementos duplicados, sendo verificada por meio do hashCode definido na classe
        Set<Manga> mangas = new LinkedHashSet<>(); // continua na ordem de inserção
//        Set<Manga> mangas = new HashSet<>();

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
