package my.vehiclemarket.model.dto;


import my.vehiclemarket.model.enums.BoatTypeEnum;

public record BoatSummaryDTO(Long id,
                             String name,
                             String brand,
                             String model,
                             Double price,
                             int productionYear,
                             BoatTypeEnum boatType) {}
