package my.vehiclemarket.model.dto;


import my.vehiclemarket.model.enums.BoatTypeEnum;

public record BoatSummaryDTO(Long id,
                             String name,
                             String brand,
                             String model,
                             double price,
                             int productionYear,
                             BoatTypeEnum boatType) {}
