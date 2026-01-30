package academy.devdojo.maratonajava.javacore.Qstring.test;

public class Aula108_StringTest01 {
    public static void main(String[] args) {
        String nome = "Enzo"; //String constant pool
        String nome2 = "Enzo";
        nome = nome.concat(" Castro");
        System.out.println(nome);
        System.out.println(nome == nome2);
        String nome3 = new String("Enzo"); // 1 Variavel de referencia, 2 objeto do tipo string, 3 uma string no pool de string
        System.out.println(nome2 == nome3);
        System.out.println(nome2 == nome3.intern());
    }
}
