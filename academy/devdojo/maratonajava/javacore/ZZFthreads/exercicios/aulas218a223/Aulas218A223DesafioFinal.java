package academy.devdojo.maratonajava.javacore.ZZFthreads.exercicios.aulas218a223;

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
        // TODO 01:
        // - Crie um TrabalhadorRunnable com (tarefa, passos, pausaMs).
        // - Envolva em new Thread(runnable, nomeThread) (foco da aula 222).
        // - Chame thread.setPriority(prioridade) e devolva a thread.
        return new Thread(() -> {});
    }

    private static void iniciarEEsperar(Thread thread) {
        // TODO 02:
        // - Chame thread.start().
        // - Em seguida, chame thread.join() dentro de try/catch (InterruptedException).
        // - No catch, faca throw new RuntimeException(e).
        // Foco da aula 223: join faz a thread atual esperar a outra terminar.
    }

    private static void executarFluxoSequencial() {
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
        // TODO 05:
        // Use LongStream.rangeClosed(1, n).parallel().sum() (foco da aula 218).
        return 0;
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
        return "";
    }
}
