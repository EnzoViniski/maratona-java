package DesafiosRecruta;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat nfBR = NumberFormat.getCurrencyInstance(localeBR);
        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        double valor = 100_000.123;

        System.out.println(nfBR.format(valor));

        DateFormat[] dF = new DateFormat[1];
        dF[0] = DateFormat.getInstance();

        System.out.println(dF[0].format(calendar.getTime()));

    }
}
