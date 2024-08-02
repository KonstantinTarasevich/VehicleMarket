package my.vehiclemarket.model.dto;

public record UserDetailsDTO(
        Long id,
        String name,
        String username,
        String email,
        String phone
) {
}
