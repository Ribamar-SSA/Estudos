package MaratonaJava.streams.test;

import MaratonaJava.streams.dominio.Category;
import MaratonaJava.streams.dominio.LightNovel;
import MaratonaJava.streams.dominio.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamTest12 {
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
        //agrupar por categoria usando streams(muito mais eficiente do que fazer por listas e Maps)
        Map<Category, List<LightNovel>> collect = lightNovelsList.stream().collect(Collectors.groupingBy(LightNovel::getCategory));
        //System.out.println(collect);

        //usamos um Function para criar a lógica
        Map<Promotion, List<LightNovel>> collect1 = lightNovelsList.stream()
                .collect(Collectors.groupingBy(StreamTest12::getPromotion
        ));

        System.out.println(collect1);

        System.out.println("collect final");
        Map<Category, Map<Promotion, List<LightNovel>>> collect2 = lightNovelsList.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.groupingBy((x -> getPromotion(x)))));
        System.out.println(collect2);
    }

    private static Promotion getPromotion(LightNovel x) {
        return x.getPrice() < 23 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }

}
