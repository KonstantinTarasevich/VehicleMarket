package my.vehiclemarket.service;

import my.vehiclemarket.model.entity.CarEntity;

import java.util.List;

public interface CarService {
    List<CarEntity> findAll();

    CarEntity findById(Long id);

    CarEntity save(CarEntity car);

    CarEntity update(CarEntity car);

    void delete(Long id);
}
