package outroCurso.heranca.apps;

public class FacebookMensseger extends ServicoDeMsgInstatanea {
    public void enviarMensagem() {
        validarConectadoNaInternet();
        System.out.println("enviar face");
    }

    @Override
    public void recebendoMensagem() {
        System.out.println("rece face");
    }

}
