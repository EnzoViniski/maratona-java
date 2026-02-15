package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.*;

public class Aula156_PathMatcherTest01 {
    public static void main(String[] args) {
        Path path1 = Paths.get("pasta/subpasta/file.txt");
        Path path2 = Paths.get("pasta/subpasta/file.bkp");
        Path path3 = Paths.get("pasta/subpasta/file.java");
        matches(path1, "glob:**.bkp");
        matches(path2, "glob:**.bkp");
        matches(path3, "glob:**.{bkp,txt,java}");
        matches(path3, "glob:**.????");
        matches(path3, "glob:**/file.????");

    }

    private static void matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob+":"+matcher.matches(path));
    }
}
