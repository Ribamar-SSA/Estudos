package MaratonaJava.classesInternas;

import MaratonaJava.Generics.dominio.Barco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassesTest2 {

    public static void main(String[] args) {
        List<Barco> barcoList = new ArrayList<Barco>(List.of(new Barco("lancha1"),new Barco("ancha2")));

        //como poderia ordenar essa lista usando uma classe anônima ?
        System.out.println("antes");
        System.out.println(barcoList);

        //cria uma classe anônima que implementa a interface
        barcoList.sort(new Comparator<Barco>() {
            @Override
            public int compare(Barco o1, Barco o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });


        System.out.println(barcoList);
    }
}
