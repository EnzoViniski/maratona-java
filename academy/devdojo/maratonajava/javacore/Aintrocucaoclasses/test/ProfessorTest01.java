package academy.devdojo.maratonajava.javacore.Aintrocucaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintrocucaoclasses.domain.Professor;

public class ProfessorTest01 {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.name = "Jacson";
        professor.age = 35;
        professor.sex = 'F';

        System.out.println(professor.name);
        System.out.println(professor.age);
        System.out.println(professor.sex);


    }
}
