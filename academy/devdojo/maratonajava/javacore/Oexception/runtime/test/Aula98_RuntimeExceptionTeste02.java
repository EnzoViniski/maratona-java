package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class Aula98_RuntimeExceptionTeste02 {
    public static void main(String[] args) {
        System.out.println(divisao(1, 0));
    }

    /**
     *
     * @param a
     * @param b não pode ser zero
     * @return
     * @throws IllegalArgumentException a variável b foi instaciada como zero
     */
    private static int divisao(int a, int b){
//        try {
//            return a/b;
//        }catch (ArithmeticException e){
//            e.printStackTrace();
//        }
//        return 0;
        if (b == 0){
            throw new IllegalArgumentException("Argumento inválido, o divisor não pode ser 0");
        }
        return a/b;
    }
}
