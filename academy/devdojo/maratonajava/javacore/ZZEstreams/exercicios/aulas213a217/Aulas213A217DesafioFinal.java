package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas213a217;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.Promotion;

import java.util.*;
import java.util.stream.Collectors;

public class Aulas213A217DesafioFinal {
    private static final List<LightNovel> catalogo = new ArrayList<>(List.of(
            new LightNovel("Naruto", 5.99, Category.ACTION),
            new LightNovel("Bakugan", 8.00, Category.ACTION),
            new LightNovel("Dragon Ball", 2.99, Category.ACTION),
            new LightNovel("Full Metal", 6.49, Category.ACTION),
            new LightNovel("Goku", 3.99, Category.DRAMA),
            new LightNovel("Pokemon", 7.55, Category.DRAMA),
            new LightNovel("Erased", 4.50, Category.DRAMA),
            new LightNovel("Amazing Spider Man", 0.99, Category.FANTASY),
            new LightNovel("Shipudden", 0.99, Category.FANTASY),
            new LightNovel("No Game No Life", 4.99, Category.FANTASY),
            new LightNovel("Re Zero", 9.20, Category.FANTASY)
    ));

    public static void main(String[] args) {
        double limite = 5.00;

        System.out.println("1) Total geral via Collectors.counting:");
        System.out.println(contarComCollector());

        System.out.println("2) Titulos juntos por categoria:");
        System.out.println(juntarTitulosPorCategoria(", "));

        System.out.println("3) Soma de precos por categoria:");
        System.out.println(somarPrecosPorCategoria());

        System.out.println("4) Media de precos por categoria:");
        System.out.println(mediaPorCategoria());

        System.out.println("5) Categoria -> Promocao -> Lista (limite " + limite + "):");
        System.out.println(agruparPorCategoriaEPromocao(limite));

        System.out.println("6) Titulos unicos por promocao (limite " + limite + "):");
        System.out.println(titulosUnicosPorPromocao(limite));

        System.out.println("7) Mais cara por promocao (limite " + limite + "):");
        System.out.println(maisCaraPorPromocao(limite));

        System.out.println("8) Estatisticas por categoria e promocao (limite " + limite + "):");
        System.out.println(resumoEstatisticoPorCategoriaEPromocao(limite));

        System.out.println("9) Relatorio final:");
        System.out.println(criarRelatorioFinal(limite));
    }

    private static long contarComCollector() {
        return catalogo.stream().collect(Collectors.counting());
        // TODO 01:
        // Use Collectors.counting() para contar quantas light novels existem no catalogo.
    }

    private static Map<Category, String> juntarTitulosPorCategoria(String separador) {
        return catalogo.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(LightNovel::getTitle, Collectors.joining(separador))));
        // TODO 02:
        // Use groupingBy(LightNovel::getCategory,
        //               Collectors.mapping(LightNovel::getTitle, Collectors.joining(separador))).
        // Resultado esperado: Map<Category, String> com os titulos da categoria juntos.
    }

    private static Map<Category, Double> somarPrecosPorCategoria() {
        return catalogo.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.summingDouble(LightNovel::getPrice)));
        // TODO 03:
        // Use groupingBy(LightNovel::getCategory, Collectors.summingDouble(LightNovel::getPrice)).
    }

    private static Map<Category, Double> mediaPorCategoria() {
        return catalogo.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.averagingDouble(LightNovel::getPrice)));
        // TODO 04:
        // Use groupingBy(LightNovel::getCategory, Collectors.averagingDouble(LightNovel::getPrice)).
    }

    private static Map<Category, Map<Promotion, List<LightNovel>>> agruparPorCategoriaEPromocao(double limite) {
        return catalogo.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.groupingBy(ln -> classificarPromocao(ln, limite), Collectors.toList())));
        // TODO 05:
        // Use groupingBy aninhado:
        // - primeiro por LightNovel::getCategory;
        // - segundo por (ln) -> classificarPromocao(ln, limite).
    }

    private static Map<Promotion, Set<String>> titulosUnicosPorPromocao(double limite) {
        return catalogo.stream().collect(Collectors.groupingBy(ln -> classificarPromocao(ln, limite), Collectors.mapping(LightNovel::getTitle, Collectors.toSet())));
        // TODO 06:
        // Classifique no primeiro nivel por promocao usando classificarPromocao.
        // Downstream: Collectors.mapping(LightNovel::getTitle, Collectors.toSet()).
    }

    private static Map<Promotion, LightNovel> maisCaraPorPromocao(double limite) {
        return catalogo.stream().collect(Collectors.groupingBy(ln -> classificarPromocao(ln, limite) ,Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)),
                Optional::get)));
        // TODO 07:
        // Classifique no primeiro nivel por promocao usando classificarPromocao.
        // Downstream: Collectors.collectingAndThen(
        //                  Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)),
        //                  Optional::get).
    }

    private static Map<Category, Map<Promotion, DoubleSummaryStatistics>> resumoEstatisticoPorCategoriaEPromocao(double limite) {
        return catalogo.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.groupingBy(ln -> classificarPromocao(ln, limite), Collectors.summarizingDouble(LightNovel::getPrice))));
        // TODO 08:
        // Use groupingBy aninhado:
        // - primeiro por LightNovel::getCategory;
        // - segundo por (ln) -> classificarPromocao(ln, limite);
        // - downstream final: Collectors.summarizingDouble(LightNovel::getPrice).
    }

    private static String criarRelatorioFinal(double limite) {
        long total = contarComCollector();
        Map<Category, String> titulos = juntarTitulosPorCategoria(" | ");
        Map<Category, Double> somarPrecosPorCategoria = somarPrecosPorCategoria();
        Map<Category, Double> mediaPorCategoria = mediaPorCategoria();
        Map < Promotion, LightNovel> maisCaraPorPromocao = maisCaraPorPromocao(limite);
        return String.format("total: "+ total +"\ntitulos por categoria: "+ titulos + "\nsoma por categoria: "+somarPrecosPorCategoria+"\nmedia por categoria: "+mediaPorCategoria+"\nmais cara por promocao: "+maisCaraPorPromocao);
        // TODO 09:
        // Monte uma String com este formato (uma linha por valor):
        //
        // total: <contarComCollector()>
        // titulos por categoria: <juntarTitulosPorCategoria(" | ")>
        // soma por categoria: <somarPrecosPorCategoria()>
        // media por categoria: <mediaPorCategoria()>
        // mais cara por promocao: <maisCaraPorPromocao(limite)>
        //
        // Use String.format ou um StringBuilder, sem criar loops manuais.
        // Reutilize os metodos que voce ja implementou acima.
    }

    private static Promotion classificarPromocao(LightNovel ln, double limite) {
        return ln.getPrice() > limite ? Promotion.NORMAL_PRICE : Promotion.UNDER_PROMOTION;
        // TODO HELPER:
        // Retorne Promotion.UNDER_PROMOTION quando ln.getPrice() < limite.
        // Caso contrario, retorne Promotion.NORMAL_PRICE.
    }
}
