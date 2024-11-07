package MaratonaJava.zzgConcorrencia.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true; //chave para abrir ou fechar a classe
    private final ReentrantLock lock = new ReentrantLock();
    //fazer o wait, notify e notifyAll
    private final Condition condition = lock.newCondition();


    public boolean isOpen(){
        return open;
    }

    public int pendingEmails(){
        lock.lock();
        try{
            return emails.size();
        }finally{
            lock.unlock();
        }

    }

    public void addMemberEmail(String email) throws InterruptedException {
        lock.lock();
        //lock.tryLock(2, TimeUnit.SECONDS);
        try{
            //nome thread atual
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " adicionou email na lista");
            this.emails.add(email);


            //this.emails.notifyAll(); //acorda as thread que estavam em espera

            condition.signalAll();//Wakes up all waiting threads
        }finally {
            lock.unlock();
        }

    }

    public String retrievelEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");
        lock.lock();
        try{

            while(this.emails.isEmpty()){//se não tiver emails
                if(!open){
                    return null;
                }
                System.out.println(Thread.currentThread().getName() + " não tem email disponível na lista");
                System.out.println(Thread.currentThread().getName() + " esperando");
                condition.await();//Causes the current thread to wait until it is signalled or interrupted.
            }
        }finally {
            lock.unlock();
        }
        return this.emails.poll();

    }

    public void close(){
        open = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " avisando que  não estamos mais pegando emails");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

}
