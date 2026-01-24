package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.domain.Endereco;
import academy.devdojo.maratonajava.javacore.Hheranca.domain.Funcionario;
import academy.devdojo.maratonajava.javacore.Hheranca.domain.Pessoa;

public class HerancaTest01 {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        endereco.setCep("74333270");
        endereco.setRua("Av.Afondo Pena");
        Pessoa pessoa = new Pessoa("Enzo");
        pessoa.setCpf("09113744186");

        pessoa.setEndereco(endereco);
        pessoa.imprime();

        System.out.println("-------------");
        Funcionario funcionario = new Funcionario("Ayme", 1000);

        funcionario.setCpf("0911111111");
        funcionario.setEndereco(endereco);


        funcionario.imprime();
    }
}
