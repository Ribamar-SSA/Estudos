package MaratonaJava.ZZKjunit.test;

import MaratonaJava.ZZKjunit.dominio.Person;
import MaratonaJava.ZZKjunit.service.PersonService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonServiceTest1 {
    public static void main(String[] args) {
        Person person  = new Person(15);
        boolean adult = PersonService.isAdult(person);
        log.info("person is adult ? {}",adult);

    }
}
