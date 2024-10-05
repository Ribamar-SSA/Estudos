package CursoDio.Carro.Interface.equipamentos.impressora;

public interface Impressora {
    public  default  void imprimir(){
        System.out.println("valor dafault");
    };
}
