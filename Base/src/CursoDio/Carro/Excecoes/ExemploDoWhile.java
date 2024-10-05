package CursoDio.Carro.Excecoes;

import java.util.Random;

public class ExemploDoWhile {

    public static void main(String[] args) {
        System.out.println("discando ...");

        do{
            System.out.println("telefone tocando");
        }while(tocando());

        System.out.println("alô !!!");

    }
    private static boolean tocando(){
        boolean atendeu = new Random().nextInt(3)==1;
        System.out.println("atendeu ?" + atendeu);
        return !atendeu;
    }
}
