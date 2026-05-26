package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

public class Aula201_OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> nameOptional = findName("William");
        String empty = nameOptional.orElse("EMPTY");
        System.out.println(nameOptional);
        System.out.println(empty);
        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));
        nameOptional.ifPresent(s -> System.out.println(s.toLowerCase()));
    }

    public static Optional<String> findName(String name){
        List<String> list = List.of("William", "Devdojo");
        int i = list.indexOf(name);
        if (i != -1){
            return Optional.of(list.get(i));
        }
        return Optional.empty();
    }
}
