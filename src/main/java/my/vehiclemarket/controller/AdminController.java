package my.vehiclemarket.controller;

import jakarta.validation.Valid;
import my.vehiclemarket.model.dto.UserRegisterDTO;
import my.vehiclemarket.service.impl.AdminServiceImpl;
import my.vehiclemarket.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin-panel")
public class AdminController {

    private final AdminServiceImpl adminService;
    private final UserServiceImpl userService;

    public AdminController(AdminServiceImpl adminService, UserServiceImpl userService) {
        this.adminService = adminService;
        this.userService = userService;
    }

    @ModelAttribute("registerData")
    public UserRegisterDTO registerDTO(){
        return new UserRegisterDTO();
    }

    @GetMapping()
    public String adminPanel(Model model) {

        model.addAttribute("allUsers", userService.getAllUserDetails());

        return "admin-panel";
    }

    @GetMapping("/admin-register")
    public String showRegisterForm() {
        return "admin-register";
    }

    @PostMapping("/admin-register")
    public String doRegister(
            @Valid UserRegisterDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors() || !data.getPassword().equals(data.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData", bindingResult);

            return "redirect:/admin_register";
        }

        boolean success = adminService.registerAdmin(data);

        if (!success) {
            return "redirect:/admin-register";
        }

        return "redirect:/admin-panel";
    }
}
