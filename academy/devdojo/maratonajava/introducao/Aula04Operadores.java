package academy.devdojo.maratonajava.introducao;

public class Aula04Operadores {
    static void main() {
        // + - / *
        int numero01 = 10;
        int numero02 = 20;
        System.out.println(numero02 * numero01);
        int resultado = numero02 / numero01;
        System.out.println(resultado);
        // %
        int resto = 20 % 2;
        System.out.println(resto);
        // < > <= >= == != -----> boolean
        boolean isDezMaiorQueVinte = 10 > 20;
        boolean isDezIgualAVinte = 10 == 20;
        boolean isDezDiferenteVinte = 10 != 20;
        System.out.println(isDezMaiorQueVinte);
        System.out.println(isDezIgualAVinte);
        System.out.println(isDezDiferenteVinte);

        // && (AND) || (OR) !
        int idade = 24;
        int salario = 3200;
        boolean isDentroDaLei = idade >= 30 && salario >= 3500 || idade < 30 && salario >= 3100;
        System.out.println(isDentroDaLei);

        double ValorTotalContaCorrente = 1000;
        double ValorTotalContaPoupanca = 5000;
        float valorPlaystation = 6000F;
        double tentativa = ValorTotalContaCorrente + ValorTotalContaPoupanca;

        boolean isPlaystationCompravel = ValorTotalContaCorrente >= valorPlaystation || ValorTotalContaPoupanca >= valorPlaystation || tentativa >= valorPlaystation;

        System.out.println(isPlaystationCompravel);

        // = += -= *= /= %=
        double bonus = 2000;
        bonus += 1000;
        bonus -= 100;
        bonus *= 4;
        bonus /= 2;
        bonus %= 2;
        System.out.println(bonus);

        // ++ --
        int contador = 0;
        contador++;
        contador++;
        contador--;
        System.out.println(--contador);
        System.out.println(++contador);
        System.out.println(contador--);

    }
}
