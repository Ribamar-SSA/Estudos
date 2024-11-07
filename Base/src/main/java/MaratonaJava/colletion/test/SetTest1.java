package MaratonaJava.colletion.test;

import MaratonaJava.colletion.dominio.Manga;

import java.util.HashSet;
import java.util.Set;

public class SetTest1 {
    public static void main(String[] args) {
        Set<Manga> mangaSet = new HashSet<>();
        //não mantém a ordem , pois é de acordo com hash


        mangaSet.add(new Manga(3,"a",5.30));
        mangaSet.add(new Manga(2,"c",6));
        mangaSet.add(new Manga(1,"b",5.30));
        mangaSet.add(new Manga(6,"d",3));
        mangaSet.add(new Manga(5,"f",5.30));
        mangaSet.add(new Manga(4,"e",4));
        //não aceita duplicatas
        mangaSet.add(new Manga(4,"e",4));

        for(Manga m: mangaSet){
            System.out.println(m);
        }

    }
}
