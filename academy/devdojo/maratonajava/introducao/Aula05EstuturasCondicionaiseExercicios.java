package academy.devdojo.maratonajava.introducao;

public class Aula05EstuturasCondicionaiseExercicios {
    static void main() {
        // Utilizando switch e dados os valores de 1 a 7, imprima se é dia útil ou final de semana
        // Considerando 1 como domingo
        byte day = 1;
        /* switch (day) {
            case 1:
                System.out.println("Final de semana");
                break;
            case 2:
                System.out.println("Dia útil");
                break;
            case 3:
                System.out.println("Dia útil");
                break;
            case 4:
                System.out.println("Dia útil");
                break;
            case 5:
                System.out.println("Dia útil");
                break;
            case 6:
                System.out.println("Dia útil");
                break;
            case 7:
                System.out.println("Final de semana");
                break;
        }
         */
        switch (day) {
            case 1:
            case 2:
                System.out.println("FDS");
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                System.out.println("Dia útil");
                break;
            default:
                System.out.println("Inválido");
                break;
        }

    }
}
