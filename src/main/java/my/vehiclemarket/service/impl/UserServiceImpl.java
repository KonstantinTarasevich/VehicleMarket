package my.vehiclemarket.service.impl;

import  my.vehiclemarket.config.UserSession;
import  my.vehiclemarket.model.dto.UserLoginDTO;
import  my.vehiclemarket.model.dto.UserRegisterDTO;
import  my.vehiclemarket.model.entity.UserEntity;
import  my.vehiclemarket.repos.UserRepository;
import my.vehiclemarket.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserSession userSession;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    public boolean register(UserRegisterDTO data) {
        Optional<UserEntity> existingUser = userRepository.findByUsernameOrEmail(data.getUsername(), data.getEmail());

        if (existingUser.isPresent()) {
            return false;
        }

        UserEntity user = new UserEntity();
        user.setUsername(data.getUsername());
        user.setEmail(data.getEmail());
        user.setPassword(passwordEncoder.encode(data.getPassword()));

        this.userRepository.save(user);

        return true;
    }

    public boolean login(UserLoginDTO data) {
        Optional<UserEntity> byUsername = userRepository.findByUsername(data.getUsername());

        if (byUsername.isEmpty()) {
            return false;
        }
        boolean passMatch = passwordEncoder
                .matches(data.getPassword(), byUsername.get().getPassword());

        if (!passMatch) {
            return false;
        }

        userSession.login(byUsername.get().getId(), data.getUsername());

        return true;
    }
}