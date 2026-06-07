package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.domain.Promotion;

import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Aula218_StreamTest16 {
    // Para utilizar devemos fazer benchmarks e ver qual tem melhor performance
    // Verificar se esta tendo Unboxing ou boxing demais, aumentando o processamento
    // Verificar quantidade de dados e custo total de computação
    // Verificar os tipos de coleções, algumas podem nao valer a pena
    // Verificar se stream tem tamanho definido (o contrario pode nao valer a pena usar parallel
    // verificar o tamanho do processamento do merge
    // No stream parallel ele divide uma tarefa grande em duas, depois vai dividindo em duas ate que as tarefas sejam pequenas e nao possam ser divididas, entao resolve todas e vai mergeando os resultados ate chegar no resultado final, se esse processamneto for muito pesado pode nao valer a pena
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long num = 10_000_000;
        sumFor(num);
        streamIterateSum(num);
        streamIterateParallelSum(num);
        longStreamIteratelSum(num);
        longStreamIterateParallelSum(num);

    }

    private static void sumFor(long num){
        System.out.println("Sum for:");
        long result = 0;
        long init = System.currentTimeMillis();
        for (int i = 1; i <= num; i++){
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) +" ms");
    }

    private static void streamIterateSum(long num){
        System.out.println("Sum streamIterateSum:");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) +" ms");
    }

    private static void streamIterateParallelSum(long num){
        System.out.println("Sum streamIterateParallelSum:");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) +" ms");
    }

    private static void longStreamIteratelSum(long num){
        System.out.println("Sum longStreamIterateParallelSum:");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) +" ms");
    }

    private static void longStreamIterateParallelSum(long num){
        System.out.println("Sum longStreamIterateParallelSum:");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) +" ms");
    }

}
