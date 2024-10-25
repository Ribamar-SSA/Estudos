package MaratonaJava.streams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest05 {
    public static void main(String[] args) {

        List<String> words = List.of("gomu", "no", "mi", "sousa", "rib", "fagner");
        String [] letters = words.get(0).split("");

        System.out.println(Arrays.toString(letters));

        //não funciona
        List<String[]> collect = words.stream()
                .map(w->w.split(""))
                .collect(Collectors.toList());

        System.out.println(collect);


        //funcional
        List<String> stringList = words.stream()
                .map(w -> w.split(""))
                .flatMap(array -> Arrays.stream(array))
                .collect(Collectors.toList());

        System.out.println(stringList);




    }
}
