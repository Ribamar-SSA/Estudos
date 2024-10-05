package CursoDio.Carro.Interface.equipamentos.impressora;

public class Deskjet implements Impressora {
    @Override
    public void imprimir() {
        System.out.println("imprimindo por deskjet");
    }
}
