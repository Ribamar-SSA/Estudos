package Carro;



//abstract é a indisponibilidade para determinar
// a lógica  de um ou vários comportamento
public abstract class Veiculo {

    String chassi;

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    // é abstrato pois não sei como funciona
    //isso será especificado na classe que implementar
    public abstract void ligar();
}
