package peaksoft.serviceImpl;

import peaksoft.dao.CarDao;
import peaksoft.daoImpl.CarDaoImpl;
import peaksoft.model.Car;
import peaksoft.service.CarService;

import java.util.List;

public class CarImpl implements CarService {
    private final CarDao carDao = new CarDaoImpl();

    @Override
    public void saveCar(Long PersonId, Car car) {
        carDao.saveCar(PersonId,car);
    }

    @Override
    public void updateCar(Long id, Car car) {
        carDao.updateCar(id,car);
    }

    @Override
    public void deleteCarById(Long id) {
        carDao.deleteCarById(id);
    }

    @Override
    public Car getCarById(Long id) {
        return carDao.getCarById(id);
    }

    @Override
    public List<Car> getCarsByPersonId(Long id) {
        return carDao.getCarsByPersonId(id);
    }

    @Override
    public List<Car> getCarsByPersonName(String name) {
        return carDao.getCarsByPersonName(name);
    }

}
