package MaratonaJava.Thheards.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);

    //chave para abrir ou fechar a classe
    private boolean open = true;

    public boolean isOpen(){
        return open;
    }

    public int pendingEmails(){
        synchronized (emails){
            return emails.size();
        }
    }

    public void addMemberEmail(String email){
        synchronized (this.emails){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " adicionou email na lista");
            this.emails.add(email);

            //acorda as thread que estavam em espera
            this.emails.notifyAll();

        }

    }

    public String retrievelEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");
        synchronized (this.emails){
            //se não tiver emails
            while(this.emails.isEmpty()){
                if(!open){
                    return null;
                }
                System.out.println(Thread.currentThread().getName() + " não tem email disponível na lista");
                System.out.println(Thread.currentThread().getName() + " esperando");
                this.emails.wait();
            }
        }
        return this.emails.poll();

    }

    public void close(){
        open = false;
        synchronized (this.emails){
            System.out.println(Thread.currentThread().getName() + " avisando que  não estamos mais pegando emails");
            this.emails.notifyAll();
        }
    }

}
