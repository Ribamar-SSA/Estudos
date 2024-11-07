package MaratonaJava.Thheards.service;

import MaratonaJava.Thheards.dominio.Members;

public class EmailDeliveryService implements  Runnable {

    public EmailDeliveryService(Members members) {
        this.members = members;
    }
    //adiciona o construtor porque é final
    private final Members members;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " starting to deliver emails");

        while(members.isOpen() || members.pendingEmails() > 0){
            try {
                String email = members.retrievelEmail();
                if(email == null )
                    continue;

                System.out.println(threadName+ " enviando para o email "+ email);

                //simular tempo
                Thread.sleep(2000);

                System.out.println(threadName+ " enviou para o email "+ email);

            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }

        }
        System.out.println(" todos os emails foram enviados com sucesso ");
    }

}
