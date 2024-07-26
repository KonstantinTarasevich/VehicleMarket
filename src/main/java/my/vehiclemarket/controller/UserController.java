package my.vehiclemarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        model.addAttribute("title", "Profile");
        return "profile";
    }
}
