package my.vehiclemarket.model.dto;


public record MotorcycleDetailsDTO(
        Long id,
        String name,
        String brand,
        String model,
        String imageURL,
        double fuelConsumption,
        String description,
        double price,
        int horsePower,
        int productionYear,
        String ownerPhone
) {
}
