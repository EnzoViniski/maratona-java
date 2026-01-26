package academy.devdojo.maratonajava.javacore.Pwrapper.test;

public class Aula107_WrapperTest02 {
    public static void main(String[] args) {

        Byte byteW = 1;
        Short shortW = 1;
        Integer intW = 1;  // autoboxing
        Long longW = 10L;
        Float floatW = 10F;
        Double doubleW = 10D;
        Character charW = 'W';
        Boolean boolenaW = true;

        int intP = intW; // unboxing

        Integer intW2 = Integer.parseInt("1");
        Long longW2 = Long.parseLong("123456");
        Boolean booleanW2 = Boolean.parseBoolean("TruE");
        System.out.println(booleanW2);

        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('2'));

        System.out.println(Character.isLowerCase('A'));
        System.out.println(Character.toLowerCase('A'));
    }
}
