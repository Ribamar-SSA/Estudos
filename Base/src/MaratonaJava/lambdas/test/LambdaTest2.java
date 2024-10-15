package MaratonaJava.lambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest2 {

    public static void main(String[] args) {

        List<String> listString = new ArrayList<>(List.of("ribamar","kietchu","sousa"));

        List<String> listAlterada = methodFunction(listString,(String s) -> s.toUpperCase());

        System.out.println(listAlterada);

    }


    public static <T,R>  List<R> methodFunction(List<T> list,  Function<T,R> function){
        List<R> listaRetorno = new ArrayList<>();
        for(T t : list){
           R r = function.apply(t);
           listaRetorno.add(r);
        }
        return listaRetorno;
    }
}
