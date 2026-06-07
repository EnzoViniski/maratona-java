package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas208a212;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Aulas208A212DesafioFinal {
    private static final Path ARQUIVO_BASE = Paths.get("file.txt");

    private static final List<List<ItemLeitura>> lotes = new ArrayList<>(List.of(
            List.of(
                    new ItemLeitura("Maria", new LightNovel("Naruto", 5.99), 2, List.of("ninja", "acao")),
                    new ItemLeitura("Duda", new LightNovel("Dragon Ball", 2.99), 1, List.of("luta", "classico"))
            ),
            List.of(
                    new ItemLeitura("Enzo", new LightNovel("Goku No Hero", 3.99), 3, List.of("heroi", "luta")),
                    new ItemLeitura("Ana", new LightNovel("No Game No Life", 4.99), 2, List.of("jogo", "aventura"))
            ),
            List.of(
                    new ItemLeitura("Pedro", new LightNovel("Amazing Spider Man", 0.99), 5, List.of("heroi", "promocao")),
                    new ItemLeitura("Julia", new LightNovel("Full Metal Panic", 6.49), 1, List.of("mecha", "acao"))
            )
    ));

    private static final int[] avaliacoesDaSemana = {8, 10, 6, 9, 7, 5, 10};

    public static void main(String[] args) throws IOException {
        System.out.println("1) Dias da campanha:");
        System.out.println(gerarDiasDaCampanha(1, 7));

        System.out.println("2) Fibonacci para metas de leitura:");
        System.out.println(gerarMetasFibonacci(8));

        System.out.println("3) Codigos aleatorios de simulado:");
        System.out.println(gerarCodigosDeSimulado(5, 1000, 9999));

        System.out.println("4) Todos os itens possuem quantidade positiva?");
        System.out.println(todosOsItensPossuemQuantidadePositiva());

        System.out.println("5) Maior item pela tag heroi:");
        System.out.println(buscarMaiorItemPorTag("heroi"));

        System.out.println("6) Faturamento pela tag heroi:");
        System.out.println(calcularFaturamentoPorTag("heroi"));

        System.out.println("7) Soma das avaliacoes acima do minimo:");
        System.out.println(somarAvaliacoesAcimaDe(7));

        System.out.println("8) Linhas do arquivo com Java:");
        System.out.println(contarLinhasDoArquivoCom(ARQUIVO_BASE, "Java"));

        System.out.println("9) Resumo final:");
        System.out.println(criarResumoFinal("heroi", 1, 7, 8, ARQUIVO_BASE, "Java"));
    }

    private static List<Integer> gerarDiasDaCampanha(int diaInicial, int diaFinal) {
        return IntStream.rangeClosed(diaInicial, diaFinal)
                .boxed().toList();
        // TODO 01:
        // Use IntStream.rangeClosed para gerar os dias da campanha.
        // Colete os dias em List<Integer>.
    }

    private static List<Integer> gerarMetasFibonacci(int quantidade) {
        return Stream.iterate(new int[] {0,1}, n -> new int[] {n[1], n[0] + n[1]})
                .limit(quantidade)
                .map(n -> n[0])
                .collect(Collectors.toList());
        // TODO 02:
        // Use Stream.iterate com int[] para gerar pares da sequencia de Fibonacci.
        // Limite pela quantidade recebida.
        // Transforme cada par no primeiro numero do par.
        // Colete em List<Integer>.
    }

    private static List<Integer> gerarCodigosDeSimulado(int quantidade, int menorCodigo, int maiorCodigo) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return Stream.generate(() -> random.nextInt(menorCodigo, maiorCodigo))
                .limit(quantidade)
                .collect(Collectors.toList());

        // TODO 03:
        // Use ThreadLocalRandom.current().
        // Use Stream.generate para criar codigos entre menorCodigo e maiorCodigo.
        // Limite pela quantidade recebida e colete em List<Integer>.
    }

    private static boolean todosOsItensPossuemQuantidadePositiva() {
        return lotes.stream()
                .flatMap(Collection::stream)
                .allMatch(n -> n.getQuantidade() > 0);
        // TODO 04:
        // Abra todos os lotes com flatMap.
        // Use allMatch para validar se toda quantidade e maior que zero.
    }

    private static Optional<ItemLeitura> buscarMaiorItemPorTag(String tag) {
        return lotes.stream()
                .flatMap(Collection::stream)
                .filter(l -> l.getTags().contains(tag))
                .max(Comparator.comparing(l -> l.getSubtotal()));
        // TODO 05:
        // Abra todos os lotes com flatMap.
        // Filtre itens que contem a tag recebida.
        // Use max com Comparator.comparing para buscar o maior subtotal.
    }

    private static double calcularFaturamentoPorTag(String tag) {
        return lotes.stream()
                .flatMap(Collection::stream)
                .filter(l -> l.getTags().contains(tag))
                .mapToDouble(l -> l.getSubtotal())
                .sum();
        // TODO 06:
        // Abra todos os lotes com flatMap.
        // Filtre itens que contem a tag recebida.
        // Transforme cada item em subtotal com mapToDouble.
        // Some com sum.
    }

    private static int somarAvaliacoesAcimaDe(int notaMinima) {
        return Arrays.stream(avaliacoesDaSemana)
                .filter(n -> n > notaMinima)
                .reduce(Integer::sum)
                .getAsInt();
        // TODO 07:
        // Use Arrays.stream no array avaliacoesDaSemana.
        // Filtre notas maiores que notaMinima.
        // Some usando reduce.
    }

    private static long contarLinhasDoArquivoCom(Path arquivo, String trecho) throws IOException {
        try (Stream<String> lines = Files.lines(arquivo)) {
            return lines.filter(l -> l.contains(trecho))
                    .count();
        }catch (IOException e){
            e.printStackTrace();
        }
        // TODO 08:
        // Use Files.lines dentro de try-with-resources.
        // Conte as linhas que contem o trecho recebido.
        return 0;
    }

    private static String criarResumoFinal(String tag, int diaInicial, int diaFinal, int quantidadeMetas,
                                           Path arquivo, String trecho) throws IOException {
        List<Integer> dias = gerarDiasDaCampanha(diaInicial, diaFinal);
        List<Integer> metas = gerarMetasFibonacci(quantidadeMetas);
        double faturamento = calcularFaturamentoPorTag(tag);
        long total =  contarLinhasDoArquivoCom(arquivo, trecho);
        // TODO 09:
        // Monte uma String no formato:
        // Tag: <tag> | dias: <dias> | metas: <metas> | faturamento: <total> | linhas: <total>
        //
        // Regras:
        // - Os dias devem vir de gerarDiasDaCampanha.
        // - As metas devem vir de gerarMetasFibonacci.
        // - O faturamento deve vir de calcularFaturamentoPorTag.
        // - As linhas devem vir de contarLinhasDoArquivoCom.
        // - Use String.valueOf ou o toString das listas, sem criar loops manuais.
        return "Tag: "+tag+" | dias: "+dias+" | metas: "+metas+" | faturamento: "+faturamento+" | linhas: "+total+"";
    }

    private static class ItemLeitura {
        private final String comprador;
        private final LightNovel lightNovel;
        private final int quantidade;
        private final List<String> tags;

        private ItemLeitura(String comprador, LightNovel lightNovel, int quantidade, List<String> tags) {
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
            return "ItemLeitura{" +
                    "comprador='" + comprador + '\'' +
                    ", lightNovel=" + lightNovel +
                    ", quantidade=" + quantidade +
                    ", tags=" + tags +
                    ", subtotal=" + getSubtotal() +
                    '}';
        }
    }
}
