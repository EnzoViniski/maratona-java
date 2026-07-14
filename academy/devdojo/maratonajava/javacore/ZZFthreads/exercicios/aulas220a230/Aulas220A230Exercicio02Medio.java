package academy.devdojo.maratonajava.javacore.ZZFthreads.exercicios.aulas220a230;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class ContaDaGuilda {
    private int saldo = 100;

    public int getSaldo() {
        return saldo;
    }

    public void sacar(int valor) {
        saldo = saldo - valor;
    }
}

class AventureiroSacador implements Runnable {
    private final ContaDaGuilda conta;

    public AventureiroSacador(ContaDaGuilda conta) {
        this.conta = conta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sacarComSeguranca(20);
        }
        if (conta.getSaldo() < 0) {
            System.out.println("BUG: saldo ficou negativo -> " + conta.getSaldo());
        }
    }

    private void sacarComSeguranca(int valor) {
        System.out.println(nomeDaThread() + " ##### esta fora do bloco synchronized");
        // TODO 01:
        // Reproduza o padrao da aula 225 (check-then-act protegido):
        // - Abra um bloco synchronized usando a conta como lock: synchronized (conta) { ... }
        // - Dentro do bloco, imprima nomeDaThread() + " ***** esta dentro do bloco synchronized".
        // - Se conta.getSaldo() >= valor:
        //     imprima que vai realizar o saque, chame conta.sacar(valor)
        //     e imprima o saldo atual com conta.getSaldo().
        //   Senao:
        //     imprima que nao tem saldo disponivel, mostrando conta.getSaldo().
        //
        // Sem o synchronized, as duas threads podem passar JUNTAS pelo if antes de
        // qualquer uma sacar, e o saldo fica negativo (race condition da aula 224).
    }

    private String nomeDaThread() {
        return Thread.currentThread().getName();
    }
}

class QuadroDeMissoes {
    private final List<String> missoes = new ArrayList<>();

    public void adicionar(String missao) {
        // TODO 02:
        // Aula 226: deixe este metodo thread-safe colocando synchronized na assinatura.
        // Depois, adicione a missao na lista.
    }

    public String removerPrimeira() {
        // TODO 03:
        // Aula 226: tambem coloque synchronized na assinatura.
        // - Se a lista nao estiver vazia:
        //     imprima Thread.currentThread().getName() e devolva missoes.remove(0).
        // - Se estiver vazia, devolva null (sem excecao).
        return null;
    }

    public int tamanho() {
        // TODO 04:
        // synchronized na assinatura e devolva missoes.size().
        return 0;
    }
}

class ImpressoraDaGuilda {
    private final ReentrantLock lock = new ReentrantLock();

    public void imprimir(String documento) {
        // TODO 05:
        // Aula 230: secao critica com ReentrantLock.
        // - Chame lock.lock() ANTES do bloco try.
        // - No try:
        //     imprima "<nome da thread> entrou na sessao critica para imprimir <documento>"
        //     imprima lock.getQueueLength() + " threads esperando na fila"
        //     chame Thread.sleep(500) para simular a impressao
        //     imprima "<nome da thread> terminou de imprimir <documento>"
        // - Trate a InterruptedException no catch com e.printStackTrace().
        // - No finally, OBRIGATORIAMENTE chame lock.unlock().
        //   Sem o unlock no finally, qualquer excecao deixaria o lock preso para sempre.
    }
}

public class Aulas220A230Exercicio02Medio {
    public static void main(String[] args) {
        System.out.println("--- Parte 1: saque concorrente protegido com synchronized (224/225) ---");
        executarSaquesConcorrentes();

        System.out.println("--- Parte 2: colecao thread-safe com metodos synchronized (226) ---");
        executarQuadroDeMissoes();

        System.out.println("--- Parte 3: impressora compartilhada com ReentrantLock (230) ---");
        executarImpressoes();
    }

    private static void executarSaquesConcorrentes() {
        ContaDaGuilda conta = new ContaDaGuilda();
        AventureiroSacador sacador = new AventureiroSacador(conta);
        // TODO 06:
        // - Crie DUAS threads com o MESMO sacador, nomeadas "Ais" e "Lefiya" (aula 222).
        // - Inicie as duas com .start().
        // - Use .join() nas duas, em try/catch (InterruptedException);
        //   no catch, throw new RuntimeException(e).
        // - Depois dos joins, imprima "saldo final: " + conta.getSaldo().
        //   Com o TODO 01 correto, o saldo termina em 0 e nunca negativo.
    }

    private static void executarQuadroDeMissoes() {
        QuadroDeMissoes quadro = new QuadroDeMissoes();
        quadro.adicionar("Derrotar o minotauro");
        // TODO 07:
        // Aula 226: repare que existe UMA unica missao no quadro.
        // - Crie um Runnable com method reference: quadro::removerPrimeira.
        // - Crie DUAS threads com esse mesmo Runnable e inicie as duas.
        // - Use .join() nas duas (try/catch InterruptedException,
        //   throw new RuntimeException(e)) antes de seguir para a Parte 3.
        // - Como removerPrimeira e synchronized, so uma thread remove a missao;
        //   a outra encontra o quadro vazio e recebe null, sem lancar excecao.
        // - Para fechar, imprima "missoes restantes: " + quadro.tamanho().
    }

    private static void executarImpressoes() {
        ImpressoraDaGuilda impressora = new ImpressoraDaGuilda();
        // TODO 08:
        // - Crie QUATRO threads, cada uma imprimindo um documento diferente
        //   ("Relatorio-1" a "Relatorio-4") na MESMA impressora.
        //   Dica: new Thread(() -> impressora.imprimir("Relatorio-1"), "Familia-1")
        // - De nomes as threads ("Familia-1" a "Familia-4") e de a primeira
        //   prioridade Thread.MAX_PRIORITY (revisao da aula 222).
        // - Inicie todas SEM join entre uma e outra, e observe na saida o
        //   getQueueLength variando conforme as threads entram na fila do lock.
    }
}
