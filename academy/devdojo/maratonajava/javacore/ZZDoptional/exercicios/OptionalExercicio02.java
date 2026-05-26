package academy.devdojo.maratonajava.javacore.ZZDoptional.exercicios;

import academy.devdojo.maratonajava.javacore.ZZDoptional.domain.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repository.MangaRepository;

public class OptionalExercicio02 {
    public static void main(String[] args) {
        MangaRepository.findByTittle("Naruto")
                .ifPresent(m -> m.setTitle("Naruto Shippuden"));

        MangaRepository.findByTittle("Naruto Shippuden")
                .ifPresent(m -> System.out.println(m));

        Manga mangaById = MangaRepository.findById(1)
                .orElseThrow(IllegalArgumentException::new);

        System.out.println(mangaById);

        Manga newManga = MangaRepository.findByTittle("Bleach")
                .orElseGet(() -> new Manga(3, "Bleach", 74));

        System.out.println(newManga);
    }

    private static void imprimirSeparador() {
        System.out.println("------------------------------");
    }
}
