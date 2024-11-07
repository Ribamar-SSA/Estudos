package MaratonaJava.lambdas.test;

import MaratonaJava.lambdas.dominio.Anime;
import MaratonaJava.lambdas.service.AnimeComparator;
import MaratonaJava.service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//reference to an instace of a particular object
public class methodReference {

    public static void main(String[] args) {

        AnimeComparator animeComparator = new AnimeComparator();

        List<Anime> Animes = new ArrayList<>(List.of(new Anime("violet Evergarden",5), new Anime("kazeriro",7), new Anime("gooku",10), new Anime("sousqe",1), new Anime("goutyko",3)));

        //só pode se criar uma instãncia do AnimeComparator
        Collections.sort(Animes,animeComparator::CompareToNonStatic);




    }
}
