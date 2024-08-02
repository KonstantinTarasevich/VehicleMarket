package my.vehiclemarket.model.dto;


import my.vehiclemarket.model.enums.BoatTypeEnum;

public record BoatDetailsDTO(Long id,
                             String name,
                             String brand,
                             String model,
                             String imageURL,
                             double fuelConsumption,
                             String description,
                             Double price,
                             int productionYear,
                             BoatTypeEnum boatType,
                             String ownerPhone
                             ) {
}
