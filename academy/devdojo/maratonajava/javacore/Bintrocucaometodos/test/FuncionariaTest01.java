package academy.devdojo.maratonajava.javacore.Bintrocucaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintrocucaometodos.domain.Funcionaria;

public class FuncionariaTest01 {
    public static void main(String[] args) {
    Funcionaria funcionario1 = new Funcionaria();
    funcionario1.setIdade(15);
    funcionario1.setNome("Andrey");
    funcionario1.setSalarios(new double[]{200, 2000, 3000});
    funcionario1.imprime();
    funcionario1.mediaSalarios();
    }
}
