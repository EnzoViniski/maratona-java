package academy.devdojo.maratonajava.javacore.ZZFthreads.exercicios.aulas218a223;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

class TrabalhadorRunnable implements Runnable {
    private final String tarefa;
    private final int passos;
    private final long pausaMs;

    public TrabalhadorRunnable(String tarefa, int passos, long pausaMs) {
        this.tarefa = tarefa;
        this.passos = passos;
        this.pausaMs = pausaMs;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " inciiando " + tarefa);
        for (int i = 0; i < passos; i++) {
            System.out.println(threadName + " passo " + i + " em " + tarefa);
            try {
                Thread.sleep(pausaMs);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(threadName + " terminou " + tarefa);
        // TODO RUN-TRABALHADOR:
        // - Capture o nome com Thread.currentThread().getName().
        // - Imprima "[<nome>] iniciando <tarefa>".
        // - Loop de passos iteracoes imprimindo "[<nome>] passo <i>/<passos> em <tarefa>".
        // - Em cada passo use Thread.sleep(pausaMs) em try/catch (InterruptedException).
        // - No catch, faca throw new RuntimeException(e) (estilo da aula 223).
        // - No final, imprima "[<nome>] terminou <tarefa>".
    }
}

public class Aulas218A223DesafioFinal {
    public static void main(String[] args) {
        long limite = 2_000_000L;

        System.out.println("=== Fluxo sequencial com join ===");
        executarFluxoSequencial();

        System.out.println("=== Fluxo paralelo com join no fim ===");
        executarFluxoParalelo();

        System.out.println("=== Soma paralela final ===");
        System.out.println("Total ate " + limite + ": " + somarAteComLongStreamParalelo(limite));

        System.out.println("=== Relatorio final ===");
        System.out.println(montarRelatorioFinal(limite));
    }

    private static Thread criarTrabalhador(String tarefa, int passos, long pausaMs,
                                           String nomeThread, int prioridade) {
        Thread t1 = new Thread(new TrabalhadorRunnable(tarefa, passos, pausaMs), nomeThread);
        t1.setPriority(prioridade);
        return t1;

        // TODO 01:
        // - Crie um TrabalhadorRunnable com (tarefa, passos, pausaMs).
        // - Envolva em new Thread(runnable, nomeThread) (foco da aula 222).
        // - Chame thread.setPriority(prioridade) e devolva a thread.
    }

    private static void iniciarEEsperar(Thread thread) {
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // TODO 02:
        // - Chame thread.start().
        // - Em seguida, chame thread.join() dentro de try/catch (InterruptedException).
        // - No catch, faca throw new RuntimeException(e).
        // Foco da aula 223: join faz a thread atual esperar a outra terminar.
    }

    private static void executarFluxoSequencial() {
        Thread t1 = criarTrabalhador("BAIXAR", 3, 200, "Thread 1", Thread.NORM_PRIORITY);
        Thread t2 = criarTrabalhador("PROCESSAR", 3, 200, "Thread 2", Thread.NORM_PRIORITY);
        Thread t3 = criarTrabalhador("SALVAR", 3, 200, "Thread 3", Thread.NORM_PRIORITY);
        iniciarEEsperar(t1);
        iniciarEEsperar(t2);
        iniciarEEsperar(t3);
        // TODO 03:
        // Crie tres threads, todas com 3 passos, pausa 200ms, prioridade Thread.NORM_PRIORITY:
        //   - "BAIXAR"
        //   - "PROCESSAR"
        //   - "SALVAR"
        //
        // Use iniciarEEsperar para cada uma, em ordem.
        // Como cada chamada bloqueia ate terminar, BAIXAR vai terminar antes de
        // PROCESSAR comecar, e assim por diante.
    }

    private static void executarFluxoParalelo() {
        List<Thread> threads = new ArrayList<>();
        Thread t1 = criarTrabalhador("LER-A", 3, 150, "Thread 4", Thread.MAX_PRIORITY);
        Thread t2 = criarTrabalhador("LER-B", 3, 150, "Thread 5", Thread.NORM_PRIORITY);
        Thread t3 = criarTrabalhador("LER-C", 3, 150, "Thread 6", Thread.MIN_PRIORITY);

        threads.add(t1);
        threads.add(t2);
        threads.add(t3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // TODO 04:
        // Crie tres threads, todas com 3 passos e pausa 150ms:
        //   - "LER-A" prioridade Thread.MAX_PRIORITY
        //   - "LER-B" prioridade Thread.NORM_PRIORITY
        //   - "LER-C" prioridade Thread.MIN_PRIORITY
        //
        // Guarde-as em uma List<Thread>.
        // Faca .start() em todas (sem join entre uma e outra).
        // Depois, faca .join() em todas dentro de try/catch (InterruptedException),
        // para esperar todas terminarem antes de retornar.
        // No catch, throw new RuntimeException(e).
    }

    private static long somarAteComLongStreamParalelo(long n) {
        LongStream.rangeClosed(1, n).parallel().sum();
        return LongStream.rangeClosed(1, n).parallel().sum();
        // TODO 05:
        // Use LongStream.rangeClosed(1, n).parallel().sum() (foco da aula 218).
    }

    private static String montarRelatorioFinal(long limite) {

        // TODO 06:
        // Monte uma String com este formato (uma linha por valor):
        //
        // processadores: <Runtime.getRuntime().availableProcessors()>
        // limite: <limite>
        // soma paralela: <somarAteComLongStreamParalelo(limite)>
        //
        // Use String.format ou um StringBuilder. Nao crie loop manual.
        // Reutilize somarAteComLongStreamParalelo.
        String processadoresString = "\nprocessadores: "+Runtime.getRuntime().availableProcessors();
        String limiteStrinf = "\nlimite: "+limite;
        String somaParalelaString = "\nsoma paralela: "+somarAteComLongStreamParalelo(limite);
        return String.format(String.join(limiteStrinf, processadoresString, somaParalelaString));
    }
}
