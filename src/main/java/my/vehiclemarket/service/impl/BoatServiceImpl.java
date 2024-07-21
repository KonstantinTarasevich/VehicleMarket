package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.dto.BoatEntityDTO;
import my.vehiclemarket.model.entity.BoatEntity;
import my.vehiclemarket.repos.BoatRepository;
import my.vehiclemarket.service.BoatService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoatServiceImpl implements BoatService {

    private final BoatRepository boatRepository;
    private final ModelMapper modelMapper;

    public BoatServiceImpl(BoatRepository boatRepository, ModelMapper modelMapper) {
        this.boatRepository = boatRepository;
        this.modelMapper = modelMapper;
    }

    public List<BoatEntityDTO> findAll() {
        return boatRepository.findAll().stream()
                .map(boat -> modelMapper.map(boat, BoatEntityDTO.class))
                .collect(Collectors.toList());
    }

    public BoatEntityDTO findById(Long id) {
        BoatEntity boat = boatRepository.findById(id).orElse(null);
        return boat != null ? modelMapper.map(boat, BoatEntityDTO.class) : null;
    }

    public BoatEntityDTO save(BoatEntityDTO boatDTO) {
        BoatEntity boat = modelMapper.map(boatDTO, BoatEntity.class);
        boat = boatRepository.save(boat);
        return modelMapper.map(boat, BoatEntityDTO.class);
    }

    public BoatEntityDTO update(Long id, BoatEntityDTO boatDTO) {
        BoatEntity existingBoat = boatRepository.findById(id).orElse(null);
        if (existingBoat != null) {
            modelMapper.map(boatDTO, existingBoat);
            existingBoat = boatRepository.save(existingBoat);
            return modelMapper.map(existingBoat, BoatEntityDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        boatRepository.deleteById(id);
    }
}
