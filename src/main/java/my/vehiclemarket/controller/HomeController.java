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

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("title", "Register");
        return "register";
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        model.addAttribute("title", "Profile");
        return "profile";
    }
}
