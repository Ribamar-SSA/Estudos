package heranca.apps;

public abstract class ServicoDeMsgInstatanea {

    //as classes filhas implementarão esse metodo
    //a classe abstrata não sabe como o metodo fara isso
    //os metodos não tem corpo
    public abstract void recebendoMensagem();
    public abstract void enviarMensagem();

    //Com o encapsulamento protected posso usar nas classes dentro do pacote apps
    protected void validarConectadoNaInternet(){
        System.out.println("valindando se está conectado");
    }
//    private void salvandoHistoricoMensagem(){
//        System.out.println("salvando histórico da mensagem");
}
