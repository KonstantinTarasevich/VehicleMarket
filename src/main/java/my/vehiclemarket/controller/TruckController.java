package my.vehiclemarket.controller;

import my.vehiclemarket.service.impl.TruckServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.TruckEntityDTO;

@Controller
@RequestMapping("/trucks")
public class TruckController {

    private final TruckServiceImpl truckService;

    public TruckController(TruckServiceImpl truckService) {
        this.truckService = truckService;
    }

    @GetMapping
    public String listTrucks(Model model) {
        model.addAttribute("trucks", truckService.findAll());
        return "list-trucks";
    }

    @GetMapping("/add")
    public String addTruckForm(Model model) {
        model.addAttribute("truck", new TruckEntityDTO());
        return "add-truck";
    }

    @PostMapping("/add")
    public String addTruck(@ModelAttribute TruckEntityDTO truckDTO) {
        truckService.save(truckDTO);
        return "redirect:/trucks";
    }

    @GetMapping("/edit/{id}")
    public String editTruckForm(@PathVariable Long id, Model model) {
        TruckEntityDTO truckDTO = truckService.findById(id);
        if (truckDTO != null) {
            model.addAttribute("truck", truckDTO);
            return "edit-truck";
        }
        return "redirect:/trucks";
    }

    @PostMapping("/edit/{id}")
    public String editTruck(@PathVariable Long id, @ModelAttribute TruckEntityDTO truckDTO) {
        truckService.update(id, truckDTO);
        return "redirect:/trucks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTruck(@PathVariable Long id) {
        truckService.delete(id);
        return "redirect:/trucks";
    }
}
