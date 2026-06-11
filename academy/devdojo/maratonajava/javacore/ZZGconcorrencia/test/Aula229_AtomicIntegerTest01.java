package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;

class Counter{
    private int count;
    private AtomicInteger atomicInteger =  new AtomicInteger();

    void increment(){
        count++; // nao será o ideal pois as threads trabalham de forma concorrente, assim, a contagem não será exata pois o numero pode se perder em variaveis ou outras situacoes. Uma solucao seria utilizar o synchronized porem a velocidade seria afetada
        atomicInteger.incrementAndGet(); // nessa solução, sera sempre realizada a conta com a incrementação seguida do "recolhimento" do número, fazendo com que nenhum valor se perca no meio
    }

    public int getCount() {
        return count;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}
public class Aula229_AtomicIntegerTest01 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable r = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
        System.out.println(counter.getAtomicInteger());
    }
}
