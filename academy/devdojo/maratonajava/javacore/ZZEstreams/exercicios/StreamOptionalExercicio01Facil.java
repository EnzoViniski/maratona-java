package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamOptionalExercicio01Facil {
    private static final List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 5.99),
            new LightNovel("Bakugan", 8.00),
            new LightNovel("Dragon Ball", 2.99),
            new LightNovel("Goku", 3.99),
            new LightNovel("Pokemon", 7.55),
            new LightNovel("Amazing Spider Man", 0.99),
            new LightNovel("Shipudden", 0.99)
    ));

    public static void main(String[] args) {
        System.out.println("Tres titulos baratos ordenados:");
        System.out.println(buscarTresTitulosBaratosOrdenados());

        Optional<LightNovel> lightNovel = buscarPorTitulo("Goku");
        lightNovel.ifPresent(ln -> System.out.println("Encontrado: " + ln));

        String titulo = buscarTituloOuPadrao("Bleach");
        System.out.println(titulo);
    }

    private static List<String> buscarTresTitulosBaratosOrdenados() {
         return  lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() < 4)
                .limit(3)
                .map(LightNovel::getTitle)
                .collect(Collectors.toList());
    }

    private static Optional<LightNovel> buscarPorTitulo(String title) {
        for (LightNovel lightNovel : lightNovels) {
            if(lightNovel.getTitle().equals(title)){
                return Optional.of(lightNovel);
            }
        }
        return Optional.empty();
    }

    private static String buscarTituloOuPadrao(String title) {
        return buscarPorTitulo(title)
                .map(LightNovel::getTitle)
                .orElse("Light novel nao encontrada");
    }
}
