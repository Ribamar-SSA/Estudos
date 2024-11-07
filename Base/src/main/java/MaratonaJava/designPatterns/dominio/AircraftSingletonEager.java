package MaratonaJava.designPatterns.dominio;

import java.util.HashSet;
import java.util.Set;

//é final porque espera-se que o conteúdo não seja moificado
//quando a classe é final, não pode extender ela
public final class AircraftSingletonEager {
    //Eager initialization -idêntico à classe
    //é como se a referência para esse objeto não pudesse ser modificada (INSTANCE)
    private static  final AircraftSingletonEager INSTANCE = new AircraftSingletonEager("877-52");


    private Set<String> assentos =new  HashSet<>();
    private  final String modelo ;
    private boolean status = false;

    public static AircraftSingletonEager getINSTANCE() {
        return INSTANCE;
    }

    //obrigatoriamente privado!!!
    private AircraftSingletonEager(String modelo) {
        this.modelo = modelo;
    }

    {
        assentos.add("1A");
        assentos.add("1B");

    }

    public boolean comprarAssento(String assento){

        return assentos.remove(assento);
    }

    public Set<String> getAssentos() {
        return assentos;
    }

    public void setAssentos(Set<String> assentos) {
        this.assentos = assentos;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isStatus() {
        return status;
    }

    public void revisao(){
        status = true;
    }
}
