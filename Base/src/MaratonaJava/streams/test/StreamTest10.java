package MaratonaJava.streams.test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
//        Stream.iterate(1,n -> n+2)
//                .limit(10)
//                .forEach(System.out::println);
        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1],n[0]+n[1]})
                .limit(10)
                .forEach(x -> System.out.println(Arrays.toString(x)));

        //sequência de fibonacci usando iterate
        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1],n[0]+n[1]})
                .limit(10)
                .map(x -> x[0])
                .forEach(System.out::println);


        System.out.println("aleatoria");
        ThreadLocalRandom local = ThreadLocalRandom.current();
        Stream.generate(()->local.nextInt(0,50))
                .limit(10)
                .forEach(System.out::println);
    }
}
