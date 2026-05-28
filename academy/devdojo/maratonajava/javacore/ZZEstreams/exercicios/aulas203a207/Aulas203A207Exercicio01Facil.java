package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas203a207;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.util.*;
import java.util.stream.Collectors;

public class Aulas203A207Exercicio01Facil {
    private static final LightNovel SHIPUDDEN_PROMO = new LightNovel("Shipudden", 0.99);

    private static final List<List<LightNovel>> prateleiras = new ArrayList<>(List.of(
            List.of(
                    new LightNovel("Naruto", 5.99),
                    new LightNovel("Bakugan", 8.00),
                    SHIPUDDEN_PROMO
            ),
            List.of(
                    new LightNovel("Dragon Ball", 2.99),
                    new LightNovel("Goku", 3.99),
                    SHIPUDDEN_PROMO
            ),
            List.of(
                    new LightNovel("Pokemon", 7.55),
                    new LightNovel("Amazing Spider Man", 0.99)
            )
    ));

    public static void main(String[] args) {
        System.out.println("1) Tres titulos baratos ordenados:");
        System.out.println(buscarTresTitulosBaratosOrdenados(4));

        System.out.println("2) Quantidade de light novels baratas sem repetir a mesma referencia:");
        System.out.println(contarLightNovelsBaratasSemRepetirReferencia(4));

        System.out.println("3) Catalogo completo ordenado por preco e titulo:");
        System.out.println(criarCatalogoOrdenadoPorPrecoETitulo());
    }

    private static List<String> buscarTresTitulosBaratosOrdenados(double precoMaximo) {

        return prateleiras.stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(p -> p.getTitle()))
                .filter(ln -> ln.getPrice() < precoMaximo)
                .limit(3)
                .map(LightNovel::getTitle)
                .collect(Collectors.toList());
    }

    private static long contarLightNovelsBaratasSemRepetirReferencia(double precoMaximo) {

        return prateleiras.stream()
                .flatMap(Collection::stream)
                .distinct()
                .filter(ln -> ln.getPrice() < precoMaximo)
                .count();
        // TODO 02:
        // Conte quantas light novels custam menos que precoMaximo.
        // Use flatMap para abrir as prateleiras.
        // Use distinct para nao contar duas vezes a mesma referencia SHIPUDDEN_PROMO.
    }

    private static List<LightNovel> criarCatalogoOrdenadoPorPrecoETitulo() {


        return prateleiras.stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(LightNovel::getPrice).thenComparing(LightNovel::getTitle))
                .collect(Collectors.toList());
    }
}
