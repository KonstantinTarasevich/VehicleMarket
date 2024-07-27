package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.entity.UserEntity;
import my.vehiclemarket.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

           return userRepository
                .findByUsername(username)
                .map(UserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with username" + username + " not found"));

    }

    private static UserDetails map(UserEntity userEntity) {
        return User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(List.of())
                .disabled(false)
                .build();
    }
}
