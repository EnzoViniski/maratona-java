package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais03 {
    static void main() {
        //Operador Ternário
        double salario = 2000;
        String mensagemDoar = "Eu vou doar 500 pro DevDojo";
        String mensagemNaoDoar = "Ainda não tenho condições, mas vou ter";
        // condição ? verdadeirp : falso;
        //String resultado = salario > 5000 ? mensagemDoar : mensagemNaoDoar;
        /* String resultado;
        if(salario > 5000){
            resultado = mensagemDoar;
        } else {
            resultado = mensagemNaoDoar;
        }
         */
        String resultado = salario > 5000 ? "Eu vou doar 500 pro DevDojo" : "Ainda não tenho condições, mas vou ter";
        System.out.println(resultado);
    }
}
