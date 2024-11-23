package MaratonaJava.optional;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalTest01 {

    public static void main(String[] args) {

        Optional<String> o1 = Optional.of("amanha fui eu");
        Optional<String> o2 = Optional.ofNullable(null);
        Optional<String> o3 = Optional.empty();


        System.out.println("impressão dos options");
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);



        Optional<String> optionalString = Optional.ofNullable(findName("ribam"));

        System.out.println("optional empty");
        System.out.println(optionalString);


        System.out.println("or else");
        String empty = optionalString.orElse("teve retorno null");
        System.out.println(empty);


        System.out.println("teste final");
        optionalString = Optional.of("teste final 2");
        //se o objeto estiver presente eu consigo trabalhar com ele sem ocorrer exceções
        optionalString.ifPresent(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        });


//        String name = findName("sousa");
//        //não ocorreu, mas poderia ter ocorrido um NullPointer exeption
//        System.out.println(name.toLowerCase());
    }

    private static String findName(String name){
        List<String> list = List.of("ribamar","sousa");

        int i = list.indexOf(name);

        System.out.println("inde:"+i);
        if(i != -1){
            return list.get(i);
        }
            return null;


    }
}
