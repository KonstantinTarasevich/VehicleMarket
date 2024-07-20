package my.vehiclemarket.repos;

import my.vehiclemarket.model.entity.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<TruckEntity, Long> {
    TruckEntity update(TruckEntity truck);
}
