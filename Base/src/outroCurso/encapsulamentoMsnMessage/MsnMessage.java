package outroCurso.encapsulamentoMsnMessage;

public class MsnMessage {

    private void validarConectadoNaInternet(){
        System.out.println("valindando se está conectado");
    }
    private void salvandoHistoricoMensagem(){
        System.out.println("salvando histórico da mensagem");
    }
    public void recebendoMensagem(){
        System.out.println("recebendo mensagem");

    }
    public void enviarMensagem(){
        //evita de ter que chamar esses métodas na classe de pedrinho-> nem tudo precisa ser visto
        validarConectadoNaInternet();
        System.out.println("enviando mensagem ");
        salvandoHistoricoMensagem();
    }
}
