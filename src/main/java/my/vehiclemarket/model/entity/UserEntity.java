package my.vehiclemarket.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, name = "full_name")
    private String name;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<UserRoleEntity> roles = new ArrayList<>();

    @OneToMany(mappedBy = "owner")
    private List<CarEntity> addedCars;
    @OneToMany(mappedBy = "owner")
    private List<BoatEntity> addedBoats;
    @OneToMany(mappedBy = "owner")
    private List<MotorcycleEntity> addedMotorcycles;
    @OneToMany(mappedBy = "owner")
    private List<TruckEntity> addedTrucks;


    public UserEntity() {
        this.addedCars = new ArrayList<>();
        this.addedBoats = new ArrayList<>();
        this.addedMotorcycles = new ArrayList<>();
        this.addedTrucks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<CarEntity> getAddedCars() {
        return addedCars;
    }

    public UserEntity setAddedCars(List<CarEntity> addedCars) {
        this.addedCars = addedCars;
        return this;
    }

    public List<BoatEntity> getAddedBoats() {
        return addedBoats;
    }

    public UserEntity setAddedBoats(List<BoatEntity> addedBoats) {
        this.addedBoats = addedBoats;
        return this;
    }

    public List<MotorcycleEntity> getAddedMotorcycles() {
        return addedMotorcycles;
    }

    public UserEntity setAddedMotorcycles(List<MotorcycleEntity> addedMotorcycles) {
        this.addedMotorcycles = addedMotorcycles;
        return this;
    }

    public List<TruckEntity> getAddedTrucks() {
        return addedTrucks;
    }

    public UserEntity setAddedTrucks(List<TruckEntity> addedTrucks) {
        this.addedTrucks = addedTrucks;
        return this;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
