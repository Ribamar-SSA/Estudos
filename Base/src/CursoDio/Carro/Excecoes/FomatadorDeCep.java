package CursoDio.Carro.Excecoes;

public class FomatadorDeCep {
    public static void main(String[] args) {
        try {
            String cepFormatado = fomatarCep("1231212398");
            System.out.println(cepFormatado);
        } catch (CepInvalidException e) {
            System.out.println("cep inválido");;
        }
    }



    static String fomatarCep(String cep)throws CepInvalidException{
        if(cep.length() != 8)
            throw new CepInvalidException();

        return "2321321312";
    }
}
