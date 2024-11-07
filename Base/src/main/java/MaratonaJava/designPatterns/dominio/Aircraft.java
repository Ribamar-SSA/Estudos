package MaratonaJava.designPatterns.dominio;

import java.util.HashSet;
import java.util.Set;

public class Aircraft {
    private final Set<String> assentos = new HashSet<>();

    {
        assentos.add("1A");
        assentos.add("1B");

    }

    public boolean comprarAssento(String seat){
        return  assentos.remove(seat);
    }



}
