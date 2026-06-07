package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.Promotion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Aula215_StreamTest13 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 5.99, Category.ACTION),
            new LightNovel("Bakugan", 8.00, Category.ACTION),
            new LightNovel("Dragon Ball", 2.99, Category.ACTION),
            new LightNovel("Goku", 3.99, Category.DRAMA),
            new LightNovel("Pokemon", 7.55, Category.DRAMA),
            new LightNovel("Amazing Spider Man", 0.99, Category.FANTASY),
            new LightNovel("Shipudden", 0.99, Category.FANTASY)
    ));

    public static void main(String[] args) {
        Map<Promotion, List<LightNovel>> collect = lightNovels.
                stream().
                collect(groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE
                ));

        System.out.println(collect);

        Map<Category, Map<Promotion, List<LightNovel>>> collect2 = lightNovels.stream().collect(groupingBy(LightNovel::getCategory, groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE
        )));

        System.out.println(collect2);

    }

}
