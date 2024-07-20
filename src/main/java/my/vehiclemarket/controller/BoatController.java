package my.vehiclemarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.BoatEntityDTO;
import my.vehiclemarket.model.entity.BoatEntity;
import my.vehiclemarket.service.BoatService;
import org.modelmapper.ModelMapper;

@Controller
@RequestMapping("/boats")
public class BoatController {

    private final BoatService boatService;
    private final ModelMapper modelMapper;

    public BoatController(BoatService boatService, ModelMapper modelMapper) {
        this.boatService = boatService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String listBoats(Model model) {
        model.addAttribute("boats", boatService.findAll().stream()
                .map(boat -> modelMapper.map(boat, BoatEntityDTO.class))
                .toList());
        return "boats";
    }

    @GetMapping("/add")
    public String addBoatForm(Model model) {
        model.addAttribute("boat", new BoatEntityDTO());
        return "add-boat";
    }

    @PostMapping("/add")
    public String addBoat(@ModelAttribute BoatEntityDTO boatDTO) {
        BoatEntity boat = modelMapper.map(boatDTO, BoatEntity.class);
        boatService.save(boat);
        return "redirect:/boats";
    }

    @GetMapping("/edit/{id}")
    public String editBoatForm(@PathVariable Long id, Model model) {
        BoatEntity boat = boatService.findById(id);
        if (boat != null) {
            model.addAttribute("boat", modelMapper.map(boat, BoatEntityDTO.class));
            return "edit-boat";
        }
        return "redirect:/boats";
    }

    @PostMapping("/edit")
    public String editBoat(@ModelAttribute BoatEntityDTO boatDTO) {
        BoatEntity boat = modelMapper.map(boatDTO, BoatEntity.class);
        boatService.save(boat);
        return "redirect:/boats";
    }

    @GetMapping("/delete/{id}")
    public String deleteBoat(@PathVariable Long id) {
        boatService.delete(id);
        return "redirect:/boats";
    }
}
