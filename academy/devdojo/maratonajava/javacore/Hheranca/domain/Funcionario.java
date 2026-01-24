package academy.devdojo.maratonajava.javacore.Hheranca.domain;

public class Funcionario extends Pessoa {
    private double salario;
    static {
        System.out.println("Dentro do bloco de inicializacao estatico de Funcionario");
    }
    {
        System.out.println("Dentro do bloco de inicializacao nao estatico 1 de Funcionario");
    }
    {
        System.out.println("Dentro do bloco de inicializacao nao estatico 2 de Funcionario");
    }
    public Funcionario(String nome, double salario) {
        super(nome);
        System.out.println("Dentro do construtor de Funcionario");
        this.salario = salario;
    }

    public void imprime() {
        super.imprime();
        System.out.println(this.salario);
    }

    public void relatorioPagamento(){
        System.out.println("Eu "+ this.nome+" recebi um valor de:"+ this.salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
