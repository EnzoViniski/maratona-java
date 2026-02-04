package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aula118_SimpleDateFormatTest01 {
    public static void main(String[] args) {
        String pattern = "'Goiânia,' dd'/'MM'/'yyyy 'às' H':'mm':'s";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        System.out.println(sdf.format(new Date()));

    }
}
