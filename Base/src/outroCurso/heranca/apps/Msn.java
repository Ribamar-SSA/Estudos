package outroCurso.heranca.apps;

//msn herda de servicoDeMsgInstatânea
public class Msn extends ServicoDeMsgInstatanea {
    public void enviarMensagem() {
        validarConectadoNaInternet();
        System.out.println("enviar msn");
    }

    @Override
    public void recebendoMensagem() {
        System.out.println("recebendo msn");
    }
}
