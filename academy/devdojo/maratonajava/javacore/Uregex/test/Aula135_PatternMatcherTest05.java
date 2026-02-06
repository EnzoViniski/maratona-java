package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aula135_PatternMatcherTest05 {
    public static void main(String[] args) {
        // \d = Todos os dígitos
        // \D = Tudo o que não for dígito
        // \s = Espaços em branco \t \n \f \r
        // \S = Todos os caracteres excluindo brancos
        // \w = a-ZA-Z, dígitos, _
        // \W = Tudo o que não for incluso no \w
        // []
        // ? = Zero ou uma
        // * = Zero ou mais
        // + = uma ou mais
        // {n,m} = de n até m
        // () = agrupamento
        // | = ou
        // o(v|c)o --> ovo | oco
        // $ = fim da linha
        // . 1.3 = 123, 133, 1@3, 1A3
        // ^ ou [^]


        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String texto = "andre@gmail.com, ayme@hotmail.com, devdojo@maratonajava.com, teste@mail, @#!teste@mail.br, teste2@gmail.com.br";
        System.out.println("Email valido");
        System.out.println("teste@mail.br".matches(regex));
        System.out.println(Arrays.toString(texto.split(",")));
        System.out.println(texto.split(",")[1].trim());
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:   "+texto);
        System.out.println("indice:  0123456789");
        System.out.println("regex: "+regex);
        System.out.println("Posicoes encontradas");
        while (matcher.find()){
            System.out.print(matcher.start()+" "+matcher.group()+"\n");
        }
        int numeroHex = 0xFABACA;
        System.out.println(numeroHex);
    }
}
