package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.dto.CarEntityDTO;
import my.vehiclemarket.model.entity.CarEntity;
import my.vehiclemarket.model.entity.UserEntity;
import my.vehiclemarket.model.enums.EngineTypeEnum;
import my.vehiclemarket.model.enums.TransmissionTypeEnum;
import my.vehiclemarket.repository.CarRepository;
import my.vehiclemarket.repository.UserRepository;
import my.vehiclemarket.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserServiceImpl userServiceImpl;


    public CarServiceImpl(CarRepository carRepository, UserRepository userRepository, ModelMapper modelMapper, UserServiceImpl userServiceImpl) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userServiceImpl = userServiceImpl;
    }

    public List<CarEntityDTO> findAll() {
        return carRepository.findAll().stream()
                .map(car -> modelMapper.map(car, CarEntityDTO.class))
                .collect(Collectors.toList());
    }

    public CarEntityDTO findById(Long id) {
        CarEntity car = carRepository.findById(id).orElse(null);
        return car != null ? modelMapper.map(car, CarEntityDTO.class) : null;
    }

    public boolean save(CarEntityDTO data) {
        CarEntity car = modelMapper.map(data, CarEntity.class);

        UserEntity owner = userServiceImpl.getCurrentUser();
        car.setOwner(owner);
        car.setDaysActive(0);

        if (car.getEngineType().equals(EngineTypeEnum.ELECTRIC)) {
            car.setFuelConsumption(0);
            car.setTransmissionType(TransmissionTypeEnum.AUTOMATIC);
        }

        carRepository.save(car);

        return true;
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
