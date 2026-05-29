package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas206a210;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.util.*;
import java.util.stream.Collectors;

public class Aulas206A210Exercicio01Facil {
    private static final List<List<LightNovel>> estantes = new ArrayList<>(List.of(
            List.of(
                    new LightNovel("Naruto", 5.99),
                    new LightNovel("Bakugan", 8.00),
                    new LightNovel("Dragon Ball", 2.99)
            ),
            List.of(
                    new LightNovel("Goku No Hero", 3.99),
                    new LightNovel("Pokemon", 7.55)
            ),
            List.of(
                    new LightNovel("Amazing Spider Man", 0.99),
                    new LightNovel("No Game No Life", 4.99)
            )
    ));

    public static void main(String[] args) {
        System.out.println("1) Titulos ordenados de todas as estantes:");
        System.out.println(buscarTitulosOrdenadosDasEstantes());

        System.out.println("2) Existe light novel mais cara que 8?");
        System.out.println(existeLightNovelMaisCaraQue(8));

        System.out.println("3) Primeira promocao em ordem alfabetica:");
        System.out.println(buscarPrimeiraPromocaoPorTitulo(4));
    }

    private static List<String> buscarTitulosOrdenadosDasEstantes() {
        return estantes.stream()
                .flatMap(Collection::stream)
                .map(ln -> ln.getTitle())
                .sorted()
                .collect(Collectors.toList());
        // TODO 01:
        // Abra a lista de estantes usando stream e flatMap.
        // Ordene as light novels pelo titulo.
        // Transforme cada LightNovel em titulo.
        // Colete em uma List<String>.
    }

    private static boolean existeLightNovelMaisCaraQue(double precoMinimo) {
        return estantes.stream()
                .flatMap(Collection::stream)
                .anyMatch(ln -> ln.getPrice() > precoMinimo);
        // TODO 02:
        // Abra todas as estantes com flatMap.
        // Use anyMatch para verificar se existe alguma light novel com preco maior que precoMinimo.
    }

    private static Optional<LightNovel> buscarPrimeiraPromocaoPorTitulo(double precoMaximo) {
        return estantes.stream()
                .flatMap(Collection::stream)
                .filter(ln -> ln.getPrice() <= precoMaximo)
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .findFirst();
        // TODO 03:
        // Abra todas as estantes com flatMap.
        // Filtre light novels com preco menor ou igual a precoMaximo.
        // Ordene pelo titulo.
        // Use findFirst para retornar a primeira promocao encontrada.
    }
}
