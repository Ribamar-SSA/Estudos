package MaratonaJava.colletion.test;

import MaratonaJava.colletion.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest1 {
    public static void main(String[] args) {
        //o linked list tem mais desempenho para remoções
        List<Manga> mangaList = new LinkedList<>();

        mangaList.add(new Manga(3,"a",5.30,2));
        mangaList.add(new Manga(2,"c",6,7));
        mangaList.add(new Manga(1,"b",5.30,10));
        mangaList.add(new Manga(6,"d",3,2));
        mangaList.add(new Manga(5,"f",5.30,1));
        mangaList.add(new Manga(4,"e",4,9));


        //jeito errado e não funcional
//        for(Manga m:mangaList){
//            if(m.getQuantidade() == 10)
//                mangaList.remove(m);
//        }


        Iterator<Manga> iterator =  mangaList.iterator();

        //jeito antigo
//        while(iterator.hasNext()){
//            if(iterator.next().getQuantidade() == 10)
//                iterator.remove();
//        }

        //jeito novo

        //usando programação funcional
        mangaList.removeIf(manga -> manga.getQuantidade() == 0);

        System.out.println(mangaList);
    }
}
