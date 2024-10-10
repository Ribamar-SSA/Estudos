package MaratonaJava.colletion.test;

import MaratonaJava.colletion.dominio.Manga;
import MaratonaJava.colletion.dominio.Smartphone;

import java.util.*;

class SmartphoneComparator implements Comparator<Smartphone>{
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getSerialNumber().compareTo(o2.getSerialNumber());
    }
}


public class NavigableSetTest1 {
    public static void main(String[] args) {

        //todos os TreeSet precisam de um comparable ou um Comparator
        NavigableSet<Smartphone> smartphoneNavigableSet = new TreeSet<>(new SmartphoneComparator());

        Smartphone smartphone = new Smartphone("121312","noki123");
        smartphoneNavigableSet.add(smartphone);



        //exemplos manga
        NavigableSet<Manga> mangaNavigableSet = new TreeSet<>();

        mangaNavigableSet.add(new Manga(3,"a",5.30));
        mangaNavigableSet.add(new Manga(2,"c",6));
        mangaNavigableSet.add(new Manga(1,"b",5.30));
        mangaNavigableSet.add(new Manga(6,"d",3));
        mangaNavigableSet.add(new Manga(5,"f",5.30));
        mangaNavigableSet.add(new Manga(4,"e",4));
        //também não permite duplicatas
        mangaNavigableSet.add(new Manga(4,"e",4));

        //ordenado por id
        for (Manga m:mangaNavigableSet)
            System.out.println(m);;


    }
}
