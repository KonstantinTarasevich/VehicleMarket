package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.entity.MotorcycleEntity;
import my.vehiclemarket.repos.MotorcycleRepository;
import my.vehiclemarket.service.MotorcycleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {

    private final MotorcycleRepository motorcycleRepository;

    public MotorcycleServiceImpl(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    @Override
    public List<MotorcycleEntity> findAll() {
        return motorcycleRepository.findAll();
    }

    @Override
    public MotorcycleEntity findById(Long id) {
        return motorcycleRepository.findById(id).orElse(null);
    }


    @Override
    public MotorcycleEntity save(MotorcycleEntity motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    @Override
    public MotorcycleEntity update(MotorcycleEntity motorcycle) {
        return motorcycleRepository.update(motorcycle);
    }

    @Override
    public void delete(Long id) {
        motorcycleRepository.deleteById(id);
    }
}
