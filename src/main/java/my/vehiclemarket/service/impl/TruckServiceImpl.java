package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.dto.TruckEntityDTO;
import my.vehiclemarket.model.entity.TruckEntity;
import my.vehiclemarket.repository.TruckRepository;
import my.vehiclemarket.service.TruckService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TruckServiceImpl implements TruckService {

    private final TruckRepository truckRepository;
    private final ModelMapper modelMapper;

    public TruckServiceImpl(TruckRepository truckRepository, ModelMapper modelMapper) {
        this.truckRepository = truckRepository;
        this.modelMapper = modelMapper;
    }

    public List<TruckEntityDTO> findAll() {
        return truckRepository.findAll().stream()
                .map(truck -> modelMapper.map(truck, TruckEntityDTO.class))
                .collect(Collectors.toList());
    }

    public TruckEntityDTO findById(Long id) {
        TruckEntity truck = truckRepository.findById(id).orElse(null);
        return truck != null ? modelMapper.map(truck, TruckEntityDTO.class) : null;
    }

    public TruckEntityDTO save(TruckEntityDTO truckDTO) {
        TruckEntity truck = modelMapper.map(truckDTO, TruckEntity.class);
        truck = truckRepository.save(truck);
        return modelMapper.map(truck, TruckEntityDTO.class);
    }

    public TruckEntityDTO update(Long id, TruckEntityDTO truckDTO) {
        TruckEntity existingTruck = truckRepository.findById(id).orElse(null);
        if (existingTruck != null) {
            modelMapper.map(truckDTO, existingTruck);
            existingTruck = truckRepository.save(existingTruck);
            return modelMapper.map(existingTruck, TruckEntityDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        truckRepository.deleteById(id);
    }
}
