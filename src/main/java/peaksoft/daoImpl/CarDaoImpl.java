package peaksoft.daoImpl;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.dao.CarDao;
import peaksoft.model.Car;
import peaksoft.model.Person;
import peaksoft.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {

    private final SessionFactory sessionFactory = Util.createSessionFactory();
    @Override
    public void saveCar(Long PersonId, Car car) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Person person = session.find(Person.class,PersonId);
            car.setPerson(person);
            person.add(car);
            session.merge(person);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateCar(Long id, Car car) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Car updatedCar = session.find(Car.class, id);
            updatedCar.setColor(car.getColor());
            updatedCar.setModel(car.getModel());
            updatedCar.setNumber(car.getNumber());
            session.merge(updatedCar);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteCarById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Car car = session.get(Car.class,id);
            car.setPerson(null);
            session.remove(car);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public Car getCarById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Car car = session.find(Car.class, id);
            session.getTransaction().commit();
            session.close();
            return car;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Car> getCarsByPersonId(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Person person = session.find(Person.class,id);
            List<Car> carList = person.getCars();
            session.getTransaction().commit();
            session.close();
            return carList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Car> getCarsByPersonName(String name) { // Ushul method kyiyn boldu!
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Person> personList = session.createQuery("select u from Person u").list();
            Person person = null;
            for (Person i : personList) {
                if (i.getName().equals(name)){
                    List<Person> personList2 = session.createQuery("select c from Person c where c.id = :id", Person.class).setParameter("id", i.getId()).list();
                    person = personList2.get(0);
                }
            }
            List<Car> cars = new ArrayList<>(person.getCars());
            session.getTransaction().commit();
            return cars;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
