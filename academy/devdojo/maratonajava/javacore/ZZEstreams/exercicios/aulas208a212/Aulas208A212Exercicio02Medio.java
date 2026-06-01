package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas208a212;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aulas208A212Exercicio02Medio {
    private static final Path ARQUIVO_BASE = Paths.get("file.txt");

    private static final List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 5.99),
            new LightNovel("Bakugan", 8.00),
            new LightNovel("Dragon Ball", 2.99),
            new LightNovel("Goku No Hero", 3.99),
            new LightNovel("Pokemon", 7.55),
            new LightNovel("Amazing Spider Man", 0.99),
            new LightNovel("No Game No Life", 4.99),
            new LightNovel("Full Metal Panic", 6.49)
    ));

    private static final int[] paginasLidas = {12, 20, 7, 31, 18, 5, 40};

    public static void main(String[] args) throws IOException {
        System.out.println("1) Linhas do arquivo que contem Java:");
        System.out.println(buscarLinhasQueContem(ARQUIVO_BASE, "Java"));

        System.out.println("2) Quantidade de palavras distintas do arquivo:");
        System.out.println(contarPalavrasDistintasDoArquivo(ARQUIVO_BASE, 4));

        System.out.println("3) Sequencia impar gerada com iterate:");
        System.out.println(gerarSequenciaImpar(1, 10));

        System.out.println("4) Soma das paginas acima do minimo:");
        System.out.println(somarPaginasAcimaDe(15));

        System.out.println("5) Total de precos acima do minimo:");
        System.out.println(calcularTotalDasLightNovelsAcimaDe(3));

        System.out.println("6) Primeira light novel encontrada pelo trecho:");
        System.out.println(buscarPrimeiraLightNovelPorTrecho("No"));
    }

    private static List<String> buscarLinhasQueContem(Path arquivo, String trecho) throws IOException {

        // TODO 01:
        // Use Files.lines dentro de try-with-resources.
        // Filtre linhas que contem o trecho recebido.
        // Ordene as linhas e colete em List<String>.
        return List.of();
    }

    private static long contarPalavrasDistintasDoArquivo(Path arquivo, int tamanhoMinimo) throws IOException {
        // TODO 02:
        // Use Files.lines dentro de try-with-resources.
        // Quebre cada linha em palavras com split(" ").
        // Use flatMap para trabalhar com uma Stream<String>.
        // Filtre palavras com tamanho maior ou igual a tamanhoMinimo.
        // Remova repetidas com distinct e conte com count.
        return 0;
    }

    private static List<Integer> gerarSequenciaImpar(int primeiroNumero, int quantidade) {
        // TODO 03:
        // Use Stream.iterate iniciando em primeiroNumero.
        // Some 2 a cada novo numero.
        // Limite pela quantidade recebida e colete em List<Integer>.
        return List.of();
    }

    private static int somarPaginasAcimaDe(int paginaMinima) {
        // TODO 04:
        // Use Arrays.stream no array paginasLidas.
        // Filtre apenas valores maiores que paginaMinima.
        // Some usando reduce com Integer::sum.
        return 0;
    }

    private static double calcularTotalDasLightNovelsAcimaDe(double precoMinimo) {
        // TODO 05:
        // Use mapToDouble para transformar LightNovel em preco.
        // Filtre precos maiores que precoMinimo.
        // Use sum para calcular o total.
        return 0;
    }

    private static Optional<LightNovel> buscarPrimeiraLightNovelPorTrecho(String trecho) {
        // TODO 06:
        // Filtre light novels cujo titulo contem o trecho recebido.
        // Ordene por titulo.
        // Use findFirst.
        return Optional.empty();
    }
}
