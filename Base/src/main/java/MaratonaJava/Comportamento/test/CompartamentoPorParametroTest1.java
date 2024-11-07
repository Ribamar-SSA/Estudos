package MaratonaJava.Comportamento.test;

import MaratonaJava.Comportamento.dominio.Car;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CompartamentoPorParametroTest1 {
    private static List<Car> carList = List.of(new Car("amarelo",2005), new Car("black",2003), new Car("vermelho",2007), new Car("green",2010));

    public static void main(String[] args) {

        System.out.println(filterGreenCar(carList));


    }

    public static List<Car> filterGreenCar(List<Car> litaTotal){
        List<Car> cars = new ArrayList<>();

        for(Car c : litaTotal){
            if (c.getColor().equalsIgnoreCase("green"))
                cars.add(c);
        }

        return cars;

    }
}
