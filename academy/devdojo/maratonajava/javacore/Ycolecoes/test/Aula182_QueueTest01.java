package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class Aula182_QueueTest01 {
    public static void main(String[] args) {
        Queue<String> fila = new PriorityQueue<>();
        fila.add("A");
        fila.add("C");
        fila.add("B");

        while (!fila.isEmpty()){
            System.out.println(fila.poll());
        }
    }
}
