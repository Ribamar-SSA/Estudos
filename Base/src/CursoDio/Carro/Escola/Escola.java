package CursoDio.Carro.Escola;

public class Escola {
    public static void main(String[] args) {
        Aluno felipe = new Aluno();

        //também funciona por que está default e tá no mesmo pacote
        felipe.nome = "sousa";


        //felipe.setNome("Ribamar");
        felipe.setIdade(19);


        System.out.println(felipe.nome);

        //felipe.getNome();


    }
}
