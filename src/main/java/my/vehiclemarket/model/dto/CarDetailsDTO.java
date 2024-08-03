package my.vehiclemarket.model.dto;

import my.vehiclemarket.model.enums.CarTypeEnum;
import my.vehiclemarket.model.enums.EngineTypeEnum;
import my.vehiclemarket.model.enums.TransmissionTypeEnum;

public record CarDetailsDTO(
        Long id,
        String name,
        String brand,
        String model,
        String imageURL,
        double fuelConsumption,
        String description,
        double price,
        TransmissionTypeEnum transmissionType,
        CarTypeEnum carType,
        EngineTypeEnum engineType,
        int horsePower,
        int productionYear,
        String ownerPhone
) {
}
