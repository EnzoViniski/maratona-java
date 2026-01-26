package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.exception.domain.Funcionario;
import academy.devdojo.maratonajava.javacore.Oexception.exception.domain.LoginInvalidoException;
import academy.devdojo.maratonajava.javacore.Oexception.exception.domain.Pessoa;

import java.io.FileNotFoundException;

public class Aula105_SobrescritaComExceptionTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();
        try {
            funcionario.salvar();
        } catch (LoginInvalidoException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
