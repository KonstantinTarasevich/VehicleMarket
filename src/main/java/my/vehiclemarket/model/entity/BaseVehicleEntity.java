package my.vehiclemarket.model.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseVehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @ManyToOne(optional = false)
    private UserEntity owner;

    @Column(nullable = false, name = "image_URL")
    private String imageURL;

    @Column(nullable = true, name = "fuel_consumption")
    private double fuelConsumption;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, name = "days_active")
    private int daysActive;

    @Column(nullable = false, name = "production_year")
    private int productionYear;


    public long getId() {
        return id;
    }

    public BaseVehicleEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BaseVehicleEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public BaseVehicleEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public BaseVehicleEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public BaseVehicleEntity setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BaseVehicleEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public BaseVehicleEntity setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getDaysActive() {
        return daysActive;
    }

    public BaseVehicleEntity setDaysActive(int daysActive) {
        this.daysActive = daysActive;
        return this;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public BaseVehicleEntity setProductionYear(int productionYear) {
        this.productionYear = productionYear;
        return this;
    }
}