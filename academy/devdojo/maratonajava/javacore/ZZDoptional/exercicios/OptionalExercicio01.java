package academy.devdojo.maratonajava.javacore.ZZDoptional.exercicios;

import java.util.List;
import java.util.Optional;

public class OptionalExercicio01 {
    public static void main(String[] args) {
        Optional<String> nomeEncontrado = buscarNome("William");
        Optional<String> nomeNaoEncontrado = buscarNome("Luffy");

        System.out.println(nomeEncontrado);

        String nome = nomeNaoEncontrado.orElse("Nome nao encontrado");
        System.out.println(nome);

        nomeEncontrado.ifPresent(n ->System.out.println(n.toUpperCase()));

        nomeEncontrado.ifPresent(n -> System.out.println(n.toLowerCase()));
    }

    private static Optional<String> buscarNome(String name) {
        List<String> names = List.of("William", "Devdojo", "Java");

        int i = names.indexOf(name);
        if (i != -1){
            return Optional.of(names.get(i));
        }
        return Optional.empty();
    }
}
