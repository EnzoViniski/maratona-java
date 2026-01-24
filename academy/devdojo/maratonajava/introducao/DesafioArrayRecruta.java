package academy.devdojo.maratonajava.introducao;

public class DesafioArrayRecruta {
    public static void main(String[] args) {
        int[] num = {1, 3, 4, 5, 7, 8, 9, 12, 13, 25};
        int sum = 0;

        for (int i = 0; i < num.length; i++){
            if (num[i] % 2 != 0 && num[i] >= 15){
                break;
            } else if (num[i] % 2 == 0) {
                System.out.println(num[i]);
            }
            sum += num[i];

        }
        System.out.println(sum);
    }
}
