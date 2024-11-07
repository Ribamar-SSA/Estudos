package MaratonaJava.zzgConcorrencia.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/*
       classe imutável
       -final
       --remover toda e qualquer forma de acesso para trocar os atributos

    */
final class Anime{
    String nome;

    public String getNome() {
        return nome;
    }

    public Anime(String nome) {
        this.nome = nome;
    }
}
public class CopyOnWriteArrayList2 {

    public static void main(String[] args) {
        List<Integer> integerList = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 2000; i++) {
            integerList.add(i);
        }

        Runnable runnableIterator = () -> {
            Iterator<Integer> iterator = integerList.iterator();
            try {
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        };

        Runnable runnableRemove = () -> {
            for (int i = 0; i < 500; i++) {
                //integerList.remove(i);
                System.out.printf("%s removed %s%n",Thread.currentThread().getName(),i);
                integerList.remove(i);
            }
        };

        Thread thIterator = new Thread(runnableIterator);
        Thread thRemove = new Thread(runnableRemove);

        thRemove.start();
        thIterator.start();



    }

}
