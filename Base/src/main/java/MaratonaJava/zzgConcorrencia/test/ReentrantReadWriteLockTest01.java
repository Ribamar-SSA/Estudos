package MaratonaJava.zzgConcorrencia.test;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite{
    private final Map<String, String> stringMap = new LinkedHashMap<>();
    private final ReentrantReadWriteLock rww;


    MapReadWrite(ReentrantReadWriteLock rrwl) {
        this.rww = rrwl;
    }
    public void put(String key, String value){
        rww.writeLock().lock();
        try {
            if(rww.isWriteLocked()){
                System.out.printf("%s obteve o write lock", Thread.currentThread().getName());
            }

            stringMap.put(key,value);

        }finally {
            rww.writeLock().unlock();
        }

    }


    public Set<String> AllKeys(){
        rww.readLock().lock();
        try {
            return stringMap.keySet();
        }finally {
            rww.readLock().unlock();
        }
    }
}

public class ReentrantReadWriteLockTest01 {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        MapReadWrite mapReadWrite = new MapReadWrite(reentrantReadWriteLock);

        Runnable writer = ()->{
            for (int i = 0; i < 20; i++) {
                mapReadWrite.put(String.valueOf(i),String.valueOf(i+1));
            }

        };

        Runnable reader = () -> {
            if(reentrantReadWriteLock.isWriteLocked()){
                System.out.println("WRITE LOCKED");
            }
             reentrantReadWriteLock.readLock().lock();
            System.out.println("READING");
            try {
                System.out.println(mapReadWrite.AllKeys());
            }finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        };

        Thread t1 = new Thread(reader);
        Thread t2 = new Thread(reader);
        Thread r1 = new Thread(writer);

        r1.start();
        t1.start();
        t2.start();







    }
}
