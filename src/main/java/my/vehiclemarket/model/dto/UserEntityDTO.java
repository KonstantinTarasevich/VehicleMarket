package my.vehiclemarket.model.dto;

public class UserEntityDTO {

    private String name;

    private String username;

    private String password;

    private String email;

    public String getName() {
        return name;
    }

    public UserEntityDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntityDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntityDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntityDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
