package my.vehiclemarket.config;

import my.vehiclemarket.model.entity.UserEntity;
import my.vehiclemarket.repos.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class UserSession {

    private long id;
    private String username;
    private UserEntity currentUser;

    private final UserRepository userRepository;

    public UserSession(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long id() {
        return id;
    }

    public String username() {
        return username;
    }


    public void login(Long id, String username) {
        this.id = id;
        this.username = username;

        UserEntity user = userRepository.findById(id).orElse(null);
        setCurrentUser(user);
    }

    public boolean isLoggedIn() {
        return id > 0;
    }


    public void logout() {
        id = 0;
        username = null;
    }

    public UserEntity getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserEntity currentUser) {
        this.currentUser = currentUser;
    }
}