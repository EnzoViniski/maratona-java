package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Aluno;
import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Local;
import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Professor;
import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Seminario;

import java.util.Scanner;

public class SeminariosTest01 {
    public static void main(String[] args) {
        Local local1 = new Local("Av.Afonso Pena");
        Aluno aluno1 = new Aluno("Enzo", 18);
        Aluno aluno2 = new Aluno("Ayme", 23);
        Aluno[] alunos = {aluno1, aluno2};
        Seminario seminario1 = new Seminario("Seminário Java", local1);
        seminario1.setAlunos(alunos);
        Seminario[] seminarios = {seminario1};

        Professor professor1 = new Professor("Jacson", "Java");
        professor1.setSeminarios(seminarios);

        professor1.imprime();

        Scanner input = new Scanner(System.in);
        System.out.println("Deseja mudar o endereço do local1? Digite S para sim ou N para nao");
        String pergunta = input.nextLine();
        if (pergunta.charAt(0) == 'N') {
            return;
        }else if (pergunta.charAt(0) == 'S'){
            System.out.println("Digite o novo endereço: ");
            String novoEndereco = input.nextLine();
            local1.setEndereco(novoEndereco);
            professor1.imprime();
        }
    }
}
