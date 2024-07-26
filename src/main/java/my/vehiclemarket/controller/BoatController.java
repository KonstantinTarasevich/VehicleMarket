package my.vehiclemarket.controller;

import my.vehiclemarket.service.impl.BoatServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.BoatEntityDTO;

@Controller
@RequestMapping("/boats")
public class BoatController {

    private final BoatServiceImpl boatService;

    public BoatController(BoatServiceImpl boatService) {
        this.boatService = boatService;
    }

    @GetMapping("/add")
    public String addBoatForm(Model model) {
        model.addAttribute("boat", new BoatEntityDTO());
        return "add-boat";
    }

    @PostMapping("/add")
    public String addBoat(@ModelAttribute BoatEntityDTO boatDTO) {
        boatService.save(boatDTO);
        return "redirect:/boats";
    }

    @GetMapping("/edit/{id}")
    public String editBoatForm(@PathVariable Long id, Model model) {
        BoatEntityDTO boatDTO = boatService.findById(id);
        if (boatDTO != null) {
            model.addAttribute("boat", boatDTO);
            return "edit-boat";
        }
        return "redirect:/boats";
    }

    @PostMapping("/edit/{id}")
    public String editBoat(@PathVariable Long id, @ModelAttribute BoatEntityDTO boatDTO) {
        boatService.update(id, boatDTO);
        return "redirect:/boats";
    }

    @GetMapping("/delete/{id}")
    public String deleteBoat(@PathVariable Long id) {
        boatService.delete(id);
        return "redirect:/boats";
    }
}
