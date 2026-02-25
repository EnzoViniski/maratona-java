package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Aula181_NavigableMapTest01 {
    public static void main(String[] args) {
        NavigableMap<String, String> map = new TreeMap<>();
        // é um map que pode servir como por exemplo um dicionário, e nesse caso o TreeMap ordena a partir da key ou do comparator definido
        // novamente, os elementos devem implementar comparable
        map.put("A", "Letra A");
        map.put("B", "Letra B");
        map.put("C", "Letra C");
        map.put("E", "Letra E");
        map.put("D", "Letra D");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println(map.headMap("A", true));
        System.out.println(map.ceilingKey("A"));
        System.out.println(map.floorKey("A"));
        System.out.println(map.lowerKey("C"));
        System.out.println(map.higherKey("A"));
    }
}
