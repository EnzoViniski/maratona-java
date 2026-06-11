package academy.devdojo.maratonajava.javacore.ZZFthreads.exercicios.aulas218a223;

import java.util.stream.LongStream;
import java.util.stream.Stream;

class ContadorThread extends Thread {
    private final char letra;
    private final int repeticoes;

    public ContadorThread(char letra, int repeticoes) {
        this.letra = letra;
        this.repeticoes = repeticoes;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        for (int i = 0; i < repeticoes; i++) {
            System.out.print(letra);
            if (i % 50 == 0){
                System.out.println();
            }
        }
        // TODO RUN-THREAD:
        // Cuidado: aqui voce deve sobrescrever run(), nao start().
        // Se voce sobrescrever start(), o codigo roda na thread main e nao cria thread nova.
        //
        // Passos:
        // - Imprima Thread.currentThread() para confirmar que esta numa thread separada.
        // - Faca um loop de repeticoes iteracoes imprimindo a letra com System.out.print.
        // - A cada 50 caracteres, chame System.out.println() para quebrar linha.
    }
}

class ContadorRunnable implements Runnable {
    private final char letra;
    private final int repeticoes;

    public ContadorRunnable(char letra, int repeticoes) {
        this.letra = letra;
        this.repeticoes = repeticoes;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        for (int i = 0; i < repeticoes; i++) {
            System.out.print(letra);
            if (i % 50 == 0){
                System.out.println();
            }
        }
        // TODO RUN-RUNNABLE:
        // Mesma logica do ContadorThread, mas agora dentro de um Runnable.
        // - Imprima Thread.currentThread() na primeira linha.
        // - Loop de repeticoes imprimindo a letra; quebre linha a cada 50.
    }
}

public class Aulas218A223Exercicio01Facil {
    public static void main(String[] args) {
        System.out.println("--- Threads via extends Thread ---");
        dispararThreadsViaExtends();

        System.out.println("--- Threads via Runnable ---");
        dispararThreadsViaRunnable();

        System.out.println("--- Revisao aula 218: streams paralelas ---");
        long n = 1_000_000L;
        System.out.println("Soma sequencial com LongStream: " + somarSequencialComLongStream(n));
        System.out.println("Soma paralela com LongStream:   " + somarParaleloComLongStream(n));
        System.out.println("Soma com Stream.iterate paralela: " + somarComStreamIterateParalelo(n));
    }

    private static void dispararThreadsViaExtends() {
        ContadorThread c1 = new ContadorThread('A', 200);
        ContadorThread c2 = new ContadorThread('B', 200);
        ContadorThread c3 = new ContadorThread('C', 200);
        c1.start();
        c2.start();
        c3.start();
        // TODO 01:
        // Crie tres ContadorThread (letras 'A', 'B', 'C'), cada uma com 200 repeticoes.
        // Chame .start() em cada uma.
        // ATENCAO: NAO chame .run() diretamente, pois isso nao cria thread nova.
    }

    private static void dispararThreadsViaRunnable() {
        Thread cr1 = new Thread(new ContadorRunnable('X', 200));
        Thread cr2 = new Thread(new ContadorRunnable('Y', 200));
        Thread cr3 = new Thread(new ContadorRunnable('Z', 200));
        cr1.run();
        cr2.run();
        cr3.run();
        // TODO 02:
        // Crie tres ContadorRunnable (letras 'X', 'Y', 'Z'), cada um com 200 repeticoes.
        // Envolva cada um em uma new Thread(runnable) e chame .start().
    }

    private static long somarSequencialComLongStream(long n) {
        return LongStream.range(1,n).sum();
        // TODO 03:
        // Use LongStream.rangeClosed(1, n).sum() para somar de 1 ate n.
        // Aqui voce esta revisando a aula 218, lado sequencial.
    }

    private static long somarParaleloComLongStream(long n) {
        return LongStream.rangeClosed(1,n).parallel().sum();
        // TODO 04:
        // Use LongStream.rangeClosed(1, n).parallel().sum().
        // Compare mentalmente o resultado e o tempo com somarSequencialComLongStream.
    }

    private static long somarComStreamIterateParalelo(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
        // TODO 05:
        // Use Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum).
        // Observacao da aula 218: esta versao tende a ser mais lenta por causa de boxing/unboxing.
    }
}
