package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.dto.MotorcycleEntityDTO;
import my.vehiclemarket.model.entity.MotorcycleEntity;
import my.vehiclemarket.repository.MotorcycleRepository;
import my.vehiclemarket.service.MotorcycleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {

    private final MotorcycleRepository motorcycleRepository;
    private final ModelMapper modelMapper;

    public MotorcycleServiceImpl(MotorcycleRepository motorcycleRepository, ModelMapper modelMapper) {
        this.motorcycleRepository = motorcycleRepository;
        this.modelMapper = modelMapper;
    }

    public List<MotorcycleEntityDTO> findAll() {
        return motorcycleRepository.findAll().stream()
                .map(motorcycle -> modelMapper.map(motorcycle, MotorcycleEntityDTO.class))
                .collect(Collectors.toList());
    }

    public MotorcycleEntityDTO findById(Long id) {
        MotorcycleEntity motorcycle = motorcycleRepository.findById(id).orElse(null);
        return motorcycle != null ? modelMapper.map(motorcycle, MotorcycleEntityDTO.class) : null;
    }

    public MotorcycleEntityDTO save(MotorcycleEntityDTO motorcycleDTO) {
        MotorcycleEntity motorcycle = modelMapper.map(motorcycleDTO, MotorcycleEntity.class);
        motorcycle = motorcycleRepository.save(motorcycle);
        return modelMapper.map(motorcycle, MotorcycleEntityDTO.class);
    }

    public MotorcycleEntityDTO update(Long id, MotorcycleEntityDTO motorcycleDTO) {
        MotorcycleEntity existingMotorcycle = motorcycleRepository.findById(id).orElse(null);
        if (existingMotorcycle != null) {
            modelMapper.map(motorcycleDTO, existingMotorcycle);
            existingMotorcycle = motorcycleRepository.save(existingMotorcycle);
            return modelMapper.map(existingMotorcycle, MotorcycleEntityDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        motorcycleRepository.deleteById(id);
    }
}
