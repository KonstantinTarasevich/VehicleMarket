package my.vehiclemarket.model.dto;

public record MotorcycleSummaryDTO(
        Long id,
        String name,
        String brand,
        String model,
        double price,
        int horsePower,
        int productionYear
) {
}
