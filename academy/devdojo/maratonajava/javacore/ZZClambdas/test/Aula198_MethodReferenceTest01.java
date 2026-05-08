package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.domain.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

// Reference to a static method
public class Aula198_MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 43), new Anime("Naruto", 800), new Anime("One Piece", 120)));
        animeList.sort((a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));
        System.out.println(animeList);
        animeList.sort(AnimeComparators::compareByEpisodes);
        System.out.println(animeList);
        animeList.sort(AnimeComparators::compareByTitle);
        System.out.println(animeList);
    }
}
