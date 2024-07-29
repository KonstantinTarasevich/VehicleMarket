package my.vehiclemarket.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import my.vehiclemarket.model.enums.BoatTypeEnum;

public class MotorcycleEntityDTO {

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

    @NotNull
    @Positive(message = "Horse power must be a positive number")
    private int horsePower;

    public MotorcycleEntityDTO() {
    }

    public String getName() {
        return name;
    }

    public MotorcycleEntityDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public MotorcycleEntityDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public MotorcycleEntityDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public MotorcycleEntityDTO setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public MotorcycleEntityDTO setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MotorcycleEntityDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public MotorcycleEntityDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public MotorcycleEntityDTO setProductionYear(int productionYear) {
        this.productionYear = productionYear;
        return this;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public MotorcycleEntityDTO setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }
}
