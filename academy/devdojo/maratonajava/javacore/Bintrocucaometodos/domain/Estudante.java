package academy.devdojo.maratonajava.javacore.Bintrocucaometodos.domain;

public class Estudante {
    public String name;
    public int age;
    public char sex;

    public void imprime(){
        System.out.println("---------");
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.sex);
    }
}