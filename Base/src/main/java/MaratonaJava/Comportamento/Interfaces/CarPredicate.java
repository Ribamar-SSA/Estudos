package MaratonaJava.Comportamento.Interfaces;

import MaratonaJava.Comportamento.dominio.Car;

import java.util.function.Predicate;


//Funcional interface
public class CarPredicate  {

    public boolean test(Car car) {
        //(parametro) -> expressão
        //(Car car) -> car.getColor().equals("green");
        return false;
    }
}
