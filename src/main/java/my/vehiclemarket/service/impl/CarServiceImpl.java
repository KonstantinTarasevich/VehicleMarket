package my.vehiclemarket.service.impl;

import my.vehiclemarket.config.UserSession;
import my.vehiclemarket.model.dto.CarEntityDTO;
import my.vehiclemarket.model.entity.CarEntity;
import my.vehiclemarket.model.entity.UserEntity;
import my.vehiclemarket.model.enums.EngineTypeEnum;
import my.vehiclemarket.model.enums.TransmissionTypeEnum;
import my.vehiclemarket.repos.CarRepository;
import my.vehiclemarket.repos.UserRepository;
import my.vehiclemarket.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserSession userSession;

    public CarServiceImpl(CarRepository carRepository, UserRepository userRepository, ModelMapper modelMapper, UserSession userSession) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userSession = userSession;
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
        if (!userSession.isLoggedIn()) {
            return false;
        }

        Optional<UserEntity> byId = userRepository.findById(userSession.id());

        if (byId.isEmpty()) {
            return false;
        }

        CarEntity car = new CarEntity();
        car.setName(data.getName());
        car.setBrand(data.getBrand());
        car.setImageURL(data.getImageURL());
        car.setModel(data.getModel());
        car.setPrice(data.getPrice());
        car.setCarType(data.getCarType());
        car.setOwner(byId.get());
        car.setEngineType(data.getEngineType());
        car.setHorsePower(data.getHorsePower());
        car.setCarType(data.getCarType());
        car.setDescription(data.getDescription());
        car.setProductionYear(data.getProductionYear());
        car.setDaysActive(0);
        if (car.getEngineType().equals(EngineTypeEnum.ELECTRIC)){
            car.setFuelConsumption(0);
            car.setTransmissionType(TransmissionTypeEnum.AUTOMATIC);
        }
        car.setTransmissionType(data.getTransmissionType());
        car.setFuelConsumption(data.getFuelConsumption());

        carRepository.save(car);

        return true;
    }

    public CarEntityDTO update(Long id, CarEntityDTO carDTO) {
        CarEntity existingCar = carRepository.findById(id).orElse(null);
        if (existingCar != null) {
            modelMapper.map(carDTO, existingCar);
            existingCar = carRepository.save(existingCar);
            return modelMapper.map(existingCar, CarEntityDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
