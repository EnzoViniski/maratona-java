package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas208a212;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Aulas208A212Exercicio01Facil {
    private static final List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 5.99),
            new LightNovel("Bakugan", 8.00),
            new LightNovel("Dragon Ball", 2.99),
            new LightNovel("Goku", 3.99),
            new LightNovel("Pokemon", 7.55),
            new LightNovel("Amazing Spider Man", 0.99),
            new LightNovel("Shipudden", 0.99)
    ));

    private static final String[] palavrasDoSlogan = {"eleve", "o", "cosmo", "com", "streams"};
    private static final int[] notasDeEstoque = {7, 9, 5, 10, 6, 8};

    public static void main(String[] args) {
        System.out.println("1) Pares no intervalo fechado:");
        System.out.println(buscarParesNoIntervaloFechado(1, 20));

        System.out.println("2) Slogan em maiusculo:");
        System.out.println(montarSloganEmMaiusculo());

        System.out.println("3) Media das notas de estoque:");
        System.out.println(calcularMediaDasNotasDeEstoque());

        System.out.println("4) Primeira light novel cara ordenada por preco:");
        System.out.println(buscarPrimeiraLightNovelCara(5));

        System.out.println("5) Todos os precos sao positivos?");
        System.out.println(todosOsPrecosSaoPositivos());
    }

    private static List<Integer> buscarParesNoIntervaloFechado(int inicio, int fim) {
        return IntStream.rangeClosed(inicio, fim)
                .filter(n -> n % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
        // TODO 01:
        // Use IntStream.rangeClosed para gerar os numeros de inicio ate fim.
        // Filtre apenas os numeros pares.
        // Converta para Stream<Integer> e colete em List<Integer>.
    }

    private static String montarSloganEmMaiusculo() {
        return Stream.of(palavrasDoSlogan)
                .map(String::toUpperCase)
                .collect(Collectors.joining());
        // TODO 02:
        // Use Stream.of com o array palavrasDoSlogan.
        // Transforme cada palavra para maiusculo.
        // Junte as palavras em uma unica String usando reduce.
        // Dica: o retorno provisorio deve ser trocado pelo resultado do reduce.
    }

    private static OptionalDouble calcularMediaDasNotasDeEstoque() {

        return IntStream.of(notasDeEstoque)
                .average();
        // TODO 03:
        // Use Arrays.stream no array notasDeEstoque.
        // Calcule a media com average.
        // Retorne OptionalDouble, sem usar null.
    }

    private static Optional<LightNovel> buscarPrimeiraLightNovelCara(double precoMinimo) {
        return lightNovels.stream()
                .filter(ln -> ln.getPrice() > precoMinimo)
                .sorted(Comparator.comparing(LightNovel::getPrice).reversed())
                .findFirst();
        // TODO 04:
        // Crie uma stream de lightNovels.
        // Filtre light novels com preco maior que precoMinimo.
        // Ordene por preco do maior para o menor.
        // Use findFirst para retornar a primeira.
    }

    private static boolean todosOsPrecosSaoPositivos() {
        return lightNovels.stream().allMatch(ln -> ln.getPrice() > 0);
        // TODO 05:
        // Use allMatch para verificar se todos os precos das light novels sao maiores que zero.
    }
}
