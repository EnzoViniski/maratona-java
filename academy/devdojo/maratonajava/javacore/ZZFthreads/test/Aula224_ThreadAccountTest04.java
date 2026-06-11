package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import academy.devdojo.maratonajava.javacore.ZZFthreads.domain.Account;

public class Aula224_ThreadAccountTest04 implements Runnable{
    private Account account = new Account();
    public static void main(String[] args) {
        Aula224_ThreadAccountTest04 threadAccountTest04 = new Aula224_ThreadAccountTest04();
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
        }
    }

    private void withdrawal(int amount){
        if (account.getBalance() >= amount){
            System.out.println(getThreadName() + " irá realizar o saque");
            account.withdrawal(amount);
            System.out.println("Dinheiro sacado por "+ getThreadName()+". Valor atual :"+account.getBalance());
        } else {
            System.out.println("Dinheiro indisponível para o saque por "+ getThreadName()+" total disponivel: "+account.getBalance());
        }
    }

    private String getThreadName(){
        return Thread.currentThread().getName();
    }
}
