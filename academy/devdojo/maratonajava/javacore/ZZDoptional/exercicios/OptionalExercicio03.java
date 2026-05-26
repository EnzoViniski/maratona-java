package academy.devdojo.maratonajava.javacore.ZZDoptional.exercicios;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalExercicio03 {
    private static final List<Produto> PRODUTOS = List.of(
            new Produto(1, "Teclado", 150.0),
            new Produto(2, "Mouse", 80.0),
            new Produto(3, "Monitor", 1200.0)
    );

    public static void main(String[] args) {
        buscarPorId(2)
                .ifPresent(p -> System.out.println(p));

        Produto produto = buscarPorNome("Notebook")
                .orElseGet(() -> new Produto(4, "Notebook", 3500.0));

        System.out.println(produto);

        buscarPorPrecoMaiorQue(1000)
                .ifPresent(p -> System.out.println("Produto caro encontrado: " + p));
    }

    private static Optional<Produto> buscarPorId(Integer id) {
        return buscarPor(p -> p.getId().equals(id));
    }

    private static Optional<Produto> buscarPorNome(String nome) {
        return buscarPor(p -> p.getNome().equals(nome));
    }

    private static Optional<Produto> buscarPorPrecoMaiorQue(double preco) {
        return buscarPor(p -> p.getPreco() > preco);
    }

    private static Optional<Produto> buscarPor(Predicate<Produto> predicate) {
        Produto encontrado = null;
        for (Produto produto : PRODUTOS) {
            if (predicate.test(produto)) {
                encontrado = produto;
                break;
            }
        }
        return Optional.ofNullable(encontrado);
    }

    private static class Produto {
        private final Integer id;
        private final String nome;
        private final double preco;

        private Produto(Integer id, String nome, double preco) {
            this.id = id;
            this.nome = nome;
            this.preco = preco;
        }

        public Integer getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        @Override
        public String toString() {
            return "Produto{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", preco=" + preco +
                    '}';
        }
    }
}
