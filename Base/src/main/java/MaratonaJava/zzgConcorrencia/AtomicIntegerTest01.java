package MaratonaJava.zzgConcorrencia;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter{

    private int count;
    private Lock lock = new ReentrantLock(true);
    private AtomicInteger atomicInteger1 = new AtomicInteger(); //fazer contagem de forma atômica

    public AtomicInteger getAtomicInteger1() {
        return atomicInteger1;
    }

    void increment(){
        lock.lock();
        try{
            count++;
            //Using locks solves the problem. However, the performance takes a hit.
            //usar o syncronized resolve o problema, mas a performance sofre
            atomicInteger1.incrementAndGet();
        }finally {
            //lembrar de sempre destravar
            lock.unlock();
        }

    }

    public int getCount() {
        return count;
    }

}
public class AtomicIntegerTest01 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable r = () -> {
            for(int i = 0; i < 10000; i++){
                counter.increment();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    /*

    System.out.println ("Eu sou a thread X e vou esperar a thread Y terminar (se é que ela já não terminou)");
    Y.join(); // isto faz com que a thread X pare e espere até a thread Y terminar.
    System.out.println ("Eu sou a thread X e esperei até que a thread Y terminasse.");

    */

        System.out.println(counter.getAtomicInteger1());
        System.out.println(counter.getCount());
    }



}
