package my.vehiclemarket.model.dto;

import my.vehiclemarket.model.enums.CityEnum;
import my.vehiclemarket.model.enums.TruckTypeEnum;

public class TruckEntityDTO {

    private String name;
    private String brand;
    private String model;
    private String imageURL;
    private double fuelConsumption;
    private String description;
    private double price;
    private TruckTypeEnum truckType;
    private int loadCapacity;
    private CityEnum city;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TruckTypeEnum getTruckType() {
        return truckType;
    }

    public void setTruckType(TruckTypeEnum truckType) {
        this.truckType = truckType;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public CityEnum getCity() {
        return city;
    }

    public void setCity(CityEnum city) {
        this.city = city;
    }
}
