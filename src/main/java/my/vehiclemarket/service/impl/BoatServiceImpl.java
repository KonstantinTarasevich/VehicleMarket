package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.entity.BoatEntity;
import my.vehiclemarket.repos.BoatRepository;
import my.vehiclemarket.service.BoatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatServiceImpl implements BoatService {

    private final BoatRepository boatRepository;

    public BoatServiceImpl(BoatRepository boatRepository) {
        this.boatRepository = boatRepository;
    }

    @Override
    public List<BoatEntity> findAll() {
        return boatRepository.findAll();
    }

    @Override
    public BoatEntity findById(Long id) {
        return boatRepository.findById(id).orElse(null);
    }

    @Override
    public BoatEntity save(BoatEntity boat) {
        return boatRepository.save(boat);
    }

    @Override
    public BoatEntity update(BoatEntity boat) {
        return boatRepository.update(boat);
    }

    @Override
    public void delete(Long id) {
        boatRepository.deleteById(id);
    }
}
