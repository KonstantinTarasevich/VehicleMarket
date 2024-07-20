package my.vehiclemarket.service;

import my.vehiclemarket.model.entity.MotorcycleEntity;

import java.util.List;

public interface MotorcycleService {
    List<MotorcycleEntity> findAll();

    MotorcycleEntity findById(Long id);

    MotorcycleEntity save(MotorcycleEntity motorcycle);

    MotorcycleEntity update(MotorcycleEntity motorcycle);

    void delete(Long id);
}
