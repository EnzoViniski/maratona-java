package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

class MangaByPrecoComparator extends Comparator {

    @Override
    public int compare(Manga manga1, Manga manga2) {
        return Double.compare(manga1.getPreco(), manga2.getPreco());
    }
}

public class Aula182_QueueTest02 {
    public static void main(String[] args) {
        Queue<Manga> mangas = new PriorityQueue<>(new MangaByIdComparator());
        mangas.add(new Manga(2L, "Dragon Ball", 34.2, 2));
        mangas.add(new Manga(1L, "Naruto", 19.99, 3));
        mangas.add(new Manga(5L, "Incrivel Mundo de Gumball", 2.99, 0));
        mangas.add(new Manga(3L, "Pokemon", 15.6, 0));
        mangas.add(new Manga(4L, "Apenas um Show", 3.2, 1));

        while (!mangas.isEmpty()){
            System.out.println(mangas.poll());
        }

    }
}
