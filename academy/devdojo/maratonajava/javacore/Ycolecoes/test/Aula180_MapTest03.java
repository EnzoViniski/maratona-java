package academy.devdojo.maratonajava.javacore.Ycolecoes.test;


import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

import java.util.*;

public class Aula180_MapTest03 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("DevDojo Academy");
        Consumidor consumidor2 = new Consumidor("William Suane");

        Manga manga1 = new Manga(2L, "Dragon Ball", 34.2, 2);
        Manga manga2 = new Manga(1L, "Naruto", 19.99, 3);
        Manga manga3 = new Manga(3L, "Pokemon", 15.6, 0);
        Manga manga4 = new Manga(4L, "Apenas um Show", 3.2, 1);
        Manga manga5 = new Manga(5L, "Incrivel Mundo de Gumball", 2.99, 0);

        List<Manga> mangasConsimidor1List = List.of(manga1, manga2, manga3);
        List<Manga> mangasConsimidor2List = List.of(manga4, manga5);

        // Aqui estamos criando um Map com os consumidores como KEY e uma lista com todos os mangas compros por esse consumidor como VALUE

        Map<Consumidor, List<Manga>> consumidorManga = new LinkedHashMap<>();
        consumidorManga.put(consumidor1, mangasConsimidor1List);
        consumidorManga.put(consumidor2, mangasConsimidor2List);

        for (Map.Entry<Consumidor, List<Manga>> entry : consumidorManga.entrySet()) {
            System.out.println("---"+entry.getKey().getNome());
            for (Manga manga : entry.getValue()) {
                System.out.println("-----"+manga.getNome());
            }

        }


    }
}
