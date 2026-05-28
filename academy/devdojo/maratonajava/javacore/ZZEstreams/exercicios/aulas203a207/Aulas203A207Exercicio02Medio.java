package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas203a207;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Aulas203A207Exercicio02Medio {
    private static final List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 5.99),
            new LightNovel("Bakugan", 8.00),
            new LightNovel("Dragon Ball", 2.99),
            new LightNovel("Goku No Hero", 3.99),
            new LightNovel("Pokemon", 7.55),
            new LightNovel("Amazing Spider Man", 0.99),
            new LightNovel("No Game No Life", 4.99)
    ));

    private static final List<String> frasesDeBusca = List.of(
            "Gomu Gomu No Mi",
            "Dragon Ball Z",
            "No Game No Life",
            "Amazing Spider Man"
    );

    public static void main(String[] args) {
        System.out.println("1) Palavras unicas das frases:");
        System.out.println(extrairPalavrasUnicasOrdenadas(frasesDeBusca));

        System.out.println("2) Palavras dos titulos baratos:");
        System.out.println(buscarPalavrasDeTitulosBaratos(5, 6));

        System.out.println("3) Quantidade de palavras unicas em titulos baratos:");
        System.out.println(contarPalavrasUnicasDeTitulosBaratos(5));
    }

    private static List<String> extrairPalavrasUnicasOrdenadas(List<String> frases) {
        return frases.stream()
                .map(f -> f.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        // TODO 01:
        // 1. Crie uma stream de frases.
        // 2. Use map para transformar cada frase em String[] com split(" ").
        // 3. Use flatMap(Arrays::stream) para transformar Stream<String[]> em Stream<String>.
        // 4. Remova palavras repetidas.
        // 5. Ordene em ordem alfabetica.
        // 6. Colete em List<String>.
    }

    private static List<String> buscarPalavrasDeTitulosBaratos(double precoMaximo, int limite) {
        return lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getPrice).thenComparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() <= precoMaximo)
                .map(ln -> ln.getTitle())
                .map(ln -> ln.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .limit(limite)
                .collect(Collectors.toList());
        // TODO 02:
        // 1. Ordene as light novels por preco e depois por titulo.
        // 2. Filtre apenas as que custam menos ou igual a precoMaximo.
        // 3. Pegue apenas os titulos.
        // 4. Quebre cada titulo em palavras com split(" ").
        // 5. Use flatMap(Arrays::stream).
        // 6. Remova palavras repetidas.
        // 7. Limite a quantidade de palavras usando o parametro limite.
    }

    private static long contarPalavrasUnicasDeTitulosBaratos(double precoMaximo) {

        return lightNovels.stream()
                .filter(ln -> ln.getPrice() < precoMaximo)
                .map(LightNovel::getTitle)
                .map(ln -> ln.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .count();

        // TODO 03:
        // Conte as palavras unicas dos titulos de light novels com preco menor que precoMaximo.
        // Este metodo deve praticar map(...split...), flatMap(Arrays::stream), distinct e count.
    }
}
