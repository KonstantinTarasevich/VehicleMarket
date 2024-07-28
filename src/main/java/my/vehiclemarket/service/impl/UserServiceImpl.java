package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.dto.UserRegisterDTO;
import my.vehiclemarket.model.entity.UserEntity;
import my.vehiclemarket.model.enums.RolesEnum;
import my.vehiclemarket.repository.UserRepository;
import my.vehiclemarket.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserRegisterDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserRegisterDTO.class))
                .collect(Collectors.toList());
    }

    public UserRegisterDTO findById(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        return user != null ? modelMapper.map(user, UserRegisterDTO.class) : null;
    }

    public boolean register(UserRegisterDTO data) {
        Optional<UserEntity> existingUser = userRepository.findByUsername(data.getUsername());

        if (existingUser.isPresent()) {
            return false;
        }

        UserEntity user = new UserEntity();
        user.setUsername(data.getUsername());
        user.setEmail(data.getEmail());
        user.setPhone(data.getPhone());
        user.setName(data.getName());
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        

        this.userRepository.save(user);

        return true;
    }


    public UserRegisterDTO update(Long id, UserRegisterDTO userDTO) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            modelMapper.map(userDTO, existingUser);
            existingUser = userRepository.save(existingUser);
            return modelMapper.map(existingUser, UserRegisterDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
