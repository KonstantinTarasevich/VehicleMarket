package my.vehiclemarket.controller.rest;

import my.vehiclemarket.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.dto.UserEntityDTO;
import my.vehiclemarket.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private UserServiceImpl userService;

    @GetMapping
    public List<UserEntityDTO> listUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserEntityDTO getUser(@PathVariable Long id) {
        return userService.findById(id);
    }


    @PutMapping("/{id}")
    public UserEntityDTO updateUser(@PathVariable Long id, @RequestBody UserEntityDTO userDTO) {
        return userService.update(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
