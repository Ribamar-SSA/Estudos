package heranca;

public class TelegramMensseger extends ServicoDeMsgInstatanea {

    @Override
    public void enviarMensagem() {
        System.out.println("enviar telef");
    }

    @Override
    public void recebendoMensagem() {
        System.out.println("rece tele");
    }
}
