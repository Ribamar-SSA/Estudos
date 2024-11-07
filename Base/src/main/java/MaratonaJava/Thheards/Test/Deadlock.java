package MaratonaJava.Thheards.Test;

public class Deadlock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        //exemplo de deadlock
        Runnable r1 = () -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Segurando lock 1");
                System.out.println("Thread 1: Segurando lock 2");

                synchronized (lock2) {
                    System.out.println("Thread 1: Segurando lock 2");
                }

            }
        };
        Runnable r2 = () -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Segurando lock 2");
                System.out.println("Thread 2: Segurando lock 1");

                synchronized (lock1) {
                    System.out.println("Thread 2: Segurando lock 1");
                }

            }
        };

        new Thread(r2).start();
        new Thread(r1).start();


    }
}
