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

class mangaComparatorPreco implements Comparator<Manga>{

    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}


public class NavigableSetTest1 {
    public static void main(String[] args) {

        //todos os TreeSet precisam de um comparable ou um Comparator
        NavigableSet<Smartphone> smartphoneNavigableSet = new TreeSet<>(new SmartphoneComparator());

        Smartphone smartphone = new Smartphone("121312","noki123");
        smartphoneNavigableSet.add(smartphone);



        //exemplos manga
        //o detalhe é que ele usa o method CompareTo do Comparable
        //para analisar as duplicatas, não o equals
        NavigableSet<Manga> mangaNavigableSet = new TreeSet<>(new mangaComparatorPreco());

        mangaNavigableSet.add(new Manga(3,"a",5.30));
        mangaNavigableSet.add(new Manga(2,"c",6));
        mangaNavigableSet.add(new Manga(1,"b",5.30));
        mangaNavigableSet.add(new Manga(6,"d",3));
        mangaNavigableSet.add(new Manga(5,"f",5.30));
        mangaNavigableSet.add(new Manga(4,"e",4));
        //também não permite duplicatas
        mangaNavigableSet.add(new Manga(4,"e",4));


        //ordenado pelo comparator passado
        System.out.println("em ordem");
        for (Manga m:mangaNavigableSet)
            System.out.println(m);;



        System.out.println("organização inversa");
        for (Manga m:mangaNavigableSet.descendingSet())
                    System.out.println(m);

        Manga test1 = new Manga(20, "o diferente ", 4);


        //methods
        //lower : <
        //floor : <=
        //higher : >
        //ceiling : >=

        System.out.println("----------------");
        //menor imediato
        System.out.println(mangaNavigableSet.lower(test1));
        System.out.println("----------------");

        System.out.println(mangaNavigableSet.floor(test1));
        System.out.println("----------------");

        System.out.println(mangaNavigableSet.ceiling(test1));
        System.out.println("----------------");

        //maior imediato
        System.out.println(mangaNavigableSet.higher(test1));
        System.out.println("----------------");

        System.out.println("pollFirst");
        System.out.println(mangaNavigableSet.pollFirst());

        System.out.println("pollLast");
        System.out.println(mangaNavigableSet.pollLast());

    }
}
