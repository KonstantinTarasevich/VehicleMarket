package my.vehiclemarket.model.dto;

import my.vehiclemarket.model.enums.TruckTypeEnum;

public record TruckSummaryDTO(
        Long id,
        String name,
        String brand,
        String model,
        double price,
        int productionYear,
        TruckTypeEnum truckType,
        int loadCapacity
) {
}
