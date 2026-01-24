package academy.devdojo.maratonajava.introducao;

public class Aula08ArraysMultidimensionais01 {
    public static void main(String[] args) {
        // 1, 2, 3, 4, 5 meses
        // 31, 28, 30, 16 dias
        int [][] days = new int[12][31];
        for (int i = 0; i < 12; i++) {
            int x = 0;
            for (int j = 0; j < 31; j++) {
                days[i][j] = ++x;
            }
        }


        for (int i = 0; i < 12; i++){
            for (int j = 0; j < days[i].length; j++){
                System.out.println(days[i][j]);
            }
        }
        System.out.println("-----------");
        for (int [] arrBase : days){
            for (int num : arrBase){
                System.out.println(num);
            }
        }
    }
}
