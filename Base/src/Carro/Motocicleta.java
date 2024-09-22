package Carro;

//classe especializada de Veiculo
//basta colocar um extends
public class Motocicleta extends Veiculo {
    @Override
    public void ligar(){
        System.out.println("ligando moto");
    }
}
