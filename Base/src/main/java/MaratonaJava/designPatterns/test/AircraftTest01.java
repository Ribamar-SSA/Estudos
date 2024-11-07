package MaratonaJava.designPatterns.test;

import MaratonaJava.designPatterns.dominio.Aircraft;

public class AircraftTest01 {
    public static void main(String[] args) {
        //vai retornar true porque estamos criando dois objetos, quando na verdade só existe uma aeronave
        comprarAssento("1A");
        comprarAssento("1A");

    }

    private static void comprarAssento(String seat){
        Aircraft aircraft = new Aircraft();
        System.out.println(aircraft.comprarAssento(seat));
    }
}
