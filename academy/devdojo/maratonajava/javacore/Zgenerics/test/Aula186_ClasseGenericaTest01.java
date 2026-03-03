package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Carro;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.CarroRentalService;

public class Aula186_ClasseGenericaTest01 {
    public static void main(String[] args) {
        CarroRentalService carroRentalService = new CarroRentalService();
        Carro carro = carroRentalService.buscarCarroDisponivel();
        System.out.println("Usando carro por um mês...");
        carroRentalService.retornandoCarroAlugado(carro);
    }
}
