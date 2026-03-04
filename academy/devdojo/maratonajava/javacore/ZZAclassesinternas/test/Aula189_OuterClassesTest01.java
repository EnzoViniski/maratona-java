package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class Aula189_OuterClassesTest01 {
    private String name = "Monkey D.Luffy";

    class Inner {
        public void printOuterClassAtribute(){
            System.out.println(name);
            System.out.println(this);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Aula189_OuterClassesTest01  outerClass = new Aula189_OuterClassesTest01();
        Inner inner = outerClass.new Inner();
        Inner inner2 = new Aula189_OuterClassesTest01().new Inner();

        inner.printOuterClassAtribute();
        inner2.printOuterClassAtribute();
    }
}
