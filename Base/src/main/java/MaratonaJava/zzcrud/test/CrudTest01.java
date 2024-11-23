package MaratonaJava.zzcrud.test;

import MaratonaJava.zzcrud.service.AnimeService;
import MaratonaJava.zzcrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        int op ;

        while(true){
            menu();
            op = SCANNER.nextInt();
            if(op == 0) break;
            switch (op) {
                case 1 -> {
                    producerMenu();
                    System.out.printf("digite:");
                    op = SCANNER.nextInt();
                    ProducerService.menu(op);
                }
                case 2 -> {
                    menuAnime();
                    System.out.printf("digite:");
                    op = SCANNER.nextInt();
                    AnimeService.menu(op);
                }
            }
        }

    }
    public static void menu(){
        System.out.println("digite 0 para encerrar ");
        System.out.println("digite 1 para Producer  ");
        System.out.println("digite 2 para Anime ");

    }
    public static void producerMenu(){
        System.out.println("digite 0 para encerrar ");
        System.out.println("digite 1 para buscar por um producer ");
        System.out.println("digite 2 para deletar um producer ");
        System.out.println("digite 3 para adicionar um producer ");
        System.out.println("digite 4 para atualizar um producer ");
    }
    public static void menuAnime(){
        System.out.println("digite 0 para encerrar ");
        System.out.println("digite 1 para buscar por um anime");
        System.out.println("digite 2 para deletar um anime ");
        System.out.println("digite 3 para adicionar um anime ");
        System.out.println("digite 4 para atualizar um anime ");
    }
}
