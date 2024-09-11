package heranca;

public class FacebookMensseger extends ServicoDeMsgInstatanea{
    public void enviarMensagem() {
        System.out.println("enviar face");
    }

    @Override
    public void recebendoMensagem() {
        System.out.println("rece face");
    }

}
