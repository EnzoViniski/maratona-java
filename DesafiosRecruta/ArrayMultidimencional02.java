package DesafiosRecruta;

public class ArrayMultidimencional02 {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        System.out.println(arr[1]);
        arr[0] = new int[2];
        arr[1] = new int[4];
        arr[2] = new int[3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + j;
            }
        }

        for (int[] arrBase : arr){
            System.out.println("-------");
            for(int num : arrBase){
                System.out.print(num + " ");
            }

        }
    }
}
