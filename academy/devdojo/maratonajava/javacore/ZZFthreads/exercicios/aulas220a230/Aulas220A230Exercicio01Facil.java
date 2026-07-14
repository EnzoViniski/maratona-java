package academy.devdojo.maratonajava.javacore.ZZFthreads.exercicios.aulas220a230;

import java.util.concurrent.atomic.AtomicInteger;

class ContadorDeIngressos {
    private int vendasSemProtecao;
    private int vendasComSynchronized;
    private final AtomicInteger vendasComAtomic = new AtomicInteger();

    // Este metodo fica pronto de proposito: e o jeito ERRADO visto na aula 229.
    // Duas threads fazendo ++ ao mesmo tempo perdem incrementos (race condition).
    public void venderSemProtecao() {
        vendasSemProtecao++;
    }

    public void venderComSynchronized() {
        // TODO 01:
        // Aulas 225/229: deixe este metodo thread-safe SEM usar AtomicInteger.
        // - Adicione o modificador synchronized na assinatura do metodo.
        // - Incremente vendasComSynchronized.
        // Funciona, mas tem custo: as threads entram em fila para executar aqui.
    }

    public void venderComAtomic() {
        // TODO 02:
        // Aula 229: incremente usando vendasComAtomic.incrementAndGet().
        // Nada de synchronized aqui: a classe atomica garante a contagem sozinha.
    }

    public int getVendasSemProtecao() {
        return vendasSemProtecao;
    }

    public int getVendasComSynchronized() {
        return vendasComSynchronized;
    }

    public int getVendasComAtomic() {
        // TODO 03:
        // Devolva o valor atual usando vendasComAtomic.get().
        return 0;
    }
}

class VendedorThread extends Thread {
    private final ContadorDeIngressos contador;
    private final int quantidade;

    public VendedorThread(ContadorDeIngressos contador, int quantidade) {
        this.contador = contador;
        this.quantidade = quantidade;
    }

    @Override
    public void run() {
        // TODO RUN-THREAD:
        // Revisao da aula 220: ao estender Thread, sobrescreva run(), NUNCA start().
        // - Imprima Thread.currentThread().getName() + " comecou a vender".
        // - Faca um loop de quantidade iteracoes chamando, em cada volta:
        //     contador.venderSemProtecao();
        //     contador.venderComSynchronized();
        //     contador.venderComAtomic();
        // - No final, imprima Thread.currentThread().getName() + " terminou".
    }
}

class VendedorRunnable implements Runnable {
    private final ContadorDeIngressos contador;
    private final int quantidade;

    public VendedorRunnable(ContadorDeIngressos contador, int quantidade) {
        this.contador = contador;
        this.quantidade = quantidade;
    }

    @Override
    public void run() {
        // TODO RUN-RUNNABLE:
        // Revisao da aula 220: mesma logica do VendedorThread, agora num Runnable.
        // - Imprima o nome da thread + " comecou a vender".
        // - Loop de quantidade iteracoes chamando os tres metodos vender do contador.
        // - Imprima o nome da thread + " terminou" no final.
    }
}

public class Aulas220A230Exercicio01Facil {
    public static void main(String[] args) {
        ContadorDeIngressos contador = new ContadorDeIngressos();
        int vendasPorVendedor = 100_000;

        VendedorThread vendedor1 = new VendedorThread(contador, vendasPorVendedor);
        vendedor1.setName("Vendedor-1");
        Thread vendedor2 = new Thread(new VendedorRunnable(contador, vendasPorVendedor), "Vendedor-2");

        // TODO 04:
        // - Inicie os dois vendedores com .start() (chamar .run() NAO cria thread nova).
        // - Use .join() nos dois, dentro de try/catch (InterruptedException),
        //   para o main so imprimir o placar depois que os dois terminarem (aula 223).
        // - No catch, faca throw new RuntimeException(e).

        int esperado = vendasPorVendedor * 2;
        System.out.println("--- Placar final ---");
        System.out.println("esperado:          " + esperado);
        System.out.println("sem protecao:      " + contador.getVendasSemProtecao()
                + " <- tende a vir menor (race condition das aulas 224/229)");
        System.out.println("com synchronized:  " + contador.getVendasComSynchronized());
        System.out.println("com AtomicInteger: " + contador.getVendasComAtomic());
    }
}
