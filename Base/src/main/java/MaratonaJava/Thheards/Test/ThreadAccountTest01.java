package MaratonaJava.Thheards.Test;

import MaratonaJava.Thheards.dominio.Account;

public class ThreadAccountTest01 implements Runnable {
    private final Account account  =new Account();

    public static void main(String[] args) {

        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();

        Thread t1 = new Thread(threadAccountTest01,"kane");
        Thread t2 = new Thread(threadAccountTest01,"citizen");


        t1.start();
        t2.start();



    }



    @Override
    public void run() {
        for(int i=0;i<5;i++){
            withDrawl(10);
            if(account.getBalance()<0){
                System.out.println("fodeo");
            }
        }
    }
    // synchronized significa que duas threads não podem acessar esse method ao mesmo tempo
    //não existirá paralelismo

    private static void print(){
        //uma classe também pode ser sincronizada

        synchronized (ThreadAccountTest01.class){

        }
    }


    private void withDrawl(int amount){

        System.out.println(getThreadName()+"  fora do sincronized");

        //é frequentemente usado em blocos de código que precisam ser executados de maneira atomica
        synchronized (account){
            System.out.println(getThreadName()+"  dentro do sincronized");

            if(account.getBalance() >= amount){
                System.out.println(getThreadName() +"  indo saca dinheiro");
                account.withdrawl(amount);
                System.out.println(getThreadName() +"  completou o saque, valor atual  "+account.getBalance());

            }else{
                System.out.println("não tem dinheiro para " + getThreadName() + account.getBalance());
            }

        }



    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }


}
