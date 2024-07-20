package my.vehiclemarket.service;

import my.vehiclemarket.model.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();

    UserEntity findById(Long id);

    UserEntity save(UserEntity user);

    UserEntity update(UserEntity user);

    void delete(Long id);
}
