package my.vehiclemarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.entity.CarEntity;
import my.vehiclemarket.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {

    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarEntity> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarEntity getCarById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PostMapping
    public CarEntity createCar(@RequestBody CarEntity car) {
        return carService.save(car);
    }

    @PutMapping("/{id}")
    public CarEntity updateCar(@PathVariable Long id, @RequestBody CarEntity car) {
        car.setId(id);
        return carService.save(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.delete(id);
    }
}
