package academy.devdojo.maratonajava.javacore.Jmodificadorfinal.test;

import academy.devdojo.maratonajava.javacore.Jmodificadorfinal.domain.Carro;
import academy.devdojo.maratonajava.javacore.Jmodificadorfinal.domain.Comprador;
import academy.devdojo.maratonajava.javacore.Jmodificadorfinal.domain.Ferraro;

public class CarroTest01 {
    public static void main(String[] args) {
        Carro carro = new Carro();
        System.out.println(Carro.VELOCIDADE_LIMITE);
        System.out.println(carro.COMPRADOR);
        carro.COMPRADOR.setNome("Celta");
        System.out.println(carro.COMPRADOR);
        Ferraro ferrari = new Ferraro();
        ferrari.setNome("Ferrari");
        ferrari.imprime();

    }
}
