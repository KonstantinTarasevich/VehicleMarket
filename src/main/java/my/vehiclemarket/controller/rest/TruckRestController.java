package my.vehiclemarket.controller.rest;

import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.TruckEntityDTO;
import my.vehiclemarket.service.impl.TruckServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/trucks")
public class TruckRestController {

    private final TruckServiceImpl truckService;

    public TruckRestController(TruckServiceImpl truckService) {
        this.truckService = truckService;
    }

    @GetMapping
    public List<TruckEntityDTO> listTrucks() {
        return truckService.findAll();
    }

    @GetMapping("/{id}")
    public TruckEntityDTO getTruck(@PathVariable Long id) {
        return truckService.findById(id);
    }

    @PostMapping
    public TruckEntityDTO addTruck(@RequestBody TruckEntityDTO truckDTO) {
        return truckService.save(truckDTO);
    }

    @PutMapping("/{id}")
    public TruckEntityDTO updateTruck(@PathVariable Long id, @RequestBody TruckEntityDTO truckDTO) {
        return truckService.update(id, truckDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTruck(@PathVariable Long id) {
        truckService.delete(id);
    }
}
