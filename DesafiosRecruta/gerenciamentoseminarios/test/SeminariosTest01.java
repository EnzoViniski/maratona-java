package DesafiosRecruta.gerenciamentoseminarios.test;

import DesafiosRecruta.gerenciamentoseminarios.domain.Aluno;
import DesafiosRecruta.gerenciamentoseminarios.domain.Local;
import DesafiosRecruta.gerenciamentoseminarios.domain.Professor;
import DesafiosRecruta.gerenciamentoseminarios.domain.Seminario;

public class SeminariosTest01 {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Enzo", 18);
        Aluno aluno2 = new Aluno("Ayme", 23);
        Aluno[] alunos = {aluno1, aluno2};

        Aluno aluno3 = new Aluno("Jasmin", 28);
        Aluno aluno4 = new Aluno("Andre", 33);
        Aluno[] alunos2 = {aluno3, aluno4};

        Local local1 = new Local("Av.Afonso Pena");

        Professor professo1 = new Professor("Jailton", "Java");

        Seminario seminario1 = new Seminario("Seminario Java 1", local1);
        Seminario seminario2 = new Seminario("Seminario Java 2", local1);

        Seminario[] seminarios = {seminario1, seminario2};

        seminario1.setAlunos(alunos);
        seminario2.setAlunos(alunos2);

        professo1.setSeminarios(seminarios);

        professo1.imprime();


    }
}
