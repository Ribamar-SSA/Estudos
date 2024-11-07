package MaratonaJava.streams.test;

import MaratonaJava.streams.dominio.LightNovel;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {
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

        lightNovelsList.stream().count();
        lightNovelsList.stream().collect(Collectors.counting());

        lightNovelsList.stream()

                //a interface Collector representa uma operação terminal que reduz
                // uma stream a um único valor, como uma lista, um conjunto, um mapa,
                // um número, etc. Ela é fundamental para realizar operações de redução
                // como collect, groupingBy, counting, entre outras.

                .collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)))
                .ifPresent(System.out::println);

        System.out.println(lightNovelsList.stream().mapToDouble(x-> x.getPrice()).sum());
        Double collect1 = lightNovelsList.stream().collect(Collectors.summingDouble(LightNovel::getPrice));
        System.out.println(collect1);


        //summarizing
        System.out.println("summarizing");
        DoubleSummaryStatistics collect = lightNovelsList.stream().collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(collect);

        //joining
        String collect2 = lightNovelsList.stream().map(LightNovel::getNome).collect(Collectors.joining(", "));
        System.out.println(collect2);

    }
}

