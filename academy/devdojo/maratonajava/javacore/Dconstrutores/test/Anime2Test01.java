package academy.devdojo.maratonajava.javacore.Dconstrutores.test;

import academy.devdojo.maratonajava.javacore.Dconstrutores.domain.Anime2;

public class Anime2Test01 {
    public static void main(String[] args) {
        Anime2 anime = new Anime2("Naruin", "TV", 12, "Anime");
        Anime2 anime2 = new Anime2();
//        anime.setTipo("TV");
//        anime.setEpisodios(12);
//        anime.setNome("Naruto");

        anime.imprime();
    }
}
