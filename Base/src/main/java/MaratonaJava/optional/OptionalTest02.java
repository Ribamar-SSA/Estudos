package MaratonaJava.optional;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalTest02 {


    //Optional <String> name;
    //não é uma boa ideia declarar variáveis ou colocar parâmetros
    // Optinal porque não é serializável

    public static void main(String[] args) {

        //ele já retorna um Optional desde o início
        Optional<String> optionalString = findName("ribamar");

        System.out.println("optional empty");
        System.out.println(optionalString);


        System.out.println("or else");
        String empty = optionalString.orElse("teve retorno null");
        System.out.println(empty);


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

    private static Optional<String> findName(String name){
        List<String> list = List.of("ribamar","sousa");

        int i = list.indexOf(name);

        if(i!=-1){
            return Optional.of(list.get(i));
        }
            return Optional.empty();


    }
}
