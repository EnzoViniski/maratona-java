package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;

import java.util.*;
import java.util.stream.Collectors;

public class Aula214_StreamTest12 {
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
        Map<Category, List<LightNovel>> categoryLightNovelMap = new HashMap<>();
        List<LightNovel> drama = new ArrayList<>();
        List<LightNovel> fantasy = new ArrayList<>();
        List<LightNovel> action = new ArrayList<>();

        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCategory()) {
                case DRAMA:
                    drama.add(lightNovel);
                    break;
                case ACTION:
                    action.add(lightNovel);
                    break;
                case FANTASY:
                    fantasy.add(lightNovel);
                    break;
            }
        }

        categoryLightNovelMap.put(Category.DRAMA ,drama);
        categoryLightNovelMap.put(Category.FANTASY ,fantasy);
        categoryLightNovelMap.put(Category.ACTION ,action);

        System.out.println(categoryLightNovelMap);

        System.out.println("---------");

        Map<Category, List<LightNovel>> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory));
        System.out.println(collect);


    }

}
