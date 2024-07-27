package my.vehiclemarket.controller;

import jakarta.validation.Valid;
import my.vehiclemarket.model.dto.UserLoginDTO;
import my.vehiclemarket.service.UserService;
import my.vehiclemarket.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class LoginController {

    private final UserServiceImpl userService;

    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @ModelAttribute("loginData")
    public UserLoginDTO loginDTO(){
        return new UserLoginDTO();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
