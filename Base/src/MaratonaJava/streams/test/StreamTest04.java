package MaratonaJava.streams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamTest04 {

    public static void main(String[] args) {
        List<List<String> >listList = new ArrayList<>();

        List<String> numeros = List.of("1","2","3","4");
        List<String> alunos = List.of("sandro","Gabriel","ribamar","fagner");
        List<String> cursos = List.of("math","phisics","geo","quimics");


        listList.add(alunos);
        listList.add(cursos);
        listList.add(numeros);

        for(List<String> ls : listList){
            for (String s : ls){
                System.out.println(s);
            }
        }

        listList.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);








    }

}
