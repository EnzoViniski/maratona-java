package academy.devdojo.maratonajava.javacore.ZZDoptional.exercicios;

import java.util.List;
import java.util.Optional;

public class OptionalExercicio04 {
    private static List<Usuario> usuarios = List.of(
            new Usuario("Naruto", "naruto@devdojo.com"),
            new Usuario("Hinata", "hinata@devdojo.com"),
            new Usuario("Sasuke", "sasuke@devdojo.com")
    );
    public static void main(String[] args) {

        buscarEmail("Naruto")
                .ifPresent(e -> System.out.println(e));

        buscarEmail("Hinata")
                .ifPresentOrElse(e -> System.out.println(e.trim()), () -> System.out.println("Email nao cadastrado"));

        buscarEmail("Sasuke")
                .orElse("sem-email@devdojo.com");

        String emailPadrao = buscarEmail("Teste")
                .orElse("sem-email@devdojo.com");

        System.out.println(emailPadrao);
    }

    private static Optional<String> buscarEmail(String nome){
        for (Usuario usuario : usuarios){
            if (usuario.getNome().equals(nome)){
                return Optional.of(usuario.getEmail());
            }
        }
        return Optional.empty();
    }
    private static String buscarEmailAntigo(String nome) {
        List<Usuario> usuarios = List.of(
                new Usuario("Naruto", "naruto@devdojo.com"),
                new Usuario("Hinata", "hinata@devdojo.com"),
                new Usuario("Sasuke", "sasuke@devdojo.com")
        );

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario.getEmail();
            }
        }
        return null;
    }

    private static class Usuario {
        private final String nome;
        private final String email;

        private Usuario(String nome, String email) {
            this.nome = nome;
            this.email = email;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }
    }
}
