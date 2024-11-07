package MaratonaJava.colletion.test;

import MaratonaJava.colletion.dominio.Consumidor;
import MaratonaJava.colletion.dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("ribamar");
        Consumidor consumidor2 = new Consumidor("dev dojo");


        Manga manga = new Manga(2, "c", 6);
        Manga manga2 = new Manga(3,"a",5.5);
        Manga manga3 = new Manga(1,"b",5.3)     ;
        Manga manga4 = new Manga(6,"d",3)    ;
        Manga manga5 = new Manga(5,"f",5.6);
        Manga manga6 = new Manga(4,"e",4)   ;

        //associar um um consumidor como chave e um manga como valor

        Map<Consumidor,Manga> mangaMap = new HashMap<>();



        mangaMap.put(consumidor1,manga3);
        mangaMap.put(consumidor2,manga6);

//        System.out.println("imprimindo um map");
//        System.out.println(mangaMap);

        for(Map.Entry<Consumidor,Manga> mangaEntry : mangaMap.entrySet()){
            System.out.println("key");
            //retorna um consumidor
            System.out.println(mangaEntry.getKey() );

            //retorna um manga
            System.out.println("value");
            System.out.println(mangaEntry.getValue());
        }

    }
}
