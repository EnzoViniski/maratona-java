package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais02 {
    static void main() {
        int age = 19;
        if (age < 15){
            System.out.println("Idade infantil.");
        } else if (age >= 15 && age <= 18){
            System.out.println("Idade jovem");
        } else {
            System.out.println("Idade adulta");
        }
    }
}
