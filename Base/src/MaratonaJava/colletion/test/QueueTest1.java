package MaratonaJava.colletion.test;

import MaratonaJava.colletion.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest1 {
    public static void main(String[] args) {
        //a classe adicionada precisa ser um comparable

        //é importante para a ordem de prioridade
        Queue<String> fila = new PriorityQueue<>();
        fila.add("C");
        fila.add("A");
        fila.add("B");

        System.out.println("fila");
        System.out.println(fila);

        //ele ordena depois que insere
        while(!fila.isEmpty()){
            System.out.println(fila.poll());
        }

        //usar o preco como parâmetro
        Queue<Manga> fila2 = new PriorityQueue<>(new mangaComparatorPreco().reversed());
        fila2.add(new Manga(2, "cHelsing", 6));
        fila2.add(new Manga(3,"aDragon Ball Z",5.5));
        fila2.add(new Manga(1,"bViolet Evergarden",5.3))     ;
        fila2.add(new Manga(6,"doidado",3)  )  ;
        fila2.add(new Manga(5,"ferrado",5.6));
        fila2.add(new Manga(4,"esforçado",4)  ) ;


        //element() peek() podem ser usadas para acessar sem remover o elemento

        while(! fila2.isEmpty()){
            //remove e mostra o primeiro elemento
            System.out.println(fila2.poll());
        }
    }
}
