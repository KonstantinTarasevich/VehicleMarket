package my.vehiclemarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.MotorcycleEntityDTO;
import my.vehiclemarket.model.entity.MotorcycleEntity;
import my.vehiclemarket.service.MotorcycleService;
import org.modelmapper.ModelMapper;

@Controller
@RequestMapping("/motorcycles")
public class MotorcycleController {

    private final MotorcycleService motorcycleService;
    private final ModelMapper modelMapper;

    public MotorcycleController(MotorcycleService motorcycleService, ModelMapper modelMapper) {
        this.motorcycleService = motorcycleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String listMotorcycles(Model model) {
        model.addAttribute("motorcycles", motorcycleService.findAll().stream()
                .map(motorcycle -> modelMapper.map(motorcycle, MotorcycleEntityDTO.class))
                .toList());
        return "motorcycles";
    }

    @GetMapping("/add")
    public String addMotorcycleForm(Model model) {
        model.addAttribute("motorcycle", new MotorcycleEntityDTO());
        return "add-motorcycle";
    }

    @PostMapping("/add")
    public String addMotorcycle(@ModelAttribute MotorcycleEntityDTO motorcycleDTO) {
        MotorcycleEntity motorcycle = modelMapper.map(motorcycleDTO, MotorcycleEntity.class);
        motorcycleService.save(motorcycle);
        return "redirect:/motorcycles";
    }

    @GetMapping("/edit/{id}")
    public String editMotorcycleForm(@PathVariable Long id, Model model) {
        MotorcycleEntity motorcycle = motorcycleService.findById(id);
        if (motorcycle != null) {
            model.addAttribute("motorcycle", modelMapper.map(motorcycle, MotorcycleEntityDTO.class));
            return "edit-motorcycle";
        }
        return "redirect:/motorcycles";
    }

    @PostMapping("/edit")
    public String editMotorcycle(@ModelAttribute MotorcycleEntityDTO motorcycleDTO) {
        MotorcycleEntity motorcycle = modelMapper.map(motorcycleDTO, MotorcycleEntity.class);
        motorcycleService.save(motorcycle);
        return "redirect:/motorcycles";
    }

    @GetMapping("/delete/{id}")
    public String deleteMotorcycle(@PathVariable Long id) {
        motorcycleService.delete(id);
        return "redirect:/motorcycles";
    }
}
