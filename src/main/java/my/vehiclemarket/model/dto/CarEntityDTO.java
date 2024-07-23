package my.vehiclemarket.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import my.vehiclemarket.model.enums.*;

public class CarEntityDTO {

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Brand cannot be empty")
    private String brand;

    @NotEmpty(message = "Model cannot be empty")
    private String model;

    @NotEmpty(message = "Image URL cannot be empty")
    private String imageURL;

    @NotEmpty(message = "Fuel Consumption cannot be empty")
    private double fuelConsumption;

    @NotEmpty(message = "Description cannot be empty")
    private String description;

    @Positive(message = "Price must be a positive number")
    private Double price;

    @NotEmpty(message = "Transmission Type cannot be empty")
    private TransmissionTypeEnum transmissionType;

    @NotEmpty(message = "Car Type cannot be empty")
    private CarTypeEnum carType;

    @NotEmpty(message = "Engine Type cannot be empty")
    private EngineTypeEnum engineType;

    @Positive(message = "Horse Power must be a positive number")
    private int horsePower;

    @NotNull(message = "City cannot be null")
    private CityEnum city;

    public CarEntityDTO() {}

    public String getName() {
        return name;
    }

    public CarEntityDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarEntityDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarEntityDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public CarEntityDTO setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public CarEntityDTO setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CarEntityDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public CarEntityDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public TransmissionTypeEnum getTransmissionType() {
        return transmissionType;
    }

    public CarEntityDTO setTransmissionType(TransmissionTypeEnum transmissionType) {
        this.transmissionType = transmissionType;
        return this;
    }

    public CarTypeEnum getCarType() {
        return carType;
    }

    public CarEntityDTO setCarType(CarTypeEnum carType) {
        this.carType = carType;
        return this;
    }

    public EngineTypeEnum getEngineType() {
        return engineType;
    }

    public CarEntityDTO setEngineType(EngineTypeEnum engineType) {
        this.engineType = engineType;
        return this;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public CarEntityDTO setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public CityEnum getCity() {
        return city;
    }

    public CarEntityDTO setCity(CityEnum city) {
        this.city = city;
        return this;
    }
}
