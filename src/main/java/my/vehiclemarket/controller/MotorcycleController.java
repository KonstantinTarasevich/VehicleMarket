package my.vehiclemarket.controller;

import my.vehiclemarket.service.impl.MotorcycleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.MotorcycleEntityDTO;

@Controller
@RequestMapping("/motorcycles")
public class MotorcycleController {

    private final MotorcycleServiceImpl motorcycleService;

    public MotorcycleController(MotorcycleServiceImpl motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @GetMapping("/add")
    public String addMotorcycleForm(Model model) {
        model.addAttribute("motorcycle", new MotorcycleEntityDTO());
        return "add-motorcycle";
    }

    @PostMapping("/add")
    public String addMotorcycle(@ModelAttribute MotorcycleEntityDTO motorcycleDTO) {
        motorcycleService.save(motorcycleDTO);
        return "redirect:/motorcycles";
    }

    @GetMapping("/edit/{id}")
    public String editMotorcycleForm(@PathVariable Long id, Model model) {
        MotorcycleEntityDTO motorcycleDTO = motorcycleService.findById(id);
        if (motorcycleDTO != null) {
            model.addAttribute("motorcycle", motorcycleDTO);
            return "edit-motorcycle";
        }
        return "redirect:/motorcycles";
    }

    @PostMapping("/edit/{id}")
    public String editMotorcycle(@PathVariable Long id, @ModelAttribute MotorcycleEntityDTO motorcycleDTO) {
        motorcycleService.update(id, motorcycleDTO);
        return "redirect:/motorcycles";
    }

    @GetMapping("/delete/{id}")
    public String deleteMotorcycle(@PathVariable Long id) {
        motorcycleService.delete(id);
        return "redirect:/motorcycles";
    }
}
