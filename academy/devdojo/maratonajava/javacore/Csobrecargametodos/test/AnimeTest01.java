package academy.devdojo.maratonajava.javacore.Csobrecargametodos.test;

import academy.devdojo.maratonajava.javacore.Csobrecargametodos.domain.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime();
        anime.init("Naruin", "TV", 12, "Anime");
//        anime.setTipo("TV");
//        anime.setEpisodios(12);
//        anime.setNome("Naruto");

        anime.imprime();
    }
}
