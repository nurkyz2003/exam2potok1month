package peaksoft.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.dao.PersonDao;
import peaksoft.model.Car;
import peaksoft.model.Person;
import peaksoft.util.Util;

public class PersonDaoImpl implements PersonDao {

    private final EntityManagerFactory entityManagerFactory = Util.createEntityManagerFactory();
    private final SessionFactory sessionFactory = Util.createSessionFactory();
    @Override
    public void savePerson(Person person) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.persist(new Person(person.getName(),person.getLastName(),person.getAge()));
            session.getTransaction().commit();
        }
    }

    @Override
    public Person getPersonById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Person person = session.find(Person.class,id);
            session.getTransaction().commit();
            session.close();
            return person;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updatePerson(Long id, Person person) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Person updatedPerson = session.find(Person.class, id);
            updatedPerson.setName(person.getName());
            updatedPerson.setLastName(person.getLastName());
            updatedPerson.setAge(person.getAge());
            updatedPerson.setCars(person.getCars());
            updatedPerson.setSocialMedias(person.getSocialMedias());
            session.merge(updatedPerson);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletePersonById(Long id) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Person person = entityManager.find(Person.class,id);
            for (Car car : person.getCars()) {
                car.setPerson(null);
            }
            entityManager.remove(person);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }    }
}
