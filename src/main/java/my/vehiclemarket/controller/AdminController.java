package my.vehiclemarket.controller;

import my.vehiclemarket.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final UserServiceImpl userServiceImpl;

    public AdminController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/admin-panel")
    public String adminPanel(Model model) {

        model.addAttribute("allUsers", userServiceImpl.getAllUserDetails());

        return "admin-panel";
    }
}
