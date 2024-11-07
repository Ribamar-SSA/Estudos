package MaratonaJava.zzgConcorrencia.test;

import MaratonaJava.zzgConcorrencia.dominio.Members;
import MaratonaJava.zzgConcorrencia.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeliveryTest01 {


    public static void main(String[] args) throws InterruptedException {
        Members members = new Members();

        Thread kakashi = new Thread(new EmailDeliveryService(members), "kakashi");
        Thread jiraya = new Thread(new EmailDeliveryService(members), "jiraya");

        kakashi.start();
        jiraya.start();



        while(true){
            String email = JOptionPane.showInputDialog("email:");

            if(email == null || email.isEmpty()){

                members.close();
                break;
            }
            members.addMemberEmail(email);
        }


    }

}
