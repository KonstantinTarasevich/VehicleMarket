package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.dto.BoatEntityDTO;
import my.vehiclemarket.model.dto.CarEntityDTO;
import my.vehiclemarket.model.entity.BoatEntity;
import my.vehiclemarket.model.entity.CarEntity;
import my.vehiclemarket.model.entity.UserEntity;
import my.vehiclemarket.model.enums.EngineTypeEnum;
import my.vehiclemarket.model.enums.TransmissionTypeEnum;
import my.vehiclemarket.repository.BoatRepository;
import my.vehiclemarket.service.BoatService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoatServiceImpl implements BoatService {

    private final BoatRepository boatRepository;
    private final ModelMapper modelMapper;
    private final UserServiceImpl userServiceImpl;

    public BoatServiceImpl(BoatRepository boatRepository, ModelMapper modelMapper, UserServiceImpl userServiceImpl) {
        this.boatRepository = boatRepository;
        this.modelMapper = modelMapper;
        this.userServiceImpl = userServiceImpl;
    }

    public boolean save(BoatEntityDTO data) {


        BoatEntity boat = new BoatEntity();
        boat.setName(data.getName());
        boat.setBrand(data.getBrand());
        boat.setImageURL(data.getImageURL());
        boat.setModel(data.getModel());
        boat.setPrice(data.getPrice());
        boat.getBoatType(data.getBoatType());
        UserEntity owner = userServiceImpl.getCurrentUser();
        boat.setOwner(owner);
        boat.setDescription(data.getDescription());
        boat.setProductionYear(data.getProductionYear());
        boat.setDaysActive(0);
        boat.setFuelConsumption(data.getFuelConsumption());

        boatRepository.save(boat);


        return true;
    }

    public void delete(Long id) {
        boatRepository.deleteById(id);
    }
}
