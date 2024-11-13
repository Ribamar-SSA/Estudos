package MaratonaJava.zzijdbc.test;

import MaratonaJava.zzijdbc.dominio.Producer;
import MaratonaJava.zzijdbc.repository.ProducerRepository;
import MaratonaJava.zzijdbc.service.ProducerService;
import com.mysql.cj.log.Log;
import lombok.extern.log4j.Log4j2;

import java.util.List;
@Log4j2
public class ConnectionFactoryTest {
    public static void main(String[] args) {

//        Producer studioSousa = Producer.builder().name("studio sousa").build();
//        ProducerService.save(studioSousa);
//
//
//        Producer idapagado = Producer.builder().id(22).build();
//        ProducerService.delete(idapagado);
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

        Producer producerToUpdate = Producer.builder().name("larissa").id(71).build();
        ProducerService.updatePrepared(producerToUpdate);


        
    }
}

