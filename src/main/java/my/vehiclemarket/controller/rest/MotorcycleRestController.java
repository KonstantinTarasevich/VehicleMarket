package my.vehiclemarket.controller.rest;

import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.MotorcycleEntityDTO;
import my.vehiclemarket.service.impl.MotorcycleServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleRestController {

    private final MotorcycleServiceImpl motorcycleService;

    public MotorcycleRestController(MotorcycleServiceImpl motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @GetMapping
    public List<MotorcycleEntityDTO> listMotorcycles() {
        return motorcycleService.findAll();
    }

    @GetMapping("/{id}")
    public MotorcycleEntityDTO getMotorcycle(@PathVariable Long id) {
        return motorcycleService.findById(id);
    }

    @PostMapping
    public MotorcycleEntityDTO addMotorcycle(@RequestBody MotorcycleEntityDTO motorcycleDTO) {
        return motorcycleService.save(motorcycleDTO);
    }

    @PutMapping("/{id}")
    public MotorcycleEntityDTO updateMotorcycle(@PathVariable Long id, @RequestBody MotorcycleEntityDTO motorcycleDTO) {
        return motorcycleService.update(id, motorcycleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMotorcycle(@PathVariable Long id) {
        motorcycleService.delete(id);
    }
}
