package academy.devdojo.maratonajava.javacore.ZZFthreads.exercicios.aulas218a223;

import java.util.stream.LongStream;

class ImpressorComPausa implements Runnable {
    private final String etiqueta;
    private final int repeticoes;
    private final long pausaMs;

    public ImpressorComPausa(String etiqueta, int repeticoes, long pausaMs) {
        this.etiqueta = etiqueta;
        this.repeticoes = repeticoes;
        this.pausaMs = pausaMs;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < repeticoes ; i++) {
            System.out.println(Thread.currentThread().getName()+" "+etiqueta+" i="+ i);
            try {
                Thread.sleep(pausaMs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        // TODO RUN-IMPRESSOR:
        // - Imprima Thread.currentThread().getName() na primeira linha (foco da aula 222).
        // - Faca um loop de repeticoes iteracoes imprimindo "[<nome>] <etiqueta> i=<i>".
        // - A cada iteracao, chame Thread.sleep(pausaMs).
        // - Como Thread.sleep lanca InterruptedException, envolva em try/catch.
        // - No catch, faca e.printStackTrace().
    }
}

public class Aulas218A223Exercicio02Medio {
    public static void main(String[] args) {
        System.out.println("--- Threads nomeadas com prioridades diferentes ---");
        executarTresThreadsNomeadas();

        System.out.println("--- Benchmark stream sequencial vs paralelo (revisao 218) ---");
        long n = 5_000_000L;
        compararSequencialEParalelo(n);
    }

    private static void executarTresThreadsNomeadas() {
        ImpressorComPausa icp1 = new ImpressorComPausa("A", 5, 300);
        ImpressorComPausa icp2 = new ImpressorComPausa("B", 5, 300);
        ImpressorComPausa icp3 = new ImpressorComPausa("C", 5, 300);

        criarThreadNomeada(icp1, "T-A");
        criarThreadNomeada(icp2, "T-B");
        criarThreadNomeada(icp3, "T-C");


        Thread t1 = new Thread(icp1);
        Thread t2 = new Thread(icp2);
        Thread t3 = new Thread(icp3);

        ajustarPrioridade(t1, Thread.MAX_PRIORITY);
        ajustarPrioridade(t2, Thread.NORM_PRIORITY);
        ajustarPrioridade(t3, Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        // TODO 01:
        // Crie tres ImpressorComPausa diferentes (etiquetas "A", "B", "C"),
        // cada um com 5 repeticoes e pausa de 300ms.
        //
        // Para cada um:
        // - Use criarThreadNomeada para envolver o Runnable numa Thread com nome
        //   "T-A", "T-B" e "T-C".
        // - Use ajustarPrioridade para:
        //     T-A -> Thread.MIN_PRIORITY
        //     T-B -> Thread.NORM_PRIORITY
        //     T-C -> Thread.MAX_PRIORITY
        // - Chame .start() em cada thread.
        //
        // Observe que o sistema operacional decide a ordem real;
        // prioridade e apenas uma sugestao.
    }

    private static Thread criarThreadNomeada(Runnable runnable, String nome) {
        return new Thread(runnable,nome);
        // TODO 02:
        // Devolva uma nova Thread construida com (runnable, nome) (foco da aula 222).
    }

    private static Thread ajustarPrioridade(Thread thread, int prioridade) {
        thread.setPriority(prioridade);
        // TODO 03:
        // Use thread.setPriority(prioridade) e devolva a propria thread,
        // para permitir encadear no estilo "fluente".
        return thread;
    }

    private static void compararSequencialEParalelo(long n) {
        long sequencial = medirTempoMs(() -> {LongStream.rangeClosed(1,n).sum();});
        long paralela = medirTempoMs(() -> {LongStream.rangeClosed(1,n).parallel().sum();});

        System.out.println("sequencial: "+sequencial+" ms");
        System.out.println("paralela: "+paralela+" ms");
        // TODO 04:
        // Use medirTempoMs para cronometrar duas Runnables:
        // - Runnable sequencial: LongStream.rangeClosed(1, n).sum()
        // - Runnable paralela:   LongStream.rangeClosed(1, n).parallel().sum()
        //
        // Imprima:
        // "sequencial: <X> ms"
        // "paralela:   <Y> ms"
        //
        // O resultado da soma voce pode ignorar (basta usar como efeito colateral
        // dentro do Runnable, sem retornar nada).
    }

    private static long medirTempoMs(Runnable acao) {
        long init = System.currentTimeMillis();
        acao.run();
        long end = System.currentTimeMillis();
        return (end - init);
        // TODO 05:
        // - Marque o tempo inicial com System.currentTimeMillis().
        // - Execute acao.run().
        // - Devolva (fim - inicio).

    }
}
