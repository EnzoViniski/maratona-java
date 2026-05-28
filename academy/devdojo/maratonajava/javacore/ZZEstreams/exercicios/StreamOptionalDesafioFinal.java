package academy.devdojo.maratonajava.javacore.ZZEstreams.exercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamOptionalDesafioFinal {
    private static final List<ItemCatalogo> catalogo = new ArrayList<>(List.of(
            new ItemCatalogo(1, "Naruto", "Manga", 20.0, 72),
            new ItemCatalogo(2, "Boku no hero", "Manga", 10.0, 38),
            new ItemCatalogo(3, "Dragon Ball", "Light Novel", 2.99, 42),
            new ItemCatalogo(4, "Goku", "Light Novel", 3.99, 1),
            new ItemCatalogo(5, "Pokemon", "Light Novel", 7.55, 12),
            new ItemCatalogo(6, "Amazing Spider Man", "HQ", 0.99, 4),
            new ItemCatalogo(7, "Shipudden", "Light Novel", 0.99, 1)
    ));

    public static void main(String[] args) {
        System.out.println("Item por id:");
        System.out.println(buscarPorId(2).orElse(new ItemCatalogo(0, "Nao encontrado", "Nenhum", 0, 0)));

        System.out.println("Item obrigatorio:");
        System.out.println(buscarObrigatorioPorTitulo("Naruto"));

        System.out.println("Titulos baratos para campanha:");
        System.out.println(buscarTitulosBaratosParaCampanha(4));

        System.out.println("Quantidade de itens unicos baratos:");
        System.out.println(contarItensUnicosBaratos());

        System.out.println("Resumo:");
        System.out.println(criarResumoDeCampanha("Goku", 4));
    }

    private static Optional<ItemCatalogo> buscarPorId(Integer id) {
        return buscarPor(i -> i.getId().equals(id));

    }

    private static Optional<ItemCatalogo> buscarPorTitulo(String titulo) {
        return buscarPor(i -> i.getTitulo().equals(titulo));
    }

    private static Optional<ItemCatalogo> buscarPor(Predicate<ItemCatalogo> predicate) {
        ItemCatalogo found;
        for (ItemCatalogo itemCatalogo : catalogo) {
            if (predicate.test(itemCatalogo)) {
                found = itemCatalogo;
                return Optional.of(found);
            }
        }
        return Optional.empty();
    }

    private static ItemCatalogo buscarObrigatorioPorTitulo(String titulo) {
        return buscarPorTitulo(titulo)
                .orElseThrow(IllegalArgumentException::new);
    }

    private static List<String> buscarTitulosBaratosParaCampanha(double precoMaximo) {
        return catalogo.stream()
                .sorted(Comparator.comparing(ItemCatalogo::getTitulo))
                .filter(i -> i.getPreco() < precoMaximo)
                .distinct()
                .limit(4)
                .map(ItemCatalogo::getTitulo)
                .collect(Collectors.toList());
    }

    private static long contarItensUnicosBaratos() {
        return catalogo.stream()
                .filter(i -> i.getPreco() < 4)
                .distinct()
                .count();
    }

    private static String criarResumoDeCampanha(String titulo, double precoMaximo) {
        // Poderia usar buscarPorTitulo(titulo) para treinar Optional neste metodo tambem.
        // A quantidade de opcoes baratas deveria usar o precoMaximo recebido, nao o valor fixo do contarItensUnicosBaratos().
        long quantidade = catalogo.stream()
                .filter(j -> j.getTitulo().equals(titulo))
                .count();

        
        long intensBaratos = catalogo.stream()
                .filter(i -> i.getPreco()<precoMaximo)
                .count();

        if (quantidade >= 1){
            return titulo+" participa da campanha com "+intensBaratos+" opcoes baratas";
        } else {
            return "Item fora do catalogo";
        }
    }

    private static class ItemCatalogo {
        private final Integer id;
        private final String titulo;
        private final String categoria;
        private final double preco;
        private final int volumes;

        private ItemCatalogo(Integer id, String titulo, String categoria, double preco, int volumes) {
            this.id = id;
            this.titulo = titulo;
            this.categoria = categoria;
            this.preco = preco;
            this.volumes = volumes;
        }

        public Integer getId() {
            return id;
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

        public int getVolumes() {
            return volumes;
        }

        @Override
        public String toString() {
            return "ItemCatalogo{" +
                    "id=" + id +
                    ", titulo='" + titulo + '\'' +
                    ", categoria='" + categoria + '\'' +
                    ", preco=" + preco +
                    ", volumes=" + volumes +
                    '}';
        }
    }
}
