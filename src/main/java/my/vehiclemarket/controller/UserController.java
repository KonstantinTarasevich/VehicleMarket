package my.vehiclemarket.controller;

import my.vehiclemarket.config.UserSession;
import my.vehiclemarket.model.dto.UserLoginDTO;
import my.vehiclemarket.model.dto.UserRegisterDTO;
import my.vehiclemarket.service.UserService;
import jakarta.validation.Valid;
import my.vehiclemarket.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;
    private final UserSession userSession;
    private final UserServiceImpl userServiceImpl;

    public UserController(UserService userService, UserSession userSession, UserServiceImpl userServiceImpl) {
        this.userService = userService;
        this.userSession = userSession;
        this.userServiceImpl = userServiceImpl;
    }

    @ModelAttribute("registerData")
    public UserRegisterDTO registerDTO(){
        return new UserRegisterDTO();
    }

    @ModelAttribute("loginData")
    public UserLoginDTO loginDTO(){
        return new UserLoginDTO();
    }

    @GetMapping("/register")
    public String register() {
        if(userSession.isLoggedIn()) {
            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(
            @Valid UserRegisterDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if(userSession.isLoggedIn()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors() || !data.getPassword().equals(data.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData", bindingResult);

            return "redirect:/register";
        }

        boolean success = userServiceImpl.register(data);

        if (!success) {
            return "redirect:/register";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        if(userSession.isLoggedIn()) {
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(
            @Valid UserLoginDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ){
        if(userSession.isLoggedIn()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginData", bindingResult);
            return "redirect:/login";
        }

        boolean success = userServiceImpl.login(data);

        if (!success) {
            redirectAttributes.addFlashAttribute("loginData", data);

            return "redirect:/login";
        }

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        if(!userSession.isLoggedIn()) {
            return "redirect:/";
        }
        userSession.logout();
        return "redirect:/";
    }



}
