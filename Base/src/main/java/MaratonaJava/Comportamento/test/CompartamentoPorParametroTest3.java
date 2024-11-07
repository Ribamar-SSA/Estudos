package MaratonaJava.Comportamento.test;

import MaratonaJava.Comportamento.Interfaces.CarPredicate;
import MaratonaJava.Comportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CompartamentoPorParametroTest3 {
    private static List<Car> carList = List.of(new Car("amarelo",2005), new Car("black",2003), new Car("vermelho",2007), new Car("green",2010));

    public static void main(String[] args) {

        List<Car> filterCarVerde= filterCar(carList,new Predicate<Car>(){
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("green");
            }
        });

        System.out.println(filterCarVerde);

        //aqui criamos uma sub-classe
        //agora usando a interface Predicate real
        List<Car> filterCarVermelho= filterCar(carList,new Predicate<Car>(){
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
    //method super geérico agora
    public static <T>List<T> filterCar(List<T> listaTotal, Predicate<T> predicate){
        List<T> fiteredThings = new ArrayList<>();

        for(T t: listaTotal){

            if(predicate.test(t)){
                fiteredThings.add(t);
            }
        }

        return fiteredThings;

    }
}
