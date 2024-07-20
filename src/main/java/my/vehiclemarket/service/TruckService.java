package my.vehiclemarket.service;

import my.vehiclemarket.model.entity.TruckEntity;

import java.util.List;

public interface TruckService {
    List<TruckEntity> findAll();

    TruckEntity findById(Long id);

    TruckEntity save(TruckEntity truck);

    TruckEntity update(TruckEntity truck);

    void delete(Long id);
}
