package MaratonaJava.ZZKjunit.service;

import MaratonaJava.ZZKjunit.dominio.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private Person adult;
    private Person notAdult;
    private PersonService personService;

    //cada teste é independente(teria que criar para cada um objetos diferentes)
    @BeforeEach
        public void setUp(){
         adult = new Person(19);
         notAdult = new Person(15);
         personService = new PersonService();
    }
    @Test
    @DisplayName("se ele for menor, tem que retornar falso")
    void isAdult_Return_true_when_personIsLess_than_18() {

        PersonService personService = new PersonService();
        Assertions.assertFalse(personService.isAdult(notAdult));
    }

    @Test
    @DisplayName("if he be greater or equal to 18 should be True ")
    void isAdult_return_false_when_personIsGreaterThan18(){
        PersonService personService = new PersonService();
        Assertions.assertTrue(personService.isAdult(adult));
    }
    @Test
    @DisplayName("when a person is null should throws nullpointerException ")
    void isAdult_should_nullpointerexception_when_pers_isNull(){
        PersonService personService = new PersonService();
        Assertions.assertThrows(NullPointerException.class,() -> personService.isAdult(null),"person can´t be null");
    }
    @Test
    @DisplayName("should return list wih only adults ")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed(){
        Person person2 = new Person(21);
        Person person1 = new Person(12);
        Person person = new Person(19);
        Assertions.assertEquals(2,personService.filterRemovingNotAdult(List.of(person,person1,person2)).size());

    }



}