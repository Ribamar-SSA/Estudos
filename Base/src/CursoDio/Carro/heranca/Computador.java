package CursoDio.Carro.heranca;

import CursoDio.Carro.heranca.apps.FacebookMensseger;
import CursoDio.Carro.heranca.apps.Msn;
import CursoDio.Carro.heranca.apps.ServicoDeMsgInstatanea;
import CursoDio.Carro.heranca.apps.TelegramMensseger;

public class Computador {

    public static void main(String[] args) {
        Msn mensagem = new Msn();
        mensagem.enviarMensagem();
        mensagem.recebendoMensagem();

        FacebookMensseger mensagemf = new FacebookMensseger();
        mensagemf.enviarMensagem();
        mensagemf.recebendoMensagem();

        TelegramMensseger mensagemt = new TelegramMensseger();
        mensagemt.enviarMensagem();
        mensagemt.recebendoMensagem();

        //polimorfismo

        ServicoDeMsgInstatanea smi = null;

        String appEscolhido = "msn";

        if (appEscolhido == "msn"){
            smi = new Msn();
        }
        else if(appEscolhido == "tlg"){
            smi = new TelegramMensseger();
        }
        else if(appEscolhido == "facebook"){
            smi = new FacebookMensseger();
        }

        smi.enviarMensagem();
        smi.recebendoMensagem();
    }
}
