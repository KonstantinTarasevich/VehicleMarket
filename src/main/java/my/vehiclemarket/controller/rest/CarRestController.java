package my.vehiclemarket.controller.rest;

import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.CarEntityDTO;
import my.vehiclemarket.service.impl.CarServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {

    private CarServiceImpl carService;

    @GetMapping
    public List<CarEntityDTO> listCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarEntityDTO getCar(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PostMapping
    public CarEntityDTO addCar(@RequestBody CarEntityDTO carDTO) {
        return carService.save(carDTO);
    }

    @PutMapping("/{id}")
    public CarEntityDTO updateCar(@PathVariable Long id, @RequestBody CarEntityDTO carDTO) {
        return carService.update(id, carDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.delete(id);
    }
}
