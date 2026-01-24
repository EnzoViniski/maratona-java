package academy.devdojo.maratonajava.javacore.Eblocosinicializacao.test;

import academy.devdojo.maratonajava.javacore.Eblocosinicializacao.domain.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime("One Piece");
        System.out.println(anime.getEpisodios());
//        (option + enter + interate)
        for (int episodio : anime.getEpisodios()) {
            System.out.print(episodio + " ");
        }
        System.out.println();

    }
}
