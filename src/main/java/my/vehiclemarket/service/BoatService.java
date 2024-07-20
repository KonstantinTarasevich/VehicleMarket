package my.vehiclemarket.service;

import my.vehiclemarket.model.entity.BoatEntity;

import java.util.List;

public interface BoatService {
    List<BoatEntity> findAll();

    BoatEntity findById(Long id);

    BoatEntity save(BoatEntity boat);

    BoatEntity update(BoatEntity boat);

    void delete(Long id);
}
