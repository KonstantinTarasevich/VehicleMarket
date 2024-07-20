package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.entity.CarEntity;
import my.vehiclemarket.repos.CarRepository;
import my.vehiclemarket.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarEntity> findAll() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public CarEntity save(CarEntity car) {
        return carRepository.save(car);
    }

    @Override
    public CarEntity update(CarEntity car) {
        return carRepository.update(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
