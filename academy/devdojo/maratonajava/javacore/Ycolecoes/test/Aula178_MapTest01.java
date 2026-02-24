package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Aula178_MapTest01 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
//        Map<String, String> map = new LinkedHashMap<>();


        // primeiro passa-se a chave e depois o valor correspondente
        // da mesma forma, utiliza-se o hash para identificação e iteração, e por isso o LinkedHashMap para ordenar a partir da entrada
        map.put("meza", "mesa");
        map.put("vc", "você");
        map.put("vce", "você");
        map.putIfAbsent("vc2", "você");

        System.out.println(map);

        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        System.out.println("----------");

        for (String value : map.values()) {
            System.out.println(value);
        }

        System.out.println("----------");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
