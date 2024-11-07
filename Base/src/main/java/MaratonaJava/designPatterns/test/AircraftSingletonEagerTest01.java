package MaratonaJava.designPatterns.test;


import MaratonaJava.designPatterns.dominio.AircraftSingletonEager;

public class AircraftSingletonEagerTest01 {
    public static void main(String[] args) {
        //vai retornar true porque estamos criando dois objetos, quando na verdade só existe uma aeronave
        comprarAssento("1A");
        comprarAssento("1A");
        mudarStatus();


    }

    //só tem uma forma de pega o objeto dda classe AircraftSingletonEager , que é usando o:
    //AircraftSingletonEager.getINSTANCE();
    //e aí podemos modificar ele


    private static void comprarAssento(String seat){
        AircraftSingletonEager aircraft = AircraftSingletonEager.getINSTANCE();
        System.out.println(aircraft.comprarAssento(seat));
    }

    private static void mudarStatus(){
        AircraftSingletonEager aircraft2 = AircraftSingletonEager.getINSTANCE();
        System.out.println("assentos:");
        System.out.println(aircraft2.getAssentos());
        System.out.println("status:");
        System.out.println(aircraft2.isStatus());
        aircraft2.revisao();
        System.out.println("status:");
        System.out.println(aircraft2.isStatus());
    }
}
