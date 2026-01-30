package academy.devdojo.maratonajava.javacore.Qstring.test;

public class Aula111_StringBuilderTest01 {
    public static void main(String[] args) {
        String nome = "William Suane";
        nome = nome.concat(" DevDojo");
        nome.substring(0,3);
        System.out.println(nome);
        StringBuilder sb = new StringBuilder("William Suane");
        sb.append(" DevDojo").append(" Academy");
        sb.reverse();
        sb.substring(1);
        System.out.println(sb);
        System.out.println(sb);
        sb.delete(0,3);
        System.out.println(sb);
    }
}

