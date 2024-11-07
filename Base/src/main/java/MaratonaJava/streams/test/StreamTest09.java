package MaratonaJava.streams.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
    //criando streams diretamente
    public static void main(String[] args) {
        IntStream.rangeClosed(1,50).forEach(System.out::print);
        System.out.println();
        IntStream.range(1,50).forEach(System.out::print);

        System.out.println();

         Stream.of("amanhã" + "vai" + "ser " + "melhor " + "!!")
                .reduce(String::concat)
                 .ifPresent(System.out::print);

        System.out.println();
         //stream com array
         int[] num = {1,2,3,4,5,6,7,8,9,10};
         Arrays.stream(num)
                 .average()
                 .ifPresent(System.out::println);


         try(Stream<String> stringStream = Files.lines(Paths.get("File.txt"))){
             stringStream
                     //filtrando por linha
                     .filter(x -> x.contains("java"))
                     .forEach(System.out::println);

         }catch (IOException e){
             e.printStackTrace();
         }


    }
}
