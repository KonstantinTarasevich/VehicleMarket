package my.vehiclemarket.repos;

import my.vehiclemarket.model.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    CarEntity update(CarEntity car);
}
