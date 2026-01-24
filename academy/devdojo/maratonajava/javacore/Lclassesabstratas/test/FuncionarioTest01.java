package academy.devdojo.maratonajava.javacore.Lclassesabstratas.test;

import academy.devdojo.maratonajava.javacore.Lclassesabstratas.domain.Desenvolvedor;
import academy.devdojo.maratonajava.javacore.Lclassesabstratas.domain.Funcionario;
import academy.devdojo.maratonajava.javacore.Lclassesabstratas.domain.Gerente;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Gerente gerente1 = new Gerente("Ayme", 5000);
        Desenvolvedor desenvolvedor1 = new Desenvolvedor("Enzo", 10000);
        System.out.println(gerente1);
        System.out.println(desenvolvedor1);
        gerente1.imprime();
    }
}
