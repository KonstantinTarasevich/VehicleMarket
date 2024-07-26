package my.vehiclemarket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home - Vehicle Market");
        return "index";
    }

    @GetMapping("/add-vehicle")
    public String showAddVehicleForm(Model model) {
        model.addAttribute("title", "Add Vehicle");
        return "add-vehicle";
    }

    @GetMapping("/cars")
    public String showCarsPage(Model model) {
        model.addAttribute("title", "Cars");
        return "cars";
    }

    @GetMapping("/boats")
    public String showBoatsPage(Model model) {
        model.addAttribute("title", "Boats");
        return "boats";
    }

    @GetMapping("/trucks")
    public String showTrucksPage(Model model) {
        model.addAttribute("title", "Trucks");
        return "trucks";
    }

    @GetMapping("/motorcycles")
    public String showMotorcyclesPage(Model model) {
        model.addAttribute("title", "Motorcycles");
        return "motorcycles";
    }

}
