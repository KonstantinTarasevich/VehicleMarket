package my.vehiclemarket.model.entity;

import jakarta.persistence.*;
import my.vehiclemarket.model.enums.RolesEnum;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, name = "first_name")
    private String name;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private RolesEnum Role;

    @OneToMany(mappedBy = "owner")
    private List<CarEntity> addedCars;
    @OneToMany(mappedBy = "owner")
    private List<BoatEntity> addedBoats;
    @OneToMany(mappedBy = "owner")
    private List<MotorcycleEntity> addedMotorcycles;
    @OneToMany(mappedBy = "owner")
    private List<TruckEntity> addedTrucks;

    @ManyToMany()
    private List<CarEntity> favouriteCars;
    @ManyToMany()
    private List<BoatEntity> favouriteBoats;
    @ManyToMany()
    private List<MotorcycleEntity> favouriteMotorcycles;
    @ManyToMany()
    private List<TruckEntity> favouriteTrucks;


    public UserEntity() {
        this.addedCars = new ArrayList<>();
        this.addedBoats = new ArrayList<>();
        this.addedMotorcycles = new ArrayList<>();
        this.addedTrucks = new ArrayList<>();
        this.favouriteCars = new ArrayList<>();
        this.favouriteBoats = new ArrayList<>();
        this.favouriteMotorcycles = new ArrayList<>();
        this.favouriteTrucks = new ArrayList<>();
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

    public List<CarEntity> getFavouriteCars() {
        return favouriteCars;
    }

    public UserEntity setFavouriteCars(List<CarEntity> favouriteCars) {
        this.favouriteCars = favouriteCars;
        return this;
    }

    public List<BoatEntity> getFavouriteBoats() {
        return favouriteBoats;
    }

    public UserEntity setFavouriteBoats(List<BoatEntity> favouriteBoats) {
        this.favouriteBoats = favouriteBoats;
        return this;
    }

    public List<MotorcycleEntity> getFavouriteMotorcycles() {
        return favouriteMotorcycles;
    }

    public UserEntity setFavouriteMotorcycles(List<MotorcycleEntity> favouriteMotorcycles) {
        this.favouriteMotorcycles = favouriteMotorcycles;
        return this;
    }

    public List<TruckEntity> getFavouriteTrucks() {
        return favouriteTrucks;
    }

    public UserEntity setFavouriteTrucks(List<TruckEntity> favouriteTrucks) {
        this.favouriteTrucks = favouriteTrucks;
        return this;
    }

    public RolesEnum getRole() {
        return Role;
    }

    public UserEntity setRole(RolesEnum role) {
        Role = role;
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
