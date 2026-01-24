package academy.devdojo.maratonajava.javacore.Bintrocucaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintrocucaometodos.domain.Pessoa;

public class PessoaTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Maria");
        pessoa.setIdade(-2);
        // pessoa.imprime();
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getIdade());
    }
}
