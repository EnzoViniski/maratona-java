package DesafiosRecruta;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01MariaDuda {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime conhecidos = LocalDateTime.of(2024, Month.MAY, 23, 21, 0, 0);
        LocalDateTime namoro = LocalDateTime.of(2024, Month.NOVEMBER, 11, 16, 30, 0);
        System.out.println("Tempo com maria duda tiona:");
        System.out.println("Dias conhecidos: "+ ChronoUnit.DAYS.between(conhecidos, now));
        System.out.println("Semanas conhecidos: "+ ChronoUnit.WEEKS.between(conhecidos, now));
        System.out.println("Meses conhecidos: "+ ChronoUnit.MONTHS.between(conhecidos, now));
        System.out.println("Anos conhecidos: "+ ChronoUnit.YEARS.between(conhecidos, now));

        System.out.println("-------------------");
        System.out.println("Dias namorando: "+ ChronoUnit.DAYS.between(namoro, now));
        System.out.println("Semanas namorando: "+ ChronoUnit.WEEKS.between(namoro, now));
        System.out.println("Meses namorando: "+ ChronoUnit.MONTHS.between(namoro, now));
        System.out.println("Anos namorando: "+ ChronoUnit.YEARS.between(namoro, now));

    }

}
