package academy.devdojo.maratonajava.javacore.Qstring.test;

public class Aula109_StringTest02 {
    public static void main(String[] args) {
        String nome = "   Enzo    ";
        String numeros = "012345";
        System.out.println(nome.charAt(0));
        System.out.println(nome.toLowerCase());
        System.out.println(nome.toUpperCase());
        System.out.println(nome.replace("n","z"));
        System.out.println(nome.length());
        System.out.println(numeros.length());
        System.out.println(numeros.substring(0, 3)); // Nesse caso será imprimido os números da posição inicial até a posição 2
        System.out.println(nome.trim());

    }
}
