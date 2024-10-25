package MaratonaJava.streams.test;

import MaratonaJava.streams.dominio.Category;
import MaratonaJava.streams.dominio.LightNovel;
import MaratonaJava.streams.dominio.Promotion;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest15 {

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


        System.out.println("agrupando por categoria e pegando esstatísticas de cada categoria");
        Map<Category, DoubleSummaryStatistics> collect3 = lightNovelsList.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.summarizingDouble(LightNovel::getPrice)));
        System.out.println(collect3);


        System.out.println("categoria e ver se está em  promocao");
        Map<Category, Set<Promotion>> collect = lightNovelsList.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(StreamTest15::getPromotion, Collectors.toSet())));
        System.out.println(collect);


        Map<Category, LinkedHashSet<Promotion>> collect1 = lightNovelsList.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(StreamTest15::getPromotion, Collectors.toCollection(LinkedHashSet::new))));
        System.out.println(collect1);


    }
    private static Promotion getPromotion(LightNovel x) {
        return x.getPrice() < 23 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }


}
