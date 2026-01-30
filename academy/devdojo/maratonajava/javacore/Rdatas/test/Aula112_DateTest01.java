package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Date;

public class Aula112_DateTest01 {
    public static void main(String[] args) {
        Date date = new Date();
        date.setTime(date.getTime()+3600000L);
        System.out.println(date);
    }
}
