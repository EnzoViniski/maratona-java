package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.exception.domain.LoginInvalidoException;

import java.util.Scanner;

public class Aula104_LoginInvalidoExceptionTest01 {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            throw new RuntimeException(e);
        }
    }

    private static void logar() throws LoginInvalidoException {
        Scanner input = new Scanner(System.in);
        String usernameDB = "Enzo";
        String senhaDB = "ssj";
        System.out.println("Usuário");
        String usernameDigitado = input.nextLine();
        System.out.println("Senha");
        String senhaDigitado = input.nextLine();

        if(!usernameDB.equals(usernameDigitado) || !senhaDB.equals(senhaDigitado)){
            throw new LoginInvalidoException("Usuário ou senha inválidos");
        }

        System.out.println("Usuários logado com sucesso");
    }
}
