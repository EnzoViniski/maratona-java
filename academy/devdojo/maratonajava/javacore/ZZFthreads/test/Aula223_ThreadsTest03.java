package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

class ThreadExample3 extends Thread{
    private final char c;

    public ThreadExample3(char c) {
        this.c = c;
    }

    @Override
    public void start() {
        System.out.println(Thread.currentThread());
        for (int i = 0; i < 500 ; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
        }
    }
}

class ThreadExampleRunable3 implements Runnable{
    private final String c;

    public ThreadExampleRunable3(String c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500 ; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Aula223_ThreadsTest03 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadExampleRunable3("KA"));
        Thread t2 = new Thread(new ThreadExampleRunable3("ME"));

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }
}
