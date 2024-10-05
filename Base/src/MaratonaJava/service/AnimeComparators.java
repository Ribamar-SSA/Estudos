package MaratonaJava.service;

import meu.lambdas.dominio.Anime;

public class AnimeComparators {

    public static int compareto(Anime pa1, Anime pa2){
        return pa1.getTitle().compareTo(pa2.getTitle());

    }

}
