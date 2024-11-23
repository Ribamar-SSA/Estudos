package MaratonaJava.ZZKjunit.service;

import MaratonaJava.ZZKjunit.dominio.Person;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PersonService {
    public static boolean isAdult(Person person){
        Objects.requireNonNull(person,"person can´t be null");
        return person.getAge()>=18;
    }

    public List<Person>  filterRemovingNotAdult(List<Person> personList){
        return personList.stream().filter(PersonService::isAdult).collect(Collectors.toList());
    }
}
