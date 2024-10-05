package CursoDio.Carro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Array {
    public static void main(String[] args) {
        String alunos[] = {"MARIA","JOANA","RIBAMAR"};
        int arrayIdades[] = {1,2,3,4,5};

        //o array.length entrega a quantidade de elementos dos array
        //contando do um
        System.out.println(alunos.length);
        for(int i =0; i< alunos.length; i++){
            System.out.println(alunos[i]);
        }

        for(String aluno : alunos){
            System.out.printf("nome do aluno é : %s",aluno);
        }
    }

}