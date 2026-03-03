package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Barco;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.BarcoRentalService;

public class Aula186_ClasseGenericaTest02 {
    public static void main(String[] args) {
        BarcoRentalService BarcoRentalService = new BarcoRentalService();
        Barco Barco = BarcoRentalService.buscarBarcoDisponivel();
        System.out.println("Usando Barco por um mês...");
        BarcoRentalService.retornandoBarcoAlugado(Barco);
    }
}
