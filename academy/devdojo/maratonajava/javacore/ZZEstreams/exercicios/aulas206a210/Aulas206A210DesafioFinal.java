package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas206a210;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.util.*;
import java.util.stream.Collectors;

public class Aulas206A210DesafioFinal {
    private static final List<List<ItemVenda>> lotes = new ArrayList<>(List.of(
            List.of(
                    new ItemVenda("Maria", new LightNovel("Naruto", 5.99), 2, List.of("ninja", "acao")),
                    new ItemVenda("Duda", new LightNovel("Dragon Ball", 2.99), 1, List.of("luta", "classico"))
            ),
            List.of(
                    new ItemVenda("Enzo", new LightNovel("Goku No Hero", 3.99), 3, List.of("heroi", "luta")),
                    new ItemVenda("Ana", new LightNovel("No Game No Life", 4.99), 2, List.of("jogo", "aventura"))
            ),
            List.of(
                    new ItemVenda("Pedro", new LightNovel("Amazing Spider Man", 0.99), 5, List.of("heroi", "promocao")),
                    new ItemVenda("Julia", new LightNovel("Full Metal Panic", 6.49), 1, List.of("mecha", "acao"))
            )
    ));

    public static void main(String[] args) {
        System.out.println("1) Palavras dos titulos por tag e preco:");
        System.out.println(buscarPalavrasDosTitulosPorTagEPreco("heroi", 5));

        System.out.println("2) Todos os itens possuem preco positivo?");
        System.out.println(todosOsItensPossuemPrecoPositivo());

        System.out.println("3) Existe venda com quantidade maior que 4?");
        System.out.println(existeVendaComQuantidadeMaiorQue(4));

        System.out.println("4) Maior venda da tag heroi:");
        System.out.println(buscarMaiorVendaPorTag("heroi"));

        System.out.println("5) Faturamento da tag heroi:");
        System.out.println(calcularFaturamentoPorTag("heroi"));

        System.out.println("6) Quantidade vendida da tag heroi:");
        System.out.println(calcularQuantidadeVendidaPorTag("heroi"));

        System.out.println("7) Resumo final:");
        System.out.println(criarResumoPorTag("heroi", 5));
    }

    private static List<String> buscarPalavrasDosTitulosPorTagEPreco(String tag, double precoMaximo) {
        return lotes.stream()
                .flatMap(Collection::stream)
                .filter(i -> i.getTags().contains(tag))
                .filter(i -> i.getLightNovel().getPrice() <= precoMaximo)
                .map(ln -> ln.getLightNovel().getTitle().split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        // TODO 01:
        // Abra todos os lotes usando flatMap.
        // Filtre ItemVenda que contem a tag recebida.
        // Filtre tambem pelo preco da LightNovel menor ou igual a precoMaximo.
        // Pegue os titulos, quebre com split(" ") e use flatMap para virar palavras.
        // Remova palavras repetidas, ordene e colete em List<String>.
    }

    private static boolean todosOsItensPossuemPrecoPositivo() {
        return lotes.stream()
                .flatMap(Collection::stream)
                .allMatch(i -> i.getLightNovel().getPrice() > 0);
        // TODO 02:
        // Abra todos os lotes com flatMap.
        // Use allMatch para conferir se todos os precos sao maiores que zero.
    }

    private static boolean existeVendaComQuantidadeMaiorQue(int quantidadeMinima) {
        return lotes.stream()
                .flatMap(Collection::stream)
                .anyMatch(i -> i.getQuantidade() > quantidadeMinima);
        // TODO 03:
        // Abra todos os lotes com flatMap.
        // Use anyMatch para verificar se existe venda com quantidade maior que quantidadeMinima.
    }

    private static Optional<ItemVenda> buscarMaiorVendaPorTag(String tag) {
        return lotes.stream()
                .flatMap(Collection::stream)
                .filter(i -> i.getTags().contains(tag))
                .max(Comparator.comparing(ItemVenda::getSubtotal));
        // TODO 04:
        // Abra todos os lotes com flatMap.
        // Filtre vendas que contem a tag recebida.
        // Use max com Comparator.comparing para buscar a venda de maior subtotal.
    }

    private static double calcularFaturamentoPorTag(String tag) {
        return lotes.stream()
                .flatMap(Collection::stream)
                .filter(i -> i.getTags().contains(tag))
                .mapToDouble(i -> i.getSubtotal())
                .sum();
        // TODO 05:
        // Abra todos os lotes com flatMap.
        // Filtre vendas que contem a tag recebida.
        // Use mapToDouble com getSubtotal.
        // Some tudo com sum.
    }

    private static int calcularQuantidadeVendidaPorTag(String tag) {
        return lotes.stream()
                .flatMap(Collection::stream)
                .filter(i -> i.getTags().contains(tag))
                .mapToInt(i -> i.getQuantidade())
                .reduce(0, Integer::sum);

        // TODO 06:
        // Abra todos os lotes com flatMap.
        // Filtre vendas que contem a tag recebida.
        // Transforme cada venda em quantidade.
        // Use reduce para somar as quantidades.
    }

    private static String criarResumoPorTag(String tag, double precoMaximo) {
        List<String> palavrasList = buscarPalavrasDosTitulosPorTagEPreco(tag, precoMaximo);
        String palavras = String.join(", ",palavrasList);
        double faturamento = calcularFaturamentoPorTag(tag);
        int quantidade = calcularQuantidadeVendidaPorTag(tag);
        // TODO 07:
        // Monte uma String no formato:
        // Tag: <tag> | palavras: <palavra1, palavra2> | faturamento: <total> | quantidade: <total>
        //
        // Regras:
        // - As palavras devem vir de buscarPalavrasDosTitulosPorTagEPreco.
        // - O faturamento deve vir de calcularFaturamentoPorTag.
        // - A quantidade deve vir de calcularQuantidadeVendidaPorTag.
        // - Use String.join para juntar as palavras.
        return "Tag: "+tag+" | palavras: "+palavras+" | faturamento: " +faturamento+" | quantidade: "+quantidade;
    }

    private static class ItemVenda {
        private final String comprador;
        private final LightNovel lightNovel;
        private final int quantidade;
        private final List<String> tags;

        private ItemVenda(String comprador, LightNovel lightNovel, int quantidade, List<String> tags) {
            this.comprador = comprador;
            this.lightNovel = lightNovel;
            this.quantidade = quantidade;
            this.tags = tags;
        }

        public String getComprador() {
            return comprador;
        }

        public LightNovel getLightNovel() {
            return lightNovel;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public List<String> getTags() {
            return tags;
        }

        public double getSubtotal() {
            return lightNovel.getPrice() * quantidade;
        }

        @Override
        public String toString() {
            return "ItemVenda{" +
                    "comprador='" + comprador + '\'' +
                    ", lightNovel=" + lightNovel +
                    ", quantidade=" + quantidade +
                    ", tags=" + tags +
                    ", subtotal=" + getSubtotal() +
                    '}';
        }
    }
}
