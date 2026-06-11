package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas213a217;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.Promotion;

import java.util.*;
import java.util.stream.Collectors;

public class Aulas213A217Exercicio01Facil {
    private static final List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 5.99, Category.ACTION),
            new LightNovel("Bakugan", 8.00, Category.ACTION),
            new LightNovel("Dragon Ball", 2.99, Category.ACTION),
            new LightNovel("Goku", 3.99, Category.DRAMA),
            new LightNovel("Pokemon", 7.55, Category.DRAMA),
            new LightNovel("Amazing Spider Man", 0.99, Category.FANTASY),
            new LightNovel("Shipudden", 0.99, Category.FANTASY)
    ));

    public static void main(String[] args) {
        System.out.println("1) Total de light novels com Collectors.counting:");
        System.out.println(contarTodasComCollector());

        System.out.println("2) Soma dos precos com Collectors.summingDouble:");
        System.out.println(calcularSomaDePrecos());

        System.out.println("3) Titulos juntos com separador:");
        System.out.println(juntarTitulosComSeparador(" | "));

        System.out.println("4) Light novel mais cara com Collectors.maxBy:");
        System.out.println(buscarLightNovelMaisCaraComCollector());

        System.out.println("5) Estatisticas de preco com summarizingDouble:");
        System.out.println(resumirEstatisticasDePreco());

        System.out.println("6) Light novels agrupadas por categoria:");
        System.out.println(agruparPorCategoria());

        System.out.println("7) Light novels agrupadas por promocao (limite 5.0):");
        System.out.println(agruparPorPromocao(5.0));
    }

    private static long contarTodasComCollector() {
        return lightNovels.stream()
                .collect(Collectors.counting());
        // TODO 01:
        // Use lightNovels.stream() e Collectors.counting() para contar a quantidade total.
        // Observacao: stream().count() ja existe; aqui o objetivo e treinar a versao Collector,
        // que devolve Long e e a base para usar como downstream nos exercicios seguintes.
    }

    private static double calcularSomaDePrecos() {
        return lightNovels.stream()
                .collect(Collectors.summingDouble(LightNovel::getPrice));
        // TODO 02:
        // Use Collectors.summingDouble com LightNovel::getPrice para somar todos os precos.
        // Diferente de mapToDouble(...).sum(), aqui voce esta praticando a versao Collector.
    }

    private static String juntarTitulosComSeparador(String separador) {
        return lightNovels.stream()
                .map(LightNovel::getTitle)
                .collect(Collectors.joining(separador));
        // TODO 03:
        // Use map para extrair os titulos das light novels.
        // Junte usando Collectors.joining com o separador recebido.
    }

    private static Optional<LightNovel> buscarLightNovelMaisCaraComCollector() {
        return lightNovels.stream()
                .collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)));
        // TODO 04:
        // Use Collectors.maxBy com Comparator.comparing(LightNovel::getPrice).
        // Diferente de stream.max(...), este coletor e usado dentro de collect(...)
        // e tambem entrega um Optional<LightNovel>.
    }

    private static DoubleSummaryStatistics resumirEstatisticasDePreco() {
        return lightNovels.stream()
                .collect(Collectors.summarizingDouble(LightNovel::getPrice));
        // TODO 05:
        // Use Collectors.summarizingDouble com LightNovel::getPrice.
        // Esse coletor entrega count, sum, min, max e average de uma vez so.
    }

    private static Map<Category, List<LightNovel>> agruparPorCategoria() {
        return lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.toList()));
        // TODO 06:
        // Use Collectors.groupingBy(LightNovel::getCategory) para gerar um mapa
        // com a categoria como chave e a lista de light novels como valor.
    }

    private static Map<Promotion, List<LightNovel>> agruparPorPromocao(double limite) {
        return lightNovels.stream()
                .collect(Collectors.groupingBy(ln -> ln.getPrice() > limite ? Promotion.NORMAL_PRICE : Promotion.UNDER_PROMOTION, Collectors.toList()));
        // TODO 07:
        // Use Collectors.groupingBy passando uma funcao (LightNovel ln) -> Promotion
        // que devolve UNDER_PROMOTION quando ln.getPrice() < limite e NORMAL_PRICE caso contrario.
        // Aqui voce esta praticando o "classificador derivado" da aula 215.
    }
}
