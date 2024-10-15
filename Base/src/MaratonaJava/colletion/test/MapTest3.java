package MaratonaJava.colletion.test;

import MaratonaJava.colletion.dominio.Consumidor;
import MaratonaJava.colletion.dominio.Manga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest3 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("ribamar");
        Consumidor consumidor2 = new Consumidor("dev dojo");


        Manga manga =  new Manga(2, "Helsing", 6);
        Manga manga2 = new Manga(3,"Dragon Ball Z",5.5);
        Manga manga3 = new Manga(1,"Violet Evergarden",5.3)     ;
        Manga manga4 = new Manga(6,"doidado",3)    ;
        Manga manga5 = new Manga(5,"ferrado",5.6);
        Manga manga6 = new Manga(4,"esforçado",4)   ;

        //associar um consumidor como chave e para vários valores de Manga

        Map<Consumidor, List<Manga>> consumidorListMap = new HashMap<>();

        List<Manga> mangaLista = List.of(manga2,manga3,manga4);
        List<Manga> mangaList2 = List.of(manga,manga6);

        consumidorListMap.put(consumidor1,mangaLista);
        consumidorListMap.put(consumidor2,mangaList2);

        for(Map.Entry<Consumidor,List<Manga>> mangaEntry : consumidorListMap.entrySet()){
            System.out.println("chave");
            System.out.println(mangaEntry.getKey().getNome());

            //lendo os valores de cada chave
            System.out.println("valores");
            for(Manga manga1 : mangaEntry.getValue()){
                System.out.println(manga1.getNome());
            }

        }
    }
}
