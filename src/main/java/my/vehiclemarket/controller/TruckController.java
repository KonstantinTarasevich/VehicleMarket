package my.vehiclemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.TruckEntityDTO;
import my.vehiclemarket.model.entity.TruckEntity;
import my.vehiclemarket.service.TruckService;
import org.modelmapper.ModelMapper;

@Controller
@RequestMapping("/trucks")
public class TruckController {

    private final TruckService truckService;
    private final ModelMapper modelMapper;

    public TruckController(TruckService truckService, ModelMapper modelMapper) {
        this.truckService = truckService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String listTrucks(Model model) {
        model.addAttribute("trucks", truckService.findAll().stream()
                .map(truck -> modelMapper.map(truck, TruckEntityDTO.class))
                .toList());
        return "trucks";
    }

    @GetMapping("/add")
    public String addTruckForm(Model model) {
        model.addAttribute("truck", new TruckEntityDTO());
        return "add-truck";
    }

    @PostMapping("/add")
    public String addTruck(@ModelAttribute TruckEntityDTO truckDTO) {
        TruckEntity truck = modelMapper.map(truckDTO, TruckEntity.class);
        truckService.save(truck);
        return "redirect:/trucks";
    }

    @GetMapping("/edit/{id}")
    public String editTruckForm(@PathVariable Long id, Model model) {
        TruckEntity truck = truckService.findById(id);
        if (truck != null) {
            model.addAttribute("truck", modelMapper.map(truck, TruckEntityDTO.class));
            return "edit-truck";
        }
        return "redirect:/trucks";
    }

    @PostMapping("/edit")
    public String editTruck(@ModelAttribute TruckEntityDTO truckDTO) {
        TruckEntity truck = modelMapper.map(truckDTO, TruckEntity.class);
        truckService.save(truck);
        return "redirect:/trucks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTruck(@PathVariable Long id) {
        truckService.delete(id);
        return "redirect:/trucks";
    }
}
