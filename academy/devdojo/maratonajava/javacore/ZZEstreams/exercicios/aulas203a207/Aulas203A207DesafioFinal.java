package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios.aulas203a207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Aulas203A207DesafioFinal {
    private static final List<ItemCampanha> catalogo = new ArrayList<>(List.of(
            new ItemCampanha("Naruto", "Manga", 20.0, List.of("ninja", "acao", "classico")),
            new ItemCampanha("Boku No Hero", "Manga", 10.0, List.of("heroi", "acao", "escola")),
            new ItemCampanha("Dragon Ball", "Light Novel", 2.99, List.of("acao", "classico", "luta")),
            new ItemCampanha("Goku No Hero", "Light Novel", 3.99, List.of("heroi", "luta", "promocao")),
            new ItemCampanha("Pokemon", "Light Novel", 7.55, List.of("aventura", "classico")),
            new ItemCampanha("Amazing Spider Man", "HQ", 0.99, List.of("heroi", "promocao")),
            new ItemCampanha("No Game No Life", "Light Novel", 4.99, List.of("jogo", "aventura", "promocao"))
    ));

    public static void main(String[] args) {
        System.out.println("1) Titulos baratos para campanha:");
        System.out.println(buscarTitulosBaratosParaCampanha(5, 4));

        System.out.println("2) Tags de light novels baratas:");
        System.out.println(buscarTagsDeItensBaratos("Light Novel", 5, 5));

        System.out.println("3) Palavras unicas dos titulos da campanha:");
        System.out.println(buscarPalavrasDosTitulosDaCampanha(5));

        System.out.println("4) Resumo da campanha:");
        System.out.println(criarResumoDaCampanha("Light Novel", 5));
    }

    private static List<String> buscarTitulosBaratosParaCampanha(double precoMaximo, int limite) {
        return catalogo.stream()
                .filter(i -> i.getPreco() <= precoMaximo)
                .sorted(Comparator.comparing(ItemCampanha::getPreco).thenComparing(ItemCampanha::getTitulo))
                .limit(limite)
                .map(i -> i.getTitulo())
                .collect(Collectors.toList());

        // TODO 01:
        // Retorne os titulos dos itens com preco menor ou igual a precoMaximo.
        // Ordene por preco e depois por titulo.
        // Limite usando o parametro limite.
    }

    private static List<String> buscarTagsDeItensBaratos(String categoria, double precoMaximo, int limite) {
        return catalogo.stream()
                .filter(i -> i.getCategoria().equals(categoria))
                .filter(i -> i.getPreco() <= precoMaximo)
                .map(i -> i.getTags())
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .limit(limite)
                .collect(Collectors.toList());

        // TODO 02:
        // 1. Filtre os itens pela categoria recebida.
        // 2. Filtre por preco menor ou igual a precoMaximo.
        // 3. Transforme cada ItemCampanha em sua lista de tags.
        // 4. Use flatMap(Collection::stream) para abrir as listas de tags.
        // 5. Remova tags repetidas.
        // 6. Ordene e limite.
    }

    private static List<String> buscarPalavrasDosTitulosDaCampanha(double precoMaximo) {
        return catalogo.stream()
                .filter(i -> i.getPreco() <= precoMaximo)
                .map(i -> i.getTitulo())
                .map(i -> i.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        // TODO 03:
        // 1. Filtre itens com preco menor ou igual a precoMaximo.
        // 2. Pegue os titulos.
        // 3. Quebre cada titulo com split(" ").
        // 4. Use flatMap(Arrays::stream).
        // 5. Remova palavras repetidas e ordene.
    }

    private static String criarResumoDaCampanha(String categoria, double precoMaximo) {
        long quantidade = catalogo.stream()
                .filter(i -> i.getCategoria().equals(categoria))
                .filter(i -> i.getPreco() <= precoMaximo)
                .count();


        List<String> tags = buscarTagsDeItensBaratos(categoria, precoMaximo, catalogo.size());
        String tagsString = String.join(", ",tags);

        return "Categoria: "+categoria+" | itens baratos: "+quantidade+" | tags: "+tagsString;
        // TODO 04:
        // Monte uma String neste formato:
        // Categoria: Light Novel | itens baratos: 3 | tags: acao, classico, luta
        //
        // Regras:
        // - A quantidade deve contar itens da categoria com preco menor ou igual a precoMaximo.
        // - As tags devem vir do metodo buscarTagsDeItensBaratos.
        // - Use String.join para juntar as tags.
    }

    private static class ItemCampanha {
        private final String titulo;
        private final String categoria;
        private final double preco;
        private final List<String> tags;

        private ItemCampanha(String titulo, String categoria, double preco, List<String> tags) {
            this.titulo = titulo;
            this.categoria = categoria;
            this.preco = preco;
            this.tags = tags;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getCategoria() {
            return categoria;
        }

        public double getPreco() {
            return preco;
        }

        public List<String> getTags() {
            return tags;
        }

        @Override
        public String toString() {
            return "ItemCampanha{" +
                    "titulo='" + titulo + '\'' +
                    ", categoria='" + categoria + '\'' +
                    ", preco=" + preco +
                    ", tags=" + tags +
                    '}';
        }
    }
}
