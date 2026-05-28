package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios;

import academy.devdojo.maratonajava.javacore.ZZDoptional.domain.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repository.MangaRepository;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamOptionalExercicio02Medio {
    private static final List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 5.99),
            new LightNovel("Bakugan", 8.00),
            new LightNovel("Dragon Ball", 2.99),
            new LightNovel("Goku", 3.99),
            new LightNovel("Pokemon", 7.55),
            new LightNovel("Amazing Spider Man", 5.99),
            new LightNovel("Shipudden", 0.99)
    ));

    public static void main(String[] args) {
        renomearMangaSeExistir("Naruto", "Naruto Shippuden");

        Manga manga = buscarMangaObrigatorio(2);
        System.out.println(manga);

        Manga fallback = buscarMangaOuCriar("Bleach");
        System.out.println(fallback);

        System.out.println("Quantidade de light novels baratas:");
        System.out.println(contarLightNovelsBaratasSemRepetir());

        System.out.println("Titulos para vitrine:");
        System.out.println(buscarTitulosParaVitrine(6));

        System.out.println("Buscar primeiro:");
        System.out.println(buscarPrimeiraLightNovelAbaixoDe(6));
    }

    private static void renomearMangaSeExistir(String tituloAtual, String novoTitulo) {
        MangaRepository.findByTittle(tituloAtual)
                .ifPresent(m -> m.setTitle(novoTitulo));
    }

    private static Manga buscarMangaObrigatorio(Integer id) {
        return MangaRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    private static Manga buscarMangaOuCriar(String titulo) {
        return MangaRepository.findByTittle(titulo)
                .orElseGet(() -> new Manga(99, titulo, 1));
    }

    private static long contarLightNovelsBaratasSemRepetir() {
        return lightNovels.stream()
                .distinct()
                .filter(ln -> ln.getPrice() < 4)
                .count();
    }

    private static List<String> buscarTitulosParaVitrine(double maxPrice) {
        return lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getPrice)
                        .thenComparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() <= maxPrice)
                .map(LightNovel::getTitle)
                .collect(Collectors.toList());
    }

    private static Optional<LightNovel> buscarPrimeiraLightNovelAbaixoDe(double maxPrice) {
        // Poderia retornar direto da stream com findFirst(), sem transformar em List<String>.
        // Aqui firstLowerPriceTitle vira uma lista de titulos, entao a comparacao com getTitle() nunca fica verdadeira.
        return lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() < maxPrice)
                .findFirst();
    }
}
