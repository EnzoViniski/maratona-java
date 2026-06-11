package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas213a217;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.Promotion;
import academy.devdojo.maratonajava.javacore.ZZEstreams.test.Aula217_StreamTest15;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Aulas213A217Exercicio02Medio {
    private static final List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 5.99, Category.ACTION),
            new LightNovel("Bakugan", 8.00, Category.ACTION),
            new LightNovel("Dragon Ball", 2.99, Category.ACTION),
            new LightNovel("Full Metal", 6.49, Category.ACTION),
            new LightNovel("Goku", 3.99, Category.DRAMA),
            new LightNovel("Pokemon", 7.55, Category.DRAMA),
            new LightNovel("Amazing Spider Man", 0.99, Category.FANTASY),
            new LightNovel("Shipudden", 0.99, Category.FANTASY),
            new LightNovel("No Game No Life", 4.99, Category.FANTASY)
    ));

    public static void main(String[] args) {
        System.out.println("1) Categoria -> Promocao -> Lista (limite 6.0):");
        System.out.println(agruparPorCategoriaEPromocao(6.0));

        System.out.println("2) Quantidade de light novels por categoria:");
        System.out.println(contarPorCategoria());

        System.out.println("3) Mais cara de cada categoria via collectingAndThen:");
        System.out.println(buscarMaisCaraPorCategoria());

        System.out.println("4) Mais cara de cada categoria via toMap:");
        System.out.println(buscarMaisCaraPorCategoriaComToMap());

        System.out.println("5) Estatisticas de preco por categoria:");
        System.out.println(resumirPrecosPorCategoria());

        System.out.println("6) Promocoes unicas por categoria (limite 5.0):");
        System.out.println(coletarPromocoesUnicasPorCategoria(5.0));

        System.out.println("7) Promocoes na ordem de leitura por categoria (limite 5.0):");
        System.out.println(coletarPromocoesOrdenadasPorCategoria(5.0));
    }

    private static Map<Category, Map<Promotion, List<LightNovel>>> agruparPorCategoriaEPromocao(double limite) {

        return lightNovels.stream().collect(groupingBy(LightNovel::getCategory, groupingBy(ln -> classificarPromocao(ln, limite),Collectors.toList())));
        // TODO 01:
        // Use groupingBy aninhado.
        // Primeiro nivel: LightNovel::getCategory.
        // Segundo nivel: groupingBy com classificador que devolve UNDER_PROMOTION
        // quando o preco for menor que limite.
        // Dica: voce pode reutilizar o helper classificarPromocao definido neste arquivo,
        // passando (ln, limite) via lambda.
    }

    private static Map<Category, Long> contarPorCategoria() {
        return lightNovels.stream().collect(groupingBy(LightNovel::getCategory, Collectors.counting()));
        // TODO 02:
        // Use groupingBy(LightNovel::getCategory, Collectors.counting()).
        // O downstream Collectors.counting() conta quantos itens caem em cada categoria.
    }

    private static Map<Category, LightNovel> buscarMaisCaraPorCategoria() {
        return lightNovels.stream().collect(groupingBy(LightNovel::getCategory,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)), Optional::get)));


        // TODO 03:
        // Use groupingBy(LightNovel::getCategory, ...) com downstream Collectors.collectingAndThen.
        // O downstream interno e Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)).
        // O finalizador transforma Optional<LightNovel> em LightNovel com Optional::get.
    }

    private static Map<Category, LightNovel> buscarMaisCaraPorCategoriaComToMap() {
        return lightNovels.stream().collect(toMap(LightNovel::getCategory, Function.identity() , BinaryOperator.maxBy(Comparator.comparing(LightNovel::getPrice))));
        // TODO 04:
        // Use Collectors.toMap com:
        // - keyMapper    = LightNovel::getCategory
        // - valueMapper  = Function.identity()
        // - mergeFunction = BinaryOperator.maxBy(Comparator.comparing(LightNovel::getPrice))
        // Compare mentalmente o resultado deste metodo com o do TODO 03.
    }

    private static Map<Category, DoubleSummaryStatistics> resumirPrecosPorCategoria() {
        return lightNovels.stream().collect(groupingBy(LightNovel::getCategory, summarizingDouble(LightNovel::getPrice)));
        // TODO 05:
        // Use groupingBy(LightNovel::getCategory, Collectors.summarizingDouble(LightNovel::getPrice)).
        // O resultado entrega count, sum, min, max e average por categoria.
    }

    private static Map<Category, Set<Promotion>> coletarPromocoesUnicasPorCategoria(double limite) {
        return lightNovels.stream().collect(groupingBy(LightNovel::getCategory, mapping(ln -> classificarPromocao(ln, limite), toSet())));

        // TODO 06:
        // Use groupingBy(LightNovel::getCategory, Collectors.mapping(<funcao>, Collectors.toSet())).
        // A <funcao> deve transformar LightNovel em Promotion conforme o limite.
        // Use uma lambda: ln -> classificarPromocao(ln, limite).
    }

    private static Map<Category, LinkedHashSet<Promotion>> coletarPromocoesOrdenadasPorCategoria(double limite) {
        return lightNovels.stream().collect(groupingBy(LightNovel::getCategory, Collectors.mapping(ln -> classificarPromocao(ln, limite), toCollection(LinkedHashSet::new))));
        // TODO 07:
        // Use groupingBy(LightNovel::getCategory, Collectors.mapping(<funcao>, Collectors.toCollection(LinkedHashSet::new))).
        // O LinkedHashSet preserva a ordem em que cada promocao apareceu na lista original.
    }

    private static Promotion classificarPromocao(LightNovel ln, double limite) {
        return ln.getPrice() < limite ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}
