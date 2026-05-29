package academy.devdojo.maratonajava.javacore.ZZEstreams.test;


import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Aula208_StreamTest06 {
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
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8));
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() < 0));

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 7)
                .findAny()
                .ifPresent(System.out::println);

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 5)
                .sorted(Comparator.comparing(LightNovel::getPrice).reversed())
                .findFirst()
                .ifPresent(System.out::println);

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 5)
                .max(Comparator.comparing(LightNovel::getPrice).reversed())
                .ifPresent(System.out::println);
    }


}
