package academy.devdojo.maratonajava.introducao;

public class Aula05EstuturasCondicionaisExercicio {
    static void main() {
        double salario = 2000;
        String resultado;
        double imposto = salario;
        if (salario <= 34712) {
            resultado = "9.70%";
            salario *= (100 - 9.70) / 100;
        } else if (salario <= 68507) {
            resultado = "37.35%";
            salario *= (100 - 37.35) / 100;

        } else {
            resultado = "49.50%";
            salario *= (100 - 49.50) / 100;

        }
        imposto -= salario;
        int x = -1;
        int y = 0;
        boolean isValorMaior = x > y;
        String resultado2 = isValorMaior ? "X é maior" : "Y é maior";
        System.out.println(resultado2);
        System.out.println("O imposto percentual é: " + resultado);
        System.out.println("O imposto é: " + imposto);

        System.out.println("E o sálario com imposto imbutido é: " + salario);

    }
}
