package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import academy.devdojo.maratonajava.javacore.ZZFthreads.domain.Account;

public class Aula225_ThreadAccountTest05 implements Runnable{
    private Account account = new Account();
    public static void main(String[] args) {
        Aula225_ThreadAccountTest05 threadAccountTest04 = new Aula225_ThreadAccountTest05();
        Thread t1 = new Thread(threadAccountTest04, "Hestia");
        Thread t2 = new Thread(threadAccountTest04, "Bell Cranel");
        t1.start();
        t2.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Fodeo");
            }
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }

    // synchronized pode ser usado na assinatura do método ou em bloco especifico de código, e serve para dizer "jvm, pergunte se existe alguma thread realizando aquilo, se sim entao deixa ela, senao entao comece a fazer
    private void withdrawal(int amount){
        System.out.println(getThreadName() + " ##### esta fora do synchronized");
        synchronized (account) {
            System.out.println(getThreadName() + " ***** esta dentro do synchronized");
            if (account.getBalance() >= amount) {
                System.out.println(getThreadName() + " irá realizar o saque");
                account.withdrawal(amount);
                System.out.println("Dinheiro sacado por " + getThreadName() + ". Valor atual :" + account.getBalance());
            } else {
                System.out.println("Dinheiro indisponível para o saque por " + getThreadName() + " total disponivel: " + account.getBalance());
            }
        }
    }

    private String getThreadName(){
        return Thread.currentThread().getName();
    }
}
