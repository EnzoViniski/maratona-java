package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

class ThreadExample extends Thread{
    private final char c;

    public ThreadExample(char c) {
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

class ThreadExampleRunable implements Runnable{
    private final char c;

    public ThreadExampleRunable(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        for (int i = 0; i < 500 ; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
        }
    }
}
public class Aula220_ThreadsTest01 {
    // A thread passa por estados:
    // New : quando a tread é criada -> ThreadExample t1 = new ThreadExample('A');
    // Runnable : quando a thread é startada -> t1.start();
    // Running : quando a thread esta sendo ececutada
    // Waitign/blocked : quando a thread é pausada ou bloqueada, podendo ser runnable de novo e running depois
    // Dead : quando a thread é morta, nao sendo possivel ser reutilizada, sendo necessaria a criacao de um objeto totalmente novo
    // Threads nao podem receber start mais de uma vez, se nao é lançada uma exceção
    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample('A');
        ThreadExample t2 = new ThreadExample('B');
        ThreadExample t3 = new ThreadExample('C');
        ThreadExample t4 = new ThreadExample('D');

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread tr1 = new Thread(new ThreadExampleRunable('A'));
        Thread tr2 = new Thread(new ThreadExampleRunable('B'));
        Thread tr3 = new Thread(new ThreadExampleRunable('C'));
        Thread tr4 = new Thread(new ThreadExampleRunable('D'));
        tr1.start();
        tr2.start();
        tr3.start();
        tr4.start();
    }
}
