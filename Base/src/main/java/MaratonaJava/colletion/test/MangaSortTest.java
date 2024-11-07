package MaratonaJava.colletion.test;

import MaratonaJava.colletion.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class OrdenarPorNome implements Comparator<Manga> {
    @Override
    public int compare(Manga o1, Manga o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
public class MangaSortTest {

    public static void main(String[] args) {
        List<Manga> mangaList = new ArrayList<>();

        mangaList.add(new Manga(3,"a",5.30));
        mangaList.add(new Manga(2,"c",6));
        mangaList.add(new Manga(1,"b",5.30));
        mangaList.add(new Manga(6,"d",3));
        mangaList.add(new Manga(5,"f",5.30));
        mangaList.add(new Manga(4,"e",4));

        System.out.println(mangaList);
        System.out.println("-----------");

        //ordenação padrão
        Collections.sort(mangaList);
        System.out.println(mangaList);
        System.out.println("-----------");

        //ordenação por nome
        Collections.sort(mangaList,new OrdenarPorNome());
        System.out.println(mangaList);
        System.out.println("-----------");


    }
}
