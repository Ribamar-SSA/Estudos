package MaratonaJava.zzgConcorrencia;

import java.util.concurrent.locks.ReentrantLock;

class Worker2 implements Runnable {
    private String name;
    private ReentrantLock lock;

    public Worker2(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        //Acquires the lock only if it is not held by another thread at the time of invocation.
        lock.tryLock();
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
            //ocorre uma exceção porque ele tenta desbloquear o que ele pode não ter o lock
            //vide : if(lock.isHeldByCurrentThread())
            lock.unlock();
        }
    }


}

public class ReentrantLockTest02{
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(new Worker2("t1",reentrantLock)).start();
        new Thread(new Worker2("t2",reentrantLock)).start();
        new Thread(new Worker2("t3",reentrantLock)).start();
        new Thread(new Worker2("t4",reentrantLock)).start();
        new Thread(new Worker2("t5",reentrantLock)).start();
        new Thread(new Worker2("t6",reentrantLock)).start();
        new Thread(new Worker2("t7",reentrantLock)).start();
        new Thread(new Worker2("t8",reentrantLock)).start();
        new Thread(new Worker2("t9",reentrantLock)).start();


    }
}
