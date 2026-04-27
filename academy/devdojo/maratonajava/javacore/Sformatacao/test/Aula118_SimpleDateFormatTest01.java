package academy.devdojo.maratonajava.javacore.Sformatacao.test;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aula118_SimpleDateFormatTest01 {
    public static void main(String[] args) {
        String dataString = "25/03/2026";
        // Define o formato esperado da String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Converte a String para LocalDate
        LocalDate data = LocalDate.parse(dataString, formatter);

        System.out.println(data); // Saída: 2026-03-25
    }
}
