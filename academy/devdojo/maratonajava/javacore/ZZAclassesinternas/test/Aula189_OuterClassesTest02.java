package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Local;

public class Aula189_OuterClassesTest02 {
    private String name = "Enzo";

    void print (String param){
        String lastName = "Viniksi";
        class LocalClass{
            void printLocalClass(){
                System.out.println(param);
                System.out.println(name + " "+ lastName);
            }
        }
        LocalClass localClass = new LocalClass();
        localClass.printLocalClass();
    }
    public static void main(String[] args) {
        Aula189_OuterClassesTest02 outerClassesTest02 = new Aula189_OuterClassesTest02();
        outerClassesTest02.print("OI");
    }
}

