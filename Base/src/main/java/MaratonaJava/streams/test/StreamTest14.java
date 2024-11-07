package MaratonaJava.streams.test;

import MaratonaJava.streams.dominio.Category;
import MaratonaJava.streams.dominio.LightNovel;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest14 {

    private static List<LightNovel> lightNovelsList = new ArrayList<>(List.of(
            new LightNovel("Violet Evergarden",10, Category.FANTASY),
            new LightNovel("scarface",23, Category.FANTASY),
            new LightNovel("monogatari",20, Category.FANTASY),
            new LightNovel("scarface",23, Category.FANTASY),
            new LightNovel("no game no life",350, Category.FANTASY ),
            new LightNovel("ctensei shitarra",34,Category.DRAMA),
            new LightNovel("scarface",23,Category.DRAMA),
            new LightNovel("athe godfather",123,Category.FANTASY),
            new LightNovel("bways jonny",63,Category.ROMANCE)));

    public static void main(String[] args) {

        System.out.println("conta a quantidade de elementos de cada categoria");
        Map<Category, Long> collect = lightNovelsList.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.counting()));
        System.out.println(collect);


        System.out.println("pega o maior de cada categoria, mas como optional");
        Map<Category, Optional<LightNovel>> collect1 = lightNovelsList.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect1);

        System.out.println("pega o maior de cada categoria, mas sem optional");

        Map<Category, LightNovel> collect2 = lightNovelsList.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)), Optional::get)));
        System.out.println(collect2);


    }



}
