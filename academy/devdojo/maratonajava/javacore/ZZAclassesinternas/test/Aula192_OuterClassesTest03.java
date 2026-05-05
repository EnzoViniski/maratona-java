package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class Aula192_OuterClassesTest03 {
    private String name = "Enzo";
    static class Nested{
        private String lastName = "Viniski";
        void print(){
            System.out.println(new Aula192_OuterClassesTest03().name + " " + lastName);
        }
    }

    public static void main(String[] args) {
//        Aula192_OuterClassesTest03.Nested nested = new Aula192_OuterClassesTest03.Nested();
        Nested nested = new Nested();
        nested.print();
    }
}
