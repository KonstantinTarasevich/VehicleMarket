package my.vehiclemarket.controller;

import jakarta.validation.Valid;
import my.vehiclemarket.model.UserData;
import my.vehiclemarket.model.entity.CarEntity;
import my.vehiclemarket.model.enums.EngineTypeEnum;
import my.vehiclemarket.model.enums.TransmissionTypeEnum;
import my.vehiclemarket.service.impl.CarServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.CarEntityDTO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @ModelAttribute("carData")
    public CarEntityDTO carDTO() {
        return new CarEntityDTO();
    }

    @GetMapping("/cars")
    public String showCarsPage() {
        return "cars";
    }

    @GetMapping("/add-car")
    public String addCarForm() {
        return "add-car";
    }

    @PostMapping("/add-car")
    public String addCar(
            @Valid CarEntityDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("carData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.carData", bindingResult);

            return "redirect:/cars/add-car";
        }

        boolean success = carService.save(data);

        if (!success) {
            redirectAttributes.addFlashAttribute("carData", data);
            return "redirect:/cars/add-car";
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable Long id, Model model) {
        CarEntityDTO carDTO = carService.findById(id);
        if (carDTO != null) {
            model.addAttribute("carData", carDTO);
            return "edit-car";
        }
        return "redirect:/cars";
    }

    @PostMapping("/edit/{id}")
    public String editCar(@PathVariable Long id, @Validated @ModelAttribute("carData") CarEntityDTO carDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit-car";
        }
        carService.update(id, carDTO);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.delete(id);
        return "redirect:/cars";
    }
}

