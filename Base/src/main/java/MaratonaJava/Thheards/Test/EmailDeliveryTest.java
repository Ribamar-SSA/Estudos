package MaratonaJava.Thheards.Test;

import MaratonaJava.Thheards.dominio.Members;
import MaratonaJava.Thheards.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeliveryTest {


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
