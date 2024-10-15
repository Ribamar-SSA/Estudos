package MaratonaJava.streams.test;


//1.order LightNovel by title
//2.retrieve the first 3 lightNovels with price less than 4

import MaratonaJava.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest1 {

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
        lightNovelsList.sort(Comparator.comparing());
        System.out.println(lightNovelsList);
    }
}
