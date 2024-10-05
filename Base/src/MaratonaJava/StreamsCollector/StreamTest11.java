package MaratonaJava.StreamsCollector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {

    private static List<LightNovel> LightNovels = new ArrayList<>(List.of(
        new LightNovel("Violet Evergarden",5.99),
            new LightNovel("Kazeriro",7),
            new LightNovel("gooku",10),
            new LightNovel("sousqe",1.69),
            new LightNovel("goutyko",3.4)

    ));

    public static void main(String[] args) {
        LightNovels.stream().collect(Collectors.toList());


    }

}
