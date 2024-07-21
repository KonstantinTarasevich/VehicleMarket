package my.vehiclemarket.repos;

import my.vehiclemarket.model.entity.MotorcycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcycleRepository extends JpaRepository<MotorcycleEntity, Long> {

}
