package my.vehiclemarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.entity.MotorcycleEntity;
import my.vehiclemarket.service.MotorcycleService;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleRestController {

    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping
    public List<MotorcycleEntity> getAllMotorcycles() {
        return motorcycleService.findAll();
    }

    @GetMapping("/{id}")
    public MotorcycleEntity getMotorcycleById(@PathVariable Long id) {
        return motorcycleService.findById(id);
    }

    @PostMapping
    public MotorcycleEntity createMotorcycle(@RequestBody MotorcycleEntity motorcycle) {
        return motorcycleService.save(motorcycle);
    }

    @PutMapping("/{id}")
    public MotorcycleEntity updateMotorcycle(@PathVariable Long id, @RequestBody MotorcycleEntity motorcycle) {
        motorcycle.setId(id);
        return motorcycleService.save(motorcycle);
    }

    @DeleteMapping("/{id}")
    public void deleteMotorcycle(@PathVariable Long id) {
        motorcycleService.delete(id);
    }
}
