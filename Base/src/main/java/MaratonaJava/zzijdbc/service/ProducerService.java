package MaratonaJava.zzijdbc.service;

import MaratonaJava.zzijdbc.dominio.Producer;
import MaratonaJava.zzijdbc.repository.ProducerRepository;

import java.util.List;

public class ProducerService {
    public static void save(Producer producer){
        ProducerRepository.save(producer);

    }

    public static void delete(Producer producer){
        requireId(producer);
        ProducerRepository.delete(producer);

    }

    public static void update(Producer producer){
        requireId(producer);
        ProducerRepository.update(producer);

    }

    public static void requireId(Producer producer){
        if(producer.getId()==null || producer.getId()<=0){
            throw new IllegalArgumentException("illegal argument exception");
        }
    }

    public static void findAll(){
        List<Producer> all = ProducerRepository.findAll();
        all.forEach(System.out::println);
    }

    public static void findByName(String name){
        List<Producer> all = ProducerRepository.findByName(name);
        all.forEach(System.out::println);
    }
    public static List<Producer> findByNameAndPreparedStat(String name){
       return ProducerRepository.findByNameAndPreparedStatement(name);

    }

    public static void producerResultMetaData(){
        ProducerRepository.showProducerResultMetaData();
    }

    public static void showDriverMetaData(){
        ProducerRepository.showDriverMetaData();
    }


    public static void showTypeScrollWorking(){
        ProducerRepository.showTypeScrollWorking();
    }

    public static List<Producer> findByNameAndUpdate(String stringName ){
       return  ProducerRepository.findByNameAndUpdate(stringName);

    }

    public static List<Producer> findByNameAndInsertIfNotFOund(String stringName){
        return ProducerRepository.findByNameAndInsertIfNotFOund(stringName);
    }

    public static List<Producer> findByNameAndDelete(String stringName){
        return ProducerRepository.findByNameAndDelete(stringName);
    }

     public static void updatePrepared(Producer producer){
        ProducerRepository.updatePrepared(producer);
     }

    public static List<Producer> findByNameCallablePreparedStatement(String stringName ){
        return ProducerRepository.findByNameCallablePreparedStatement(stringName);
    }


}
