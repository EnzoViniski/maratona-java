package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.Objects;
import java.util.concurrent.*;

public class Aula235_LinkedTransferQueueTest01 {
//    ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("William"));
        System.out.println(tq.offer("William"));
        System.out.println(tq.offer("William", 10, TimeUnit.SECONDS));
        tq.put("DevDojo");
        if (tq.hasWaitingConsumer()){
            tq.transfer("Devdojo");
        }
        System.out.println(tq.tryTransfer("Academy"));
        System.out.println(tq.tryTransfer("Academy", 5, TimeUnit.SECONDS));
        System.out.println(tq.element()); // Retrieves, but does not remove, the head of this queue. This method differs from peek only in that it throws an exception if this queue is empty.
        System.out.println(tq.peek()); // Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        System.out.println(tq.poll()); // Retrieves and removes the head of this queue, or returns null if this queue is empty.
        System.out.println(tq.remove()); // Retrieves and removes the head of this queue. This method differs from poll() only in that it throws an exception if this queue is empty.
        System.out.println(tq.take()); // Retrieves and removes the head of this queue, waiting if necessary until an element becomes available.
        System.out.println(tq.remainingCapacity());
    }
}
