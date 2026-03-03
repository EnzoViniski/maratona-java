package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentalService {
    private List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Canoa"), new Barco("Navio")));

    public Barco buscarBarcoDisponivel() {
        System.out.println("Buscando barcos disponíveis...");
        Barco barco = barcosDisponiveis.remove(0);
        System.out.println("Alugando barco: "+barco);
        System.out.println("Barcos disponíveis para usar:");
        System.out.println(barcosDisponiveis);
        return barco;
    }

    public void retornandoBarcoAlugado (Barco barco){
        System.out.println("Devolvendo barco: "+barco);
        barcosDisponiveis.add(barco);
        System.out.println("Barcos disponíveis para usar:");
        System.out.println(barcosDisponiveis);
    }

}
