package MaratonaJava.lambdas.test;

import MaratonaJava.lambdas.dominio.Anime;
import MaratonaJava.lambdas.service.AnimeComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

//reference to a constructor
public class MethodReferenceTest4 {
    public static void main(String[] args) {

        //fato 1 : podemos usar lambdas para criar objetos

        //precisamos do Supplier para criar objetos com lambdas, pois é uma interface funcional
        //e o objeto só vai ser criado quando usar o method get() do Supplier

        Supplier<AnimeComparator> newAnimeComparators = () -> new AnimeComparator();
        Supplier<AnimeComparator> newAnimeComparators2 = AnimeComparator::new;

         AnimeComparator animeComparator = newAnimeComparators.get();
        List<Anime> animes = new ArrayList<>(List.of(new Anime("violet Evergarden",5), new Anime("kazeriro",7), new Anime("gooku",10), new Anime("sousqe",1), new Anime("goutyko",3)));


        animes.sort(animeComparator :: CompareToNonStatic);

        //como poderia criar um objeto de anime?
        //java não deixa fazer isso porque nao tem construtor sem parâmetros
        //Supplier<Anime> animeSupplier = Anime :: new;
        //para isso, preciso criar um algo que recebe dois elementos (atributos do Anime)
        // e retorne um terceiro(BiFunction)

        BiFunction<String,Integer,Anime> animeBiFunction = (s,i)->new Anime(s,i);
        BiFunction<String,Integer,Anime> animeBiFunction2 = Anime::new;

        System.out.println(animeBiFunction.apply("guitar hero",9));

    }

}
