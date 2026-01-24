package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao05 {
    static void main() {
        double valorCarro = 30000;
        for (int parcela = (int) valorCarro; parcela >= 1; parcela--) {
            double valorParcela = valorCarro / parcela;
            if (valorParcela < 1000) {
                continue;
            }
            if (valorParcela >= 1000){
                System.out.println("Parcela "+parcela+" R$"+ valorParcela);
            } else {
                break;
            }
        }
    }
}
