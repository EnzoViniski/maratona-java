package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class Aula189_OuterClassesTest01 {
    private String name = "Monkey D. Luffy";

    class Inner {
        public void printOuterClassAttribute(){
            System.out.println(name);
            System.out.println(this);
            System.out.println(Aula189_OuterClassesTest01.this);
        }
    }

    public static void main(String[] args) {
        Aula189_OuterClassesTest01 outerClassesTest01 = new Aula189_OuterClassesTest01();
        Inner inner = outerClassesTest01.new Inner();
        Inner inner2 = new Aula189_OuterClassesTest01().new Inner();
        inner.printOuterClassAttribute();
        inner2.printOuterClassAttribute();
    }
}

