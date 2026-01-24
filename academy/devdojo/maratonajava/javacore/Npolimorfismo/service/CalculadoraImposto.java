package academy.devdojo.maratonajava.javacore.Npolimorfismo.service;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Computador;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Produto;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Tomate;

public class CalculadoraImposto {

    // Quando não usamos nenhuma variável local no metodo, o mesmo pode ser static
    public static void calcularImposto(Produto produto){
        System.out.println("Relatório de imposto: ");
        double imposto = produto.calcularImposto();
        System.out.println("Produto "+produto.getNome());
        System.out.println("Valor "+produto.getValor());
        System.out.println("Imposto a ser pago: "+imposto);
        if ( produto instanceof Tomate){
            Tomate tomate = (Tomate) produto;
//            ((Tomate) produto).getDataValidade();
            System.out.println(tomate.getDataValidade());
        }
    }
}
