package MaratonaJava.Comportamento.test;

import MaratonaJava.Comportamento.Interfaces.CarPredicate;
import MaratonaJava.Comportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class CompartamentoPorParametroTest2 {
    private static List<Car> carList = List.of(new Car("amarelo",2005), new Car("black",2003), new Car("vermelho",2007), new Car("green",2010));

    public static void main(String[] args) {

        List<Car> filterCarVerde= filterCar(carList,new CarPredicate(){
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("green");
            }
        });

        System.out.println(filterCarVerde);

        //aqui criamos uma sub-classe
        List<Car> filterCarVermelho= filterCar(carList,new CarPredicate(){
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("vermelho");
            }
        });

        System.out.println("vermelho");
        System.out.println(filterCarVermelho);




    }
    //usando o Predicate para melhorar a manutenção do código
    // a regra de negócio seria um if

    public static List<Car> filterCar(List<Car> listaTotal, CarPredicate carPredicate){
        List<Car> filteredCars = new ArrayList<>();

        for(Car c: listaTotal){
            if(carPredicate.test(c)){
                filteredCars.add(c);
            }
        }

        return filteredCars;

    }
}
