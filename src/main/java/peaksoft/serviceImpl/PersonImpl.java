package peaksoft.serviceImpl;

import peaksoft.dao.PersonDao;
import peaksoft.daoImpl.PersonDaoImpl;
import peaksoft.model.Person;
import peaksoft.service.PersonService;

public class PersonImpl implements PersonService {
    private final PersonDao personDao = new PersonDaoImpl();

    @Override
    public void savePerson(Person person) {
        personDao.savePerson(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return personDao.getPersonById(id);
    }

    @Override
    public void updatePerson(Long id, Person person) {
        personDao.updatePerson(id,person);
    }

    @Override
    public void deletePersonById(Long id) {
        personDao.deletePersonById(id);
    }
}
