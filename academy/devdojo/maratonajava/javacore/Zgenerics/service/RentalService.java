package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import java.util.List;

public class RentalService<T> {
    private List<T> veiculosDisponiveis;

    public RentalService(List<T> veiculosDisponiveis) {
        this.veiculosDisponiveis = veiculosDisponiveis;
    }

    public T buscarVeiculoDisponivel() {
        System.out.println("Buscando veículos disponíveis...");
        T t = veiculosDisponiveis.remove(0);
        System.out.println("Alugando veículo: "+t);
        System.out.println("Veículo disponíveis para usar:");
        System.out.println(veiculosDisponiveis);
        return t;
    }

    public void retornandoVeiculoAlugado (T t){
        System.out.println("Devolvendo veículo: "+t);
        veiculosDisponiveis.add(t);
        System.out.println("Veículos disponíveis para usar:");
        System.out.println(veiculosDisponiveis);
    }

}
