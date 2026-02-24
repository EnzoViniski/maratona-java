package academy.devdojo.maratonajava.javacore.Ycolecoes.test;


import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Aula179_MapTest02 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("DevDojo Academy");
        Consumidor consumidor2 = new Consumidor("William Suane");

        // option + botao esquerdo do mouse

        Manga manga1 = new Manga(2L, "Dragon Ball", 34.2, 2);
        Manga manga2 = new Manga(1L, "Naruto", 19.99, 3);
        Manga manga3 = new Manga(3L, "Pokemon", 15.6, 0);
        Manga manga4 = new Manga(4L, "Apenas um Show", 3.2, 1);
        Manga manga5 = new Manga(5L, "Incrivel Mundo de Gumball", 2.99, 0);

        Map<Consumidor, Manga> consumidorManga = new HashMap<>();
        consumidorManga.put(consumidor1, manga1);
        consumidorManga.put(consumidor2, manga4);

        for (Map.Entry<Consumidor, Manga> entry : consumidorManga.entrySet()) {
            System.out.println(entry.getKey().getNome() + " : " + entry.getValue().getNome());
        }


    }
}
