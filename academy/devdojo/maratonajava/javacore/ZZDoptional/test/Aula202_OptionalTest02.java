package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import academy.devdojo.maratonajava.javacore.ZZDoptional.domain.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repository.MangaRepository;

import java.util.Optional;

public class Aula202_OptionalTest02 {
    public static void main(String[] args) {
        Optional<Manga> mangaByTitle = MangaRepository.findByTittle("Boku no hero");
        mangaByTitle.ifPresent(m -> m.setTitle("Boku no hero 2"));
        System.out.println(mangaByTitle);

        Manga mangaById = MangaRepository.findById(2)
                .orElseThrow(IllegalArgumentException::new);

        System.out.println(mangaById);

        Manga newManga = MangaRepository.findByTittle("Drifters")
                .orElseGet(() -> new Manga(3, "Drifters", 15));

        System.out.println(newManga);
    }
}
