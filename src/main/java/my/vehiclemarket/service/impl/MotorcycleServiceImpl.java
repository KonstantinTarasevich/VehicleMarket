package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.dto.MotorcycleEntityDTO;
import my.vehiclemarket.model.entity.MotorcycleEntity;
import my.vehiclemarket.model.entity.UserEntity;
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
    private final UserServiceImpl userServiceImpl;

    public MotorcycleServiceImpl(MotorcycleRepository motorcycleRepository, ModelMapper modelMapper, UserServiceImpl userServiceImpl) {
        this.motorcycleRepository = motorcycleRepository;
        this.modelMapper = modelMapper;
        this.userServiceImpl = userServiceImpl;
    }

    public List<MotorcycleEntityDTO> findAll() {
        return motorcycleRepository.findAll().stream()
                .map(motorcycle -> modelMapper.map(motorcycle, MotorcycleEntityDTO.class))
                .collect(Collectors.toList());
    }

    public boolean save(MotorcycleEntityDTO data) {
        MotorcycleEntity motorcycle = modelMapper.map(data, MotorcycleEntity.class);

        UserEntity owner = userServiceImpl.getCurrentUser();
        motorcycle.setOwner(owner);
        motorcycle.setDaysActive(0);

        motorcycleRepository.save(motorcycle);

        return true;
    }

    public void delete(Long id) {
        motorcycleRepository.deleteById(id);
    }
}
