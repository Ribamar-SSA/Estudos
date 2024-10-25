package MaratonaJava.streams.test;

import MaratonaJava.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest06 {
    private static List<LightNovel> lightNovelsList = new ArrayList<>(List.of(
            new LightNovel("Violet Evergarden",10),
            new LightNovel("overlord",18),
            new LightNovel("monogatari",20),
            new LightNovel("fullmetal",30),
            new LightNovel("no game no life",350),
            new LightNovel("ctensei shitarra",34),
            new LightNovel("scarface",23),
            new LightNovel("athe godfather",123),
            new LightNovel("bways jonny",63)));

    public static void main(String[] args) {

        System.out.println("test1");
        lightNovelsList
                .stream()
                .filter(x -> x.getPrice()>10)
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("test1");
        lightNovelsList
                .stream()
                .sorted(Comparator.comparing(LightNovel::getPrice))
                .findFirst()
                .ifPresent(System.out::println);
                //.forEach(System.out::println);



        System.out.println("test1");


        System.out.println("algum maior do que 34?");
        System.out.println(lightNovelsList.stream().anyMatch(x -> x.getPrice()>34));

        System.out.println("todo mundo maior do que 0?");
        System.out.println(lightNovelsList.stream().allMatch(x -> x.getPrice()>0));

        System.out.println("todo mundo menor do que 0?");
        System.out.println(lightNovelsList.stream().noneMatch(x -> x.getPrice()>0));
    }
}
