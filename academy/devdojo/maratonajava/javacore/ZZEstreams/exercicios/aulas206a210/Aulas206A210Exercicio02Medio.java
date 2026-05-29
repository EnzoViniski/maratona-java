package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas206a210;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.util.*;
import java.util.stream.Collectors;

public class Aulas206A210Exercicio02Medio {
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

    private static final List<String> buscas = List.of(
            "Gomu Gomu No Mi",
            "Dragon Ball Z",
            "No Game No Life",
            "Amazing Spider Man",
            "Full Metal Alchemist"
    );

    public static void main(String[] args) {
        System.out.println("1) Palavras unicas das buscas:");
        System.out.println(extrairPalavrasUnicasDasBuscas(3));

        System.out.println("2) Total dos precos acima de 3:");
        System.out.println(calcularTotalDosPrecosAcimaDe(3));

        System.out.println("3) Maior light novel ate 6 reais:");
        System.out.println(buscarMaisCaraAte(6));

        System.out.println("4) Produto dos codigos de campanha:");
        System.out.println(multiplicarCodigosDeCampanha(List.of(2, 3, 4)));
    }

    private static List<String> extrairPalavrasUnicasDasBuscas(int tamanhoMinimo) {
        return buscas.stream()
                .map(b -> b.split(" "))
                .flatMap(Arrays::stream)
                .filter(b -> b.length() >= tamanhoMinimo)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // TODO 01:
        // Crie uma stream da lista buscas.
        // Use map para transformar cada frase em String[] com split(" ").
        // Use flatMap para transformar Stream<String[]> em Stream<String>.
        // Filtre palavras com tamanho maior ou igual a tamanhoMinimo.
        // Remova palavras repetidas, ordene e colete em List<String>.

    }

    private static double calcularTotalDosPrecosAcimaDe(double precoMinimo) {
        return lightNovels.stream()
                .mapToDouble(ln -> ln.getPrice())
                .filter(ln -> ln > precoMinimo)
                .sum();
        // TODO 02:
        // Transforme a stream de LightNovel em DoubleStream usando mapToDouble.
        // Filtre os precos maiores que precoMinimo.
        // Use sum para calcular o total.
    }

    private static Optional<LightNovel> buscarMaisCaraAte(double precoMaximo) {
        return lightNovels.stream()
                .filter(ln -> ln.getPrice() <= precoMaximo)
                .max(Comparator.comparing(LightNovel::getPrice));
        // TODO 03:
        // Filtre light novels com preco menor ou igual a precoMaximo.
        // Use max com Comparator.comparing para encontrar a mais cara.
        // Retorne Optional<LightNovel>.
    }

    private static int multiplicarCodigosDeCampanha(List<Integer> codigos) {
        return codigos.stream().reduce(1, (x,y) -> x * y);
        // TODO 04:
        // Use reduce para multiplicar todos os codigos.
        // Pense no valor inicial correto para multiplicacao.
    }
}
