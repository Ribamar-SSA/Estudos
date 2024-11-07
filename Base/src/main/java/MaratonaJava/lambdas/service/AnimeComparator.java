package MaratonaJava.lambdas.service;

import MaratonaJava.lambdas.dominio.Anime;

public class AnimeComparator {

public static int CompareTo(Anime anime1, Anime anime2){
    return anime2.getTitle().compareTo(anime2.getTitle());
};

public  int CompareToNonStatic(Anime anime1, Anime anime2){
    return anime2.getTitle().compareTo(anime2.getTitle());
};



}
