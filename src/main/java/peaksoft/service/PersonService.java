package peaksoft.service;

import peaksoft.model.Person;

public interface PersonService {
    void savePerson(Person person);

    Person getPersonById(Long id);

    void updatePerson(Long id,Person person);

    void deletePersonById(Long id);
}
