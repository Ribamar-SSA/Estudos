package MaratonaJava.colletion.test;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest {
    public static void main(String[] args) {
        //ele ordena pela chave
        // O valor não precisa implementar Comparable
        NavigableMap<String,String> navigableMapTest = new TreeMap<>();

        navigableMapTest.put("A","letra a");
        navigableMapTest.put("B","letra b");
        navigableMapTest.put("C","letra c");
        navigableMapTest.put("D","letra d");
        navigableMapTest.put("E","letra e");

        System.out.println("headMap");
        System.out.println(navigableMapTest.headMap("C"));

        System.out.println("ceiling");
        System.out.println(navigableMapTest.ceilingKey("C"));
        System.out.println("floor");
        System.out.println(navigableMapTest.floorKey("C"));
        System.out.println("higher");
        System.out.println(navigableMapTest.higherKey("C"));
        System.out.println("lower");
        System.out.println(navigableMapTest.lowerKey("C"));
    }
}
