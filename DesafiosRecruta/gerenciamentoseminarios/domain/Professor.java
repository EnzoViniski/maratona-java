package DesafiosRecruta.gerenciamentoseminarios.domain;

public class Professor {
    private String nome;
    private String especialidade;
    private Seminario[] seminarios;


    public Professor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public void imprime() {
        System.out.println("Professor: " + this.nome);
        System.out.println("Especialidade: " + this.especialidade);
        if (seminarios == null) return;
        for (Seminario seminario : seminarios) {
            System.out.println("## Seminário:");
            if (seminario.getLocal() != null){
                System.out.println("Local: " + seminario.getLocal().getEndereco());
            }
            if (seminario.getAlunos() == null || seminario.getAlunos().length == 0) continue;
            System.out.println("Alunos: ");
            for (Aluno aluno : seminario.getAlunos()) {
                System.out.println("-- Aluno: " + aluno.getNome() + " | Idade:" + aluno.getIdade());
            }

        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Seminario[] getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(Seminario[] seminarios) {
        this.seminarios = seminarios;
    }
}
