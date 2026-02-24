package academy.devdojo.maratonajava.javacore.Ycolecoes.domain;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Consumidor {
    private String nome;
    private Long id;

    public Consumidor(String nome) {
        this.nome = nome;
        this.id = ThreadLocalRandom.current().nextLong(0, 100_000); // Essa função cria ID's em Long de 0 a 100 mil
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Consumidor that = (Consumidor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Consumidor{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }

    public String getNome() {
        return nome;
    }
}
