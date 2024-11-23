package MaratonaJava.zzijdbc.test;

import MaratonaJava.zzijdbc.dominio.Producer;
import MaratonaJava.zzijdbc.repository.ProduceRepositoryRowSet;
import MaratonaJava.zzijdbc.repository.ProducerRepository;
import MaratonaJava.zzijdbc.service.ProduceServiceRowSet;
import MaratonaJava.zzijdbc.service.ProducerService;
import com.mysql.cj.log.Log;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
@Log4j2
public class ConnectionFactoryTest {
    public static void main(String[] args) {

//        Producer studioSousa = Producer.builder().name("studio sousa").build();
//        ProducerService.save(studioSousa);
//
//
        Producer idapagado = Producer.builder().id(7).build();
        ProducerService.delete(idapagado);
//
//        Producer producerUpdate = Producer.builder().name("fagner júnior").id(5).build();
//        ProducerService.update(producerUpdate);
//
//        ProducerService.findAll();
//
//        ProducerService.findByName("gabriela");
//
//        ProducerService.producerResultMetaData();
//
//        ProducerService.showDriverMetaData();
//
//        ProducerService.showTypeScrollWorking();
//
//        ProducerService.findByNameAndUpdate("studio");
//
//        List<Producer> newName = ProducerService.findByNameAndInsertIfNotFOund("kit ferramentas");
//        log.info("impressão do inserção de newName {}",newName);
//
//        //apaga tudo com S
//        List<Producer> listOfDelectedProducers = ProducerService.findByNameAndDelete("S");
//        log.info("deleted producers {}",listOfDelectedProducers);


//        List<Producer> byNameAndPreparedStat = ProducerService.findByNameAndPreparedStat("R");
//        log.info(byNameAndPreparedStat);

//        Producer producerToUpdate = Producer.builder().name("sosassa").id(8).build();
//        ProducerService.updatePrepared(producerToUpdate);


        //ProducerService.findByNameAndInsertIfNotFOund("ribamar");
//
//        List<Producer> listaDosDeAcordoComProcedure = ProducerService.findByNameCallablePreparedStatement("lira");
//        log.info(listaDosDeAcordoComProcedure);
//
//        List<Producer> lista = ProduceRepositoryRowSet.findByNameRowSet("lira");
//        log.info(lista);

       // Producer producer = Producer.builder().name("teste3").id(2).build();
////        ProduceServiceRowSet.updateJdbcRowSet(producer);
//
        //ProduceServiceRowSet.updateCachedRowSet(producer);

//
//        Producer producer1 = Producer.builder().name("teste1").build();
//        Producer producer2 = Producer.builder().name("teste2").build();
//        Producer producer3 = Producer.builder().name("marcosxt").build();
//        ProduceServiceRowSet.saveTransaction(List.of(producer1,producer2,producer3));

    }

}

