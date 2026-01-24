package academy.devdojo.maratonajava.javacore.Aintrocucaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintrocucaoclasses.domain.Carro;

public class CarroTest01 {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        Carro carro2 = new Carro();
        carro1.nome = "Civic";
        carro1.ano = 2012;
        carro1.modelo = "Sport";

        carro2.nome = "Celta";
        carro2.ano = 2010;
        carro2.modelo = "Flex";

        carro2 = carro1;

        System.out.println("Nome: " + carro1.nome + " \nAno: " + carro1.ano + " \nModelo: " + carro1.modelo);
        System.out.println("\nNome: " + carro2.nome + " \nAno: " + carro2.ano + " \nModelo: " + carro2.modelo);

    }
}
