package academy.devdojo.maratonajava.javacore.Aintrocucaoclasses.domain;

public class CandidatoDev {
    public String name;
    public int age;
    public String linguagemFoco;

    public void imprime() {
        System.out.println(name + " " + age + " " + linguagemFoco);
    }

    public void verificarStatus (){
        if (age < 18) {
            System.out.println("Status: Estagiário");
        } else {
            System.out.println("Status: Desenvolvedor Júnior");
        }
    }
}
