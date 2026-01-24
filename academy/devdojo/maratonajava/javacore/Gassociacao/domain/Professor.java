package academy.devdojo.maratonajava.javacore.Gassociacao.domain;

public class Professor {
    private String nome;
    private String especialidade;
    private Seminario[] seminarios;

    public Professor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }
    public void imprime(){
        System.out.println("Professor: "+ nome);
        System.out.println("Especialidade: "+especialidade);
        if (seminarios == null) return;
        for (Seminario seminario : seminarios) {
            System.out.println("## Seminário: " + seminario.getTitulo());
            System.out.println("Local: "+seminario.getLocal().getEndereco());
            if(seminario.getAlunos() == null) continue;
            System.out.println("Alunos: ");
            for (Aluno aluno : seminario.getAlunos()) {
                System.out.println("--Aluno: "+aluno.getNome()+" | Idade: " +aluno.getIdade());
            }
        }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
