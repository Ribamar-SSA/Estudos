package MaratonaJava.streams.test;

import MaratonaJava.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest3 {
    private static List<LightNovel> lightNovelsList = new ArrayList<>(List.of(
        new LightNovel("Violet Evergarden",10),
        new LightNovel("scarface",23),
        new LightNovel("monogatari",20),
        new LightNovel("scarface",23),
        new LightNovel("no game no life",350),
        new LightNovel("ctensei shitarra",34),
        new LightNovel("scarface",23),
        new LightNovel("athe godfather",123),
        new LightNovel("bways jonny",63)));

    public static void main(String[] args) {
        Stream<LightNovel> stream = lightNovelsList.stream();

        lightNovelsList.forEach(System.out :: println);
        System.out.println("teste1");
        long count  = stream.filter(x -> x.getPrice()<63).count();
        System.out.println(count);


        System.out.println("teste2");
        long count3 = lightNovelsList.stream()
                //sempre lembrar do equals
                .distinct()
                .filter(ln -> ln.getPrice()<63)
                .count();

        System.out.println(count3);


    }
}
