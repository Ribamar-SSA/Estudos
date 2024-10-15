package MaratonaJava.lambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

//reference to an instance method of an arbitary object of a particular type
public class MethodReferenceTest02 {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>(List.of("alura","ribamar","samurai"));

        //a classe String implementa o method compareTo
        //esse method não é estatico


        //por lambda
        //stringList.sort((s,s1)->s.compareTo(s1));

        //por reference
        stringList.sort(String::compareTo);

        //usando a interface Function para exercutar uma função
        Function<String,Integer> stringToInt = Integer::parseInt;


        int numero = stringToInt.apply("1");

        System.out.println(numero);

        //usando lambda
        //BiPredicate<List<String>,String> checkName = (s,s1)->s.contains(s1) ;

        //usando method reference
        BiPredicate<List<String>,String> checkName = List::contains;

        System.out.println("bipredicate");
        System.out.println(checkName.test(stringList,"ribamar"));




    }


}
