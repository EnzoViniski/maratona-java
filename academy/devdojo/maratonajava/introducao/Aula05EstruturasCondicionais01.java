package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais01 {
    static void main() {
        int age = 21;
        boolean isAltorizadoComprarBebida = age >= 18;
        // !
        if (isAltorizadoComprarBebida) {
            System.out.println("Pode comprar");
        } else if (!isAltorizadoComprarBebida){
            System.out.println("Não pode comprar");
        }
        if (!isAltorizadoComprarBebida) {
            System.out.println("Não pode comprar");
        }
        boolean c = false;
        if (!c) {
            System.out.println("C é falso");
        }
    }
}
