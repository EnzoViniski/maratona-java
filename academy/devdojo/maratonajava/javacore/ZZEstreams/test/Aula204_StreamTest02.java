package academy.devdojo.maratonajava.javacore.ZZEstreams.test;


import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//1. Order LightNovel by title
//2. Retrieve the first 3 light novels with price less than 4
public class Aula204_StreamTest02 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 5.99),
            new LightNovel("Bakugan", 8.00),
            new LightNovel("Dragon Ball", 2.99),
            new LightNovel("Goku", 3.99),
            new LightNovel("Pokemon", 7.55),
            new LightNovel("Amazing Spider Man", 0.99),
            new LightNovel("Shipudden", 0.99)
    ));
    public static void main(String[] args) {
        List<String> list = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() < 4)
                .limit(3)
                .map(LightNovel::getTitle)
                .collect(Collectors.toList());

        System.out.println(list);
    }
}
