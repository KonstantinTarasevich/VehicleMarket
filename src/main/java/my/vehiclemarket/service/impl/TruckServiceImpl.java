package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.dto.MotorcycleEntityDTO;
import my.vehiclemarket.model.dto.TruckEntityDTO;
import my.vehiclemarket.model.entity.MotorcycleEntity;
import my.vehiclemarket.model.entity.TruckEntity;
import my.vehiclemarket.model.entity.UserEntity;
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
    private final UserServiceImpl userServiceImpl;

    public TruckServiceImpl(TruckRepository truckRepository, ModelMapper modelMapper, UserServiceImpl userServiceImpl) {
        this.truckRepository = truckRepository;
        this.modelMapper = modelMapper;
        this.userServiceImpl = userServiceImpl;
    }

    public List<TruckEntityDTO> findAll() {
        return truckRepository.findAll().stream()
                .map(truck -> modelMapper.map(truck, TruckEntityDTO.class))
                .collect(Collectors.toList());
    }

    public boolean save(TruckEntityDTO data) {


        TruckEntity truck = new TruckEntity();
        truck.setName(data.getName());
        truck.setBrand(data.getBrand());
        truck.setImageURL(data.getImageURL());
        truck.setModel(data.getModel());
        truck.setPrice(data.getPrice());
        truck.setTruckType(data.getTruckType());
        UserEntity owner = userServiceImpl.getCurrentUser();
        truck.setOwner(owner);
        truck.setDescription(data.getDescription());
        truck.setProductionYear(data.getProductionYear());
        truck.setDaysActive(0);
        truck.setFuelConsumption(data.getFuelConsumption());
        truck.setLoadCapacity(data.getLoadCapacity());

        truckRepository.save(truck);


        return true;
    }

    public void delete(Long id) {
        truckRepository.deleteById(id);
    }
}
