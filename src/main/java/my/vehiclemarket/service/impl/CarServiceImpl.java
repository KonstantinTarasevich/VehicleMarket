package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.dto.CarEntityDTO;
import my.vehiclemarket.model.entity.CarEntity;
import my.vehiclemarket.repos.CarRepository;
import my.vehiclemarket.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
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

    public CarEntityDTO save(CarEntityDTO carDTO) {
        CarEntity car = modelMapper.map(carDTO, CarEntity.class);
        car = carRepository.save(car);
        return modelMapper.map(car, CarEntityDTO.class);
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
