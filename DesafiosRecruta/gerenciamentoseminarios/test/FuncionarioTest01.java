package DesafiosRecruta.gerenciamentoseminarios.test;

import DesafiosRecruta.gerenciamentoseminarios.domain.Funcionario;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario("Enzo", "09113744186", 2000.0);
        funcionario1.imprime();
        if(funcionario1.getNome().equals("Enzo")){
            System.out.println("oi");
        }
        System.out.println(funcionario1);

    }
}
