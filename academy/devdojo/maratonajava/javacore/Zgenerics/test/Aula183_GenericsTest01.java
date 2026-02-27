package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class Aula183_GenericsTest01 {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Ola");
        lista.add("Ola");

        for (String o : lista) {
            System.out.println(o);
        }
        add(lista, new Consumidor("oi") );

        for (String o : lista) {
            System.out.println(o);
        }



    }

    private static void add(List<String> lista, Consumidor consumidor){
        lista.add(consumidor.getNome());
    }
}
