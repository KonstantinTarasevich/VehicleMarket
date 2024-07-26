package my.vehiclemarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class RegistrationController {

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("title", "Register");
        return "register";
    }
}
