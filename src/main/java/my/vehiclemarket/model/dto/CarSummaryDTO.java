package my.vehiclemarket.model.dto;

import my.vehiclemarket.model.enums.CarTypeEnum;
import my.vehiclemarket.model.enums.EngineTypeEnum;

public record CarSummaryDTO(
        Long id,
        String name,
        String brand,
        String model,
        double price,
        int productionYear,
        CarTypeEnum carType,
        int horsepower,
        EngineTypeEnum engineType
) {
}
