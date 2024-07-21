package my.vehiclemarket.controller;

import my.vehiclemarket.service.impl.CarServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.CarEntityDTO;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public String listCars(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "list-cars";
    }

    @GetMapping("/add")
    public String addCarForm(Model model) {
        model.addAttribute("car", new CarEntityDTO());
        return "add-car";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute CarEntityDTO carDTO) {
        carService.save(carDTO);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable Long id, Model model) {
        CarEntityDTO carDTO = carService.findById(id);
        if (carDTO != null) {
            model.addAttribute("car", carDTO);
            return "edit-car";
        }
        return "redirect:/cars";
    }

    @PostMapping("/edit/{id}")
    public String editCar(@PathVariable Long id, @ModelAttribute CarEntityDTO carDTO) {
        carService.update(id, carDTO);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.delete(id);
        return "redirect:/cars";
    }
}
