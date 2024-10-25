package MaratonaJava.Thheards.Test;
//threads do tipo daemon e threads do tipo user
//o java encerra o programa quando todas as threads ddo tipo user são encerradas


//class ThreadExemplo extends  Thread {
//    private char c;
//
//    public ThreadExemplo(char c) {
//        this.c = c;
//    }
//
//    public void run(){
//        System.out.println(Thread.currentThread().getName());
//        for(int i=0;i<500;i++){
//            System.out.print(c);
//            if(i%100==0){
//                System.out.println();
//            }
//        }
//    }
//}

//o jeito correto de trabalhar com thread é implementando o Runnable
class ThreadExampleRunnable implements Runnable{
    private final char c;

    ThreadExampleRunnable(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i < 500; i++){
            System.out.print(c);
            if(i % 100 == 0){
                System.out.println();
            }

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}


public class ThreadTest01 {
    public static void main(String[] args) {
        //System.out.println(Thread.currentThread().getName());
//        ThreadExemplo t1 = new ThreadExemplo('A');
//        ThreadExemplo t2 = new ThreadExemplo('B');
//        ThreadExemplo t3 = new ThreadExemplo('C');
//        ThreadExemplo t4 = new ThreadExemplo('D');


        Thread t1 = new Thread(new ThreadExampleRunnable('C'),"T1A");
        Thread t2 = new Thread(new ThreadExampleRunnable('A'),"T2B");
        Thread t3 = new Thread(new ThreadExampleRunnable('E'),"T3c");
        Thread t4 = new Thread(new ThreadExampleRunnable('F'),"T4d");

        //não é garantido que essa indicação será realizada
        t4.setPriority(Thread.MAX_PRIORITY);


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
