package academy.devdojo.maratonajava.javacore.Oexception.error.test;

public class Aula95_StackOverFlowTest01 {
    public static void main(String[] args) {
        recursividade();
    }

    public static void recursividade(){
        recursividade();
    }
}
