package heranca;
//msn herda de servicoDeMsgInstatânea
public class Msn extends  ServicoDeMsgInstatanea{
    public void enviarMensagem() {
        System.out.println("enviar msn");
    }

    @Override
    public void recebendoMensagem() {
        System.out.println("recebendo msn");
    }
}
