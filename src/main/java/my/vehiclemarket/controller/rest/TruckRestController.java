package my.vehiclemarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.entity.TruckEntity;
import my.vehiclemarket.service.TruckService;

import java.util.List;

@RestController
@RequestMapping("/api/trucks")
public class TruckRestController {

    @Autowired
    private TruckService truckService;

    @GetMapping
    public List<TruckEntity> getAllTrucks() {
        return truckService.findAll();
    }

    @GetMapping("/{id}")
    public TruckEntity getTruckById(@PathVariable Long id) {
        return truckService.findById(id);
    }

    @PostMapping
    public TruckEntity createTruck(@RequestBody TruckEntity truck) {
        return truckService.save(truck);
    }

    @PutMapping("/{id}")
    public TruckEntity updateTruck(@PathVariable Long id, @RequestBody TruckEntity truck) {
        truck.setId(id);
        return truckService.save(truck);
    }

    @DeleteMapping("/{id}")
    public void deleteTruck(@PathVariable Long id) {
        truckService.delete(id);
    }
}
