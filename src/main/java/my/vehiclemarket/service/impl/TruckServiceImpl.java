package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.entity.TruckEntity;
import my.vehiclemarket.repos.TruckRepository;
import my.vehiclemarket.service.TruckService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckServiceImpl implements TruckService {

    private TruckRepository truckRepository;

    @Override
    public List<TruckEntity> findAll() {
        return truckRepository.findAll();
    }

    @Override
    public TruckEntity findById(Long id) {
        return truckRepository.findById(id).orElse(null);
    }

    @Override
    public TruckEntity save(TruckEntity truck) {
        return truckRepository.save(truck);
    }

    @Override
    public TruckEntity update(TruckEntity truck) {
        return truckRepository.update(truck);
    }

    @Override
    public void delete(Long id) {
        truckRepository.deleteById(id);
    }
}
