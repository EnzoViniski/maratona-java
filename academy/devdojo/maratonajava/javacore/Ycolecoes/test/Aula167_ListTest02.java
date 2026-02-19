package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class Aula167_ListTest02 {
    public static void main(String[] args) {
        List<String> nome = new ArrayList<>();
        List<String> nome2 = new ArrayList<>();
        nome.add("William");
        nome.add("DevDojo");
        nome.remove("DevDojo");
        // ou nome.remove(1);
        nome2.add("Suane");
        nome2.add("Academy");

        nome.addAll(nome2);

        for (String nomes : nome){
            System.out.println(nomes);
        }
        System.out.println("-----------");
        int size = nome.size();
        for (int i = 0; i < size; i++) {
            nome.add("Suane");
            System.out.println(nome.get(i));
        }
        List<Integer> numeros = new ArrayList<>();
        //Devemos usar os wrappers, pois precisa ser passado um objeto
        numeros.add(1);
        System.out.println(numeros);
    }
}
