package peaksoft.dao;

import peaksoft.model.Car;
import peaksoft.model.Person;

import java.util.List;

public interface PersonDao {
    void savePerson(Person person);

    Person getPersonById(Long id);

    void updatePerson(Long id,Person person);

    void deletePersonById(Long id);
}
