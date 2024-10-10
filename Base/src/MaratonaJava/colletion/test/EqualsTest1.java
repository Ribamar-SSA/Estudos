package MaratonaJava.colletion.test;

import MaratonaJava.colletion.dominio.Smartphone;

public class EqualsTest1 {
    public static void main(String[] args) {

        Smartphone smartphon = new Smartphone("190","ribamarSource");
        Smartphone smartphon2 = new Smartphone("190","ribamarSource");

        System.out.println(smartphon.equals(smartphon2));;

    }
}
