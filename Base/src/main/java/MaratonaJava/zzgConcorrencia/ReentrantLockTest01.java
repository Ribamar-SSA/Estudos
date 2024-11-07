package MaratonaJava.zzgConcorrencia;

import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable {
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {

            //pergunta se o lock é guardado pela thread atual
            if(lock.isHeldByCurrentThread()){
                System.out.printf("thread %s entrou em uma sessão critica%n",name);
            }

            //Returns an estimate of the number of threads waiting to acquire this lock
            System.out.printf("%d Threads esperando na fila%n",lock.getQueueLength());

            System.out.printf("%s vai esperar 2 segundos%n",name);
            Thread.sleep(2000);
            System.out.printf("%s finalizou a espera%n",name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }


}

public class ReentrantLockTest01{
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(new Worker("t1",reentrantLock)).start();
        new Thread(new Worker("t2",reentrantLock)).start();
        new Thread(new Worker("t3",reentrantLock)).start();
        new Thread(new Worker("t4",reentrantLock)).start();
        new Thread(new Worker("t5",reentrantLock)).start();
        new Thread(new Worker("t6",reentrantLock)).start();
        new Thread(new Worker("t7",reentrantLock)).start();
        new Thread(new Worker("t8",reentrantLock)).start();
        new Thread(new Worker("t9",reentrantLock)).start();


    }
}
