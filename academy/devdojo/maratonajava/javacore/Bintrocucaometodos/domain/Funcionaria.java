package academy.devdojo.maratonajava.javacore.Bintrocucaometodos.domain;

public class Funcionaria {
    private String nome;
    private int idade;
    private double[] salarios;


    public void imprime() {
        System.out.println("------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        if (salarios == null){
            return;
        }
        for (double salario : salarios) {
            System.out.println(" " + salario);
        }
    }

    public void mediaSalarios() {
        if (salarios == null){
            return;
        }
        double media = 0;
        for (double salario : salarios) {
            media += salario;
        }
        media /= salarios.length;
        System.out.println(media);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double[] getSalarios() {
        return salarios;
    }

    public void setSalarios(double[] salarios) {
        this.salarios = salarios;
    }
}
