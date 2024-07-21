package my.vehiclemarket.controller.rest;

import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.BoatEntityDTO;
import my.vehiclemarket.service.impl.BoatServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/boats")
public class BoatRestController {

    private final BoatServiceImpl boatService;

    public BoatRestController(BoatServiceImpl boatService) {
        this.boatService = boatService;
    }

    @GetMapping
    public List<BoatEntityDTO> listBoats() {
        return boatService.findAll();
    }

    @GetMapping("/{id}")
    public BoatEntityDTO getBoat(@PathVariable Long id) {
        return boatService.findById(id);
    }

    @PostMapping
    public BoatEntityDTO addBoat(@RequestBody BoatEntityDTO boatDTO) {
        return boatService.save(boatDTO);
    }

    @PutMapping("/{id}")
    public BoatEntityDTO updateBoat(@PathVariable Long id, @RequestBody BoatEntityDTO boatDTO) {
        return boatService.update(id, boatDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBoat(@PathVariable Long id) {
        boatService.delete(id);
    }
}
