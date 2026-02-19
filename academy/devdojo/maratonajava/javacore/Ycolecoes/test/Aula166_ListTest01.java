package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class Aula166_ListTest01 {
    public static void main(String[] args) {
        List<String> nome = new ArrayList<>();
        nome.add("William");
        nome.add("DevDojo Academy");
        for (String nomes : nome) {
            System.out.println(nomes);
        }
        System.out.println("-----------");
        nome.add("Suane");
        for (int i = 0; i < nome.size(); i++) {
            System.out.println(nome.get(i));
        }
    }
}
