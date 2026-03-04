package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

import java.util.ArrayList;
import java.util.List;

class Animal implements Comparable<Animal> {
    private String nome;

    public Animal(String nome) { this.nome = nome; }

    @Override
    public int compareTo(Animal o) { return this.nome.compareTo(o.nome); }

    @Override
    public String toString() { return "Animal: " + nome; }
}

class Cachorro extends Animal {
    public Cachorro(String nome) { super(nome); }
}

class Gato extends Animal {
    public Gato(String nome) { super(nome); }
}

public class Aula190_ZooLabTest {

    public static <T extends Animal & Comparable<? super T>> List<T> realizarAnaliseComplexa(
            List<? extends T> listaLeitura,
            List<? super T> listaEscrita
    ) {
        final String seloDeAprovacao = "APROVADO_PELO_LAB";
        class AnalisadorGeneticoLocal {

            public List<T> processarDna() {
                List<T> resultado = new ArrayList<>();

                for (T animal : listaLeitura) {
                    System.out.println("Analisando " + animal + " - Status: " + seloDeAprovacao);

                    if (animal.compareTo(animal) == 0) {
                        resultado.add(animal);

                        listaEscrita.add(animal);
                    }
                }
                return resultado;
            }
        }

        AnalisadorGeneticoLocal cientista = new AnalisadorGeneticoLocal();

        return cientista.processarDna();
    }

    public static void main(String[] args) {
        List<Animal> animaisGerais = new ArrayList<>();
        List<Gato> gatos = new ArrayList<>();

        gatos.add(new Gato("Felix"));
        gatos.add(new Gato("Garfield"));

        List<Gato> resultado = realizarAnaliseComplexa(gatos, animaisGerais);

        System.out.println("Animais processados: " + resultado);
    }
}