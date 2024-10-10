package MaratonaJava.colletion.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConvensaoTeste1 {
    public static void main(String[] args) {

        //lista -> array
        List<Integer> integerList = new ArrayList<>();
        Integer[] arraysIntegers = integerList.toArray(new Integer[0]);

        //array -> lista

        Integer [] arrayIntergers2 = new Integer[3];
        arrayIntergers2[0] = 2;
        arrayIntergers2[1] = 23;
        arrayIntergers2[2] = 24;

        //cria um link com o array original
        List<Integer> integerList1 = Arrays.asList(arrayIntergers2);
        integerList1.set(0,6);//troca nos dois
        //integerList1.add(6); eu não consigo adicionar os valores

        //dessa forma ele copia tudo do outro
        List<Integer> intergerList4 = new ArrayList<>(Arrays.asList(arrayIntergers2));


        System.out.println( Arrays.toString(arrayIntergers2));
        System.out.println("----------");
        System.out.println(integerList1);


        //agora sim
        intergerList4.set(0,14);
        intergerList4.add(29);
        System.out.println(Arrays.toString(arrayIntergers2));
        System.out.println(intergerList4);








    }
}

