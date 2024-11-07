package MaratonaJava.lambdas.test;

import MaratonaJava.Comportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;

public class LambdaTest1 {

    // a Consumer executa uma ação e não retorna nada e podemos
    //implementar usando classes anonimas ou lambdas

    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>(List.of(new Car("amarelo",2005), new Car("black",2003), new Car("vermelho",2007), new Car("green",2010)));


        //usando classes anônimas

        forEach(carList, new Consumer<Car>() {
            @Override
            public void accept(Car car) {
                System.out.println(car);
            }
        });


        //usando lambda

        System.out.println("lambda");
        forEach(carList,(Car car) -> System.out.println(car));
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer){
        for(T t : list){
            consumer.accept(t);
        }

    }
}
