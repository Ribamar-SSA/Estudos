package MaratonaJava.zzijdbc.service;

import MaratonaJava.zzijdbc.dominio.Producer;
import MaratonaJava.zzijdbc.repository.ProduceRepositoryRowSet;
import MaratonaJava.zzijdbc.repository.ProducerRepository;

import java.util.List;

public class ProduceServiceRowSet {
    public static List<Producer> findByNameRowSet(String stringName){
        return ProduceRepositoryRowSet.findByNameRowSet( stringName);
    }

    public static void updateJdbcRowSet(Producer producer){
         ProduceRepositoryRowSet.updateJdbcRowSet(producer);
    }
    public static void updateCachedRowSet(Producer producer){
         ProduceRepositoryRowSet.updateCachedRowSet(producer);
    }



    public static void saveTransaction(List<Producer> producerList){
        ProducerRepository.saveTransaction(producerList);

    }
}
