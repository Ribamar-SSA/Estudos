package MaratonaJava.streams.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest16 {
    /*
    benchmark

     unboxing | boxing

    (limit,findFirst)   (findAny)

    custo total da computação  Computacional- geralmente , quanto maior qauntidade de  processamento
    será mais benéfico usar o parallel

    tipos de coleções boas para trabalhar de forma paralela

    tamanho do stream(tamanho definido->melhor)

    processamento do merge




    */

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long num = 100_000_000;

        sumStreamIterate(num);
        sumParallelStreamIterate(num);
        longStreamIterate(num);
        longParallelStreamIterate(num);


    }


    public static void sumStreamIterate(long num){
        long init=System.currentTimeMillis();
        long result = Stream.iterate(1L,x->x+1).limit(num).reduce(0L,Long::sum);
        long end =System.currentTimeMillis();

        System.out.println(result + " "+(end-init) + "ms");
    }

    //não é ideal iterar de um por um
    public static void sumParallelStreamIterate(long num){
        System.out.println("sumParalelStream");
        long init=System.currentTimeMillis();
        long result = Stream.iterate(1L,x->x+1).limit(num).parallel().reduce(0L,Long::sum);
        long end =System.currentTimeMillis();

        System.out.println(result + " "+(end-init) + "ms");
    }
public static void longStreamIterate(long num){
        System.out.println("LongStreamIterate");
        long init=System.currentTimeMillis();
        long result = LongStream.rangeClosed(1l,num).reduce(0L,Long::sum);
        long end =System.currentTimeMillis();

        System.out.println(result + " "+(end-init) + "ms");
    }
public static void longParallelStreamIterate(long num){
        System.out.println("LongParallelStreamIterate");
        long init=System.currentTimeMillis();
        long result = LongStream.rangeClosed(1l,num).parallel().reduce(0L,Long::sum);
        long end =System.currentTimeMillis();

        System.out.println(result + " "+(end-init) + "ms");
    }

}
