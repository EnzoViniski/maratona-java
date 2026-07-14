package academy.devdojo.maratonajava.javacore.ZZFthreads.exercicios.aulas220a230;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class BalcaoDePedidos {
    private final Queue<String> pedidos = new ArrayBlockingQueue<>(10);
    private boolean aberto = true;

    public boolean isAberto() {
        return aberto;
    }

    public int pedidosPendentes() {
        // TODO 01:
        // Igual ao pendingEmails do Members (aula 228):
        // dentro de um synchronized (pedidos), devolva pedidos.size().
        return 0;
    }

    public void adicionarPedido(String pedido) {
        // TODO 02:
        // Padrao PRODUTOR da aula 228:
        // - Abra um bloco synchronized (this.pedidos) { ... }
        // - Dentro dele:
        //     imprima Thread.currentThread().getName() + " anotou o pedido " + pedido
        //     adicione o pedido na fila
        //     chame this.pedidos.notifyAll() para acordar cozinheiros em wait().
    }

    public String retirarPedido() throws InterruptedException {
        // TODO 03:
        // Padrao CONSUMIDOR da aula 228:
        // - Imprima Thread.currentThread().getName() + " verificando se tem pedidos".
        // - Abra um bloco synchronized (this.pedidos) { ... }
        // - Dentro dele, ENQUANTO a fila estiver vazia (use while, nunca if):
        //     - se o balcao nao estiver mais aberto, devolva null;
        //     - imprima que nao tem pedido disponivel e que vai entrar em espera,
        //       e chame this.pedidos.wait().
        // - Saiu do while = tem pedido: devolva this.pedidos.poll().
        //
        // O wait() solta o lock e dorme; quando alguem chama notifyAll(), a thread
        // acorda, pega o lock de volta e testa o while de novo.
        return null;
    }

    public void fechar() {
        this.aberto = false;
        // TODO 04:
        // - Abra um bloco synchronized (this.pedidos) { ... } e, dentro dele,
        //   imprima que o balcao fechou e chame this.pedidos.notifyAll().
        //
        // Sem esse notifyAll, um cozinheiro que estiver em wait() dorme para sempre
        // e o programa nunca termina. Compare com o close() do seu Members da aula
        // 228 e repare o que esta faltando la.
    }
}

class Cozinheiro implements Runnable {
    private final BalcaoDePedidos balcao;
    private final AtomicInteger pratosProntos;

    public Cozinheiro(BalcaoDePedidos balcao, AtomicInteger pratosProntos) {
        this.balcao = balcao;
        this.pratosProntos = pratosProntos;
    }

    @Override
    public void run() {
        // TODO RUN-COZINHEIRO:
        // Mesma estrutura do EmailDeliveryService (aula 228):
        // - Capture o nome da thread e imprima "<nome> comecou o turno na cozinha".
        // - while (balcao.isAberto() || balcao.pedidosPendentes() > 0):
        //     - chame balcao.retirarPedido() dentro de try/catch (InterruptedException);
        //       no catch, faca e.printStackTrace().
        //     - se o pedido vier null, use continue.
        //     - imprima "<nome> preparando <pedido>", durma 500ms (Thread.sleep),
        //       e imprima "<nome> finalizou <pedido>".
        //     - registre o prato com pratosProntos.incrementAndGet() (aula 229).
        // - Depois do while, imprima "<nome> encerrou o turno".
        //
        // ATENCAO: so rode este arquivo depois de resolver os TODOs 01 a 04 do
        // BalcaoDePedidos, senao o while pode virar um loop infinito.
    }
}

class EquipeDeLimpeza {
    private final Object pia = new Object();
    private final Object fogao = new Object();

    public void limpar(String nomeFaxineiro) {
        // TODO 05:
        // A aula 227 mostrou que pegar dois locks em ORDENS DIFERENTES causa deadlock.
        // A correcao: todo mundo pega os locks NA MESMA ORDEM (primeiro pia, depois fogao).
        // - synchronized (pia):
        //     imprima nomeFaxineiro + ": segurando a pia"
        //     synchronized (fogao):
        //         imprima nomeFaxineiro + ": segurando o fogao, limpeza concluida"
        //
        // Experimento (depois de tudo funcionando): inverta a ordem dos locks em um
        // dos faxineiros do TODO 08 criando um segundo metodo, rode varias vezes e
        // veja o programa travar como na aula 227. Depois desfaca.
    }
}

public class Aulas220A230DesafioFinal {
    private static final String[] CARDAPIO = {"Lamen", "Dango", "Onigiri", "Yakisoba", "Taiyaki", "Curry"};

    public static void main(String[] args) {
        BalcaoDePedidos balcao = new BalcaoDePedidos();
        AtomicInteger pratosProntos = new AtomicInteger();

        System.out.println("=== Abrindo a taverna ===");
        Thread souma = new Thread(new Cozinheiro(balcao, pratosProntos), "Souma");
        Thread sanji = new Thread(new Cozinheiro(balcao, pratosProntos), "Sanji");
        souma.start();
        sanji.start();

        anotarPedidosDoCardapio(balcao);
        balcao.fechar();

        // TODO 06:
        // - Use .join() nas threads souma e sanji, em try/catch (InterruptedException);
        //   no catch, throw new RuntimeException(e).
        // - Revisao da aula 223: sem esses joins, o relatorio final sai antes de a
        //   cozinha terminar e o numero de pratos prontos vem errado.

        System.out.println("=== Limpeza sem deadlock (227) ===");
        executarLimpezaConcorrente();

        System.out.println("=== Relatorio final ===");
        System.out.println("pedidos anotados: " + CARDAPIO.length);
        System.out.println("pratos prontos:   " + pratosProntos.get());
    }

    private static void anotarPedidosDoCardapio(BalcaoDePedidos balcao) {
        // TODO 07:
        // O main faz o papel de PRODUTOR (no lugar do JOptionPane da aula 228):
        // - Para cada item de CARDAPIO (use for-each), chame balcao.adicionarPedido(item)
        //   e durma 200ms entre um pedido e outro com Thread.sleep, em try/catch
        //   (InterruptedException); no catch, throw new RuntimeException(e).
        // - A pausa da tempo de os cozinheiros esvaziarem a fila e entrarem em wait(),
        //   forcando o notifyAll do TODO 02 a trabalhar.
    }

    private static void executarLimpezaConcorrente() {
        EquipeDeLimpeza equipe = new EquipeDeLimpeza();
        // TODO 08:
        // - Crie dois Runnables com lambda: um chamando equipe.limpar("Faxineiro-1")
        //   e outro chamando equipe.limpar("Faxineiro-2").
        // - Crie as duas threads, inicie as duas e use .join() nas duas
        //   (try/catch InterruptedException, throw new RuntimeException(e)).
        // - Como limpar() pega os locks sempre na mesma ordem, as duas threads
        //   disputam a pia mas nunca travam em deadlock.
    }
}
