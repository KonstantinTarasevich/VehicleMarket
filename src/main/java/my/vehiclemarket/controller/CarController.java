package my.vehiclemarket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.CarEntityDTO;
import my.vehiclemarket.model.entity.CarEntity;
import my.vehiclemarket.service.CarService;
import org.modelmapper.ModelMapper;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final ModelMapper modelMapper;

    public CarController(CarService carService, ModelMapper modelMapper) {
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String listCars(Model model) {
        model.addAttribute("cars", carService.findAll().stream()
                .map(car -> modelMapper.map(car, CarEntityDTO.class))
                .toList());
        return "cars";
    }

    @GetMapping("/add")
    public String addCarForm(Model model) {
        model.addAttribute("car", new CarEntityDTO());
        return "add-car";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute CarEntityDTO carDTO) {
        CarEntity car = modelMapper.map(carDTO, CarEntity.class);
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable Long id, Model model) {
        CarEntity car = carService.findById(id);
        if (car != null) {
            model.addAttribute("car", modelMapper.map(car, CarEntityDTO.class));
            return "edit-car";
        }
        return "redirect:/cars";
    }

    @PostMapping("/edit")
    public String editCar(@ModelAttribute CarEntityDTO carDTO) {
        CarEntity car = modelMapper.map(carDTO, CarEntity.class);
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.delete(id);
        return "redirect:/cars";
    }
}
