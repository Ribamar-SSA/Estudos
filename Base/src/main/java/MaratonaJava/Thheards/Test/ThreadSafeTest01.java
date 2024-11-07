package MaratonaJava.Thheards.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class ThreadSafeNames{


    //não adianta nada a classe ter o métodos thread safe se o meus não são
    //Collections.synchronizedList(new ArrayList<>());
    private final List<String> names = new ArrayList<>();

    public synchronized void add (String n){
        names.add(n);
    }

    public synchronized void removeFirst(){
        if(!names.isEmpty())
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));;
    }
}

public class ThreadSafeTest01 {


    public static void main(String[] args) {
        ThreadSafeNames threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("ribamar");
        threadSafeNames.removeFirst();

        Runnable r = ()  -> {threadSafeNames.removeFirst();};
        new Thread(r).start();
        new Thread(r).start();

    }
}
