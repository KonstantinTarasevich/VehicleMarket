package my.vehiclemarket.service.impl;

import  my.vehiclemarket.model.entity.UserEntity;
import  my.vehiclemarket.repos.UserRepository;
import my.vehiclemarket.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity update(UserEntity user) {
        return userRepository.update(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}