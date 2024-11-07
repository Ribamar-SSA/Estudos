package MaratonaJava.colletion.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySerachTest1 {
    public static void main(String[] args) {

        List<Integer> listInteger = new ArrayList<>();

        listInteger.add(2);
        listInteger.add(4);
        listInteger.add(5);
        listInteger.add(6);
        listInteger.add(7);
        listInteger.add(1);

        Collections.sort(listInteger);

        //se o objeto não for encontrado -(insertion point) - 1
        Collections.binarySearch(listInteger,7);



    }
}
