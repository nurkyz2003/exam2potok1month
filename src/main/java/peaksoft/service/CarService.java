package peaksoft.service;

import peaksoft.model.Car;

import java.util.List;

public interface CarService {
    void saveCar(Long PersonId, Car car);

    void updateCar(Long id,Car car);

    void deleteCarById(Long id);

    Car getCarById(Long id);

    List<Car> getCarsByPersonId(Long id);

    List<Car> getCarsByPersonName(String name);

}
