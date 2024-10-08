package MaratonaJava.lambdas.test;

import MaratonaJava.lambdas.dominio.Anime;
import MaratonaJava.service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//se a lambda chamar apenas um método
//pode usar método reference

public class methodReference {
    private static List<Anime> Animes = new ArrayList<>(List.of(
            new Anime("violet Evergarden",5),
            new Anime("kazeriro",7),
            new Anime("gooku",10),
            new Anime("sousqe",1),
            new Anime("goutyko",3)

    ));

    public static void main(String[] args) {
        // o compilador infere que os objetos a1 e a2 são do mesmo tipo dos que estão na lsita
        //animes
        //Collections.sort(Animes,(a1,a2) -> a1.getTitle().compareTo(a2.getTitle()));

//caso método statico

        //forma usando apenas um método para usar o método reference
        //Collections.sort(Animes,(a1,a2) -> AnimeComparators.compareto(a1,a2));
        Collections.sort(Animes, AnimeComparators::compareto);
        System.out.println(Animes);
        /*
        * tipo de destino (ou target type) de uma expressão
        * lambda é a interface funcional que a lambda implementa implicitamente.
        */

    }
}
