package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao04 {
    static void main() {
        double valorCarro = 30000;
        for (int parcela = 1; parcela <= valorCarro; parcela++) {
            double valorParcela = valorCarro / parcela;
            if (valorParcela >= 1000){
                System.out.println("Parcela "+parcela+" R$"+ valorParcela);
            } else {
                break;
            }
        }
    }
}
