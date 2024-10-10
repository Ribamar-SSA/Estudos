package MaratonaJava.colletion.test;

import MaratonaJava.colletion.dominio.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone("19029123","redmi");
        Smartphone smartphone2 = new Smartphone("19059123","nokia");
        Smartphone smartphone3 = new Smartphone("12059123","sousa");


        List<Smartphone> smartphoneList = new ArrayList<>();

        smartphoneList.add(smartphone);
        smartphoneList.add(smartphone2);
        smartphoneList.add(smartphone3);

        Smartphone smartphone4 = new Smartphone("12059123","lenovo");


        System.out.println(smartphoneList.contains(smartphone4));

        //verifica pelo serialNumber !!!!!
        System.out.println(smartphoneList.contains(smartphone4));
        int indexOfSmart = smartphoneList.indexOf(smartphone4);

        //vai retornar o que tá dentro da lista
        System.out.println(smartphoneList.get(indexOfSmart));
    }
}
