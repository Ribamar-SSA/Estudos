package MaratonaJava.colletion.test;

import MaratonaJava.colletion.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySerachTest2 {
    public static void main(String[] args) {
        List<Manga> mangaList = new ArrayList<>();

        mangaList.add(new Manga(2,"c",6));
        mangaList.add(new Manga(3,"a",5.30));
        mangaList.add(new Manga(1,"b",5.30));
        mangaList.add(new Manga(6,"d",3));
        mangaList.add(new Manga(5,"f",5.30));
        mangaList.add(new Manga(4,"e",4));

        //sempre precisa ordenar antes de usar binarySearch
        //nesse caso o comparable está ordenando por id
        Collections.sort(mangaList);
        for (Manga manga : mangaList){
            System.out.println(manga);
        }

        //apesar dos dados serem diferentes ele encontra o com o id 4,
        //já que o method compareTo do Comparable está com esse default
        Manga mangaProcurado = new Manga(4,"e",4);

        System.out.println(Collections.binarySearch(mangaList,mangaProcurado));


        System.out.println("---------------");

        //se eu usar por Comparator
        Collections.sort(mangaList,new OrdenarPorNome());

        for(Manga manga : mangaList){
            System.out.println(manga);
        }


        System.out.println(Collections.binarySearch(mangaList,mangaProcurado,new OrdenarPorNome()));
    }
}
