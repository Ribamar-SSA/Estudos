package MaratonaJava.streams.test;

import MaratonaJava.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest08 {
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
//        #########jeito errado
//        List<Double> objects = new ArrayList<>() ;
//        for (LightNovel l:lightNovelsList){
//            if (l.getPrice()>23){
//                objects.add(l.getPrice());
//            }
//        }
//        objects
//                .stream()
//                .reduce(Double::sum)
//                .ifPresent(System.out::println);
        double sum = lightNovelsList
                .stream()
                .mapToDouble(lightNovelsList -> lightNovelsList.getPrice())
                .filter(price -> price > 23)
                .sum();
        System.out.println(sum);
    }
}
