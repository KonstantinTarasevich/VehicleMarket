package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.dto.*;
import my.vehiclemarket.model.entity.BoatEntity;
import my.vehiclemarket.model.entity.MotorcycleEntity;
import my.vehiclemarket.model.entity.TruckEntity;
import my.vehiclemarket.model.entity.UserEntity;
import my.vehiclemarket.repository.TruckRepository;
import my.vehiclemarket.service.TruckService;
import my.vehiclemarket.service.exception.ObjectNotFoundException;
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
        TruckEntity truck = modelMapper.map(data, TruckEntity.class);

        UserEntity owner = userServiceImpl.getCurrentUser();
        truck.setOwner(owner);
        truck.setDaysActive(0);

        truckRepository.save(truck);

        return true;
    }


    public void delete(Long id) {
        truckRepository.deleteById(id);
    }

    @Override
    public List<TruckSummaryDTO> getAllTrucksSummary() {
        return truckRepository
                .findAll()
                .stream()
                .map(TruckServiceImpl::toTruckSummary)
                .toList();
    }

    private static TruckSummaryDTO toTruckSummary(TruckEntity truckEntity) {
        return new TruckSummaryDTO(
                truckEntity.getId(),
                truckEntity.getName(),
                truckEntity.getBrand(),
                truckEntity.getModel(),
                truckEntity.getPrice(),
                truckEntity.getProductionYear(),
                truckEntity.getTruckType(),
                truckEntity.getLoadCapacity()
        );

    }


    private TruckDetailsDTO toTruckDetails(TruckEntity truckEntity) {
        return new TruckDetailsDTO(
                truckEntity.getId(),
                truckEntity.getName(),
                truckEntity.getBrand(),
                truckEntity.getModel(),
                truckEntity.getImageURL(),
                truckEntity.getFuelConsumption(),
                truckEntity.getDescription(),
                truckEntity.getPrice(),
                truckEntity.getProductionYear(),
                truckEntity.getTruckType(),
                truckEntity.getLoadCapacity(),
                truckEntity.getOwner().getPhone()
        );
    }
    @Override
    public TruckDetailsDTO getTruckDetails(Long id) {

        return this.truckRepository
                .findById(id)
                .map(this::toTruckDetails)
                .orElseThrow(() -> new ObjectNotFoundException("Offer not found!", id));
    }
}
