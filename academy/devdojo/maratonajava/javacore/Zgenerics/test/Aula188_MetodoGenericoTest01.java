package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Barco;

import java.util.List;

public class Aula188_MetodoGenericoTest01 {
    public static void main(String[] args) {
        List<Barco> barcoList = criarArrayDeUmObjeto(new Barco("Canoa"));
        System.out.println(barcoList);
    }

    private static <T> List<T> criarArrayDeUmObjeto(T t){
        return List.of(t);
    }
}
