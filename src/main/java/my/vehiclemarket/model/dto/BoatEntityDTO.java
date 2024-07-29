package my.vehiclemarket.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import my.vehiclemarket.model.enums.BoatTypeEnum;

public class BoatEntityDTO {

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

    @NotNull(message = "Boat Type cannot be empty")
    private BoatTypeEnum boatType;

    public BoatEntityDTO() {
    }

    public String getName() {
        return name;
    }

    public BoatEntityDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public BoatEntityDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public BoatEntityDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public BoatEntityDTO setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public BoatEntityDTO setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BoatEntityDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public BoatEntityDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public BoatEntityDTO setProductionYear(int productionYear) {
        this.productionYear = productionYear;
        return this;
    }

    public BoatTypeEnum getBoatType() {
        return boatType;
    }

    public BoatEntityDTO setBoatType(BoatTypeEnum boatType) {
        this.boatType = boatType;
        return this;
    }
}
