package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

class ThreadExample2 extends Thread{
    private final char c;

    public ThreadExample2(char c) {
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

class ThreadExampleRunable2 implements Runnable{
    private final char c;

    public ThreadExampleRunable2(char c) {
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
                e.printStackTrace();
            }
        }
    }
}
public class Aula222_ThreadsTest02 {
    public static void main(String[] args) {
        Thread tr1 = new Thread(new ThreadExampleRunable2('A'), "T1A");
        Thread tr2 = new Thread(new ThreadExampleRunable2('B'), "T2B");
        Thread tr3 = new Thread(new ThreadExampleRunable2('C'), "T3C");
        Thread tr4 = new Thread(new ThreadExampleRunable2('D'), "T4D");
        tr4.setPriority(Thread.MAX_PRIORITY);
        tr1.start();
        tr2.start();
        tr3.start();
        tr4.start();
    }
}
