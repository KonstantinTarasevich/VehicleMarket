package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.dto.UserEntityDTO;
import my.vehiclemarket.model.entity.UserEntity;
import my.vehiclemarket.repos.UserRepository;
import my.vehiclemarket.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserEntityDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserEntityDTO.class))
                .collect(Collectors.toList());
    }

    public UserEntityDTO findById(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        return user != null ? modelMapper.map(user, UserEntityDTO.class) : null;
    }

    public UserEntityDTO save(UserEntityDTO userDTO) {
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserEntityDTO.class);
    }

    public UserEntityDTO update(Long id, UserEntityDTO userDTO) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            modelMapper.map(userDTO, existingUser);
            existingUser = userRepository.save(existingUser);
            return modelMapper.map(existingUser, UserEntityDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
