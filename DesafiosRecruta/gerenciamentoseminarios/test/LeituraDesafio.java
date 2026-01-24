package DesafiosRecruta.gerenciamentoseminarios.test;

import DesafiosRecruta.gerenciamentoseminarios.domain.Aluno;

import java.util.Scanner;

public class LeituraDesafio {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(" ", 0);
        Aluno aluno2 = new Aluno(" ", 0);
        Aluno aluno3 = new Aluno(" ", 0);
        Aluno[] alunos = {aluno1, aluno2, aluno3};
        Scanner input = new Scanner(System.in);

        for (Aluno aluno : alunos) {
            System.out.println("Digite a idade do aluno: ");
            int idade = input.nextInt();
            while (idade < 0) {
                System.out.println("Idade inválida! Digite novamente:");
                idade = input.nextInt();
            }
            aluno.setIdade(idade);

            String vazio = input.nextLine();
            System.out.println("Digite o nome do aluno: ");
            String nome = input.nextLine();
            aluno.setNome(nome);
        }

        int sum = 0;
        for (Aluno aluno : alunos) {
            sum += aluno.getIdade();
        }
        double media = sum / 3.0;
        System.out.println(media);


    }
}
