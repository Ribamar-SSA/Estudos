package MaratonaJava.streams.test;

import java.util.List;

public class StreamTest07 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(integers.stream().reduce((x,y) -> x + y));

        integers.stream()
                .reduce(Integer::sum)
                .ifPresent(System.out:: println);


        //identity = valor neutro da soma
        //ele para de retornar um optional
        Integer reduce = integers
                .stream()
                .reduce(0, Integer::sum);

        System.out.println(reduce);


        //fazendo para soma

        System.out.println("reduce multiplicação");
        Integer reduce1 = integers.stream()
                .reduce(1, (x, y) -> x * y);

        System.out.println(reduce1);

        //encontrando o valor máximo

        integers.stream()
                .reduce((x,y)->x>y?x:y)
                .ifPresent(System.out::println);

        //encontrar o máximo do jeito bonito
        integers.stream()
                .reduce((a1,a2)->Integer.max(a1,a2))
                .ifPresent(System.out::println);


    }
}
