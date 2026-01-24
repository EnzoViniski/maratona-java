package academy.devdojo.maratonajava.javacore.Fmodificadorestatico.test;

import academy.devdojo.maratonajava.javacore.Fmodificadorestatico.domain.Carro;

public class CarroTest01 {
    public static void main(String[] args) {
        Carro c1 = new Carro("MERCEDES", 280);
        Carro c2 = new Carro("CHEVROLET", 260);
        Carro c3 = new Carro("FORD", 300);

        Carro.setVelocidadeLimite(200);
        c1.imprime();
        c2.imprime();
        c3.imprime();


    }
}
