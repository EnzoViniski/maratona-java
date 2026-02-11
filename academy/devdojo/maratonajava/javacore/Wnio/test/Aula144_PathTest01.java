package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Aula144_PathTest01 {
    public static void main(String[] args) {
        Path p1 = Paths.get("/Users/enzoviniski/IdeaProjects/untitled/src/file.txt");
        Path p2 = Paths.get("Users","enzoviniski/IdeaProjects/untitled/src/file.txt");
        Path p3 = Paths.get("Users","enzoviniski","IdeaProjects","untitled","src","file.txt");

        System.out.println(p1.getFileName());
        System.out.println(p2.getFileName());
        System.out.println(p3.getFileName());

    }
}
