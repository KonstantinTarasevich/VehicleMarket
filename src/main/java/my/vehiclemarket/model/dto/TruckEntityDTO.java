package my.vehiclemarket.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import my.vehiclemarket.model.enums.BoatTypeEnum;
import my.vehiclemarket.model.enums.TruckTypeEnum;

public class TruckEntityDTO {

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Brand cannot be empty")
    private String brand;

    @NotNull(message = "Model cannot be empty")
    private String model;

    @NotNull(message = "Image URL cannot be empty")
    private String imageURL;

    private double fuelConsumption;

    @NotNull(message = "Description cannot be empty")
    private String description;

    @NotNull
    @Positive(message = "Price must be a positive number")
    private Double price;

    @NotNull
    @Positive(message = "Production year must be a positive number")
    private int productionYear;

    @NotNull(message = "Truck Type cannot be empty")
    private TruckTypeEnum truckType;

    @NotNull
    @Positive(message = "Load capacity must be a positive number")
    private int loadCapacity;

    public TruckEntityDTO() {
    }

    public String getName() {
        return name;
    }

    public TruckEntityDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public TruckEntityDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public TruckEntityDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public TruckEntityDTO setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public TruckEntityDTO setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TruckEntityDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public TruckEntityDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public TruckEntityDTO setProductionYear(int productionYear) {
        this.productionYear = productionYear;
        return this;
    }

    public TruckTypeEnum getTruckType() {
        return truckType;
    }

    public TruckEntityDTO setTruckType(TruckTypeEnum truckType) {
        this.truckType = truckType;
        return this;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public TruckEntityDTO setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
        return this;
    }
}
