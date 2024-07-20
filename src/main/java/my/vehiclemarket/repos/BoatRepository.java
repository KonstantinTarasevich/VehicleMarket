package my.vehiclemarket.repos;

import my.vehiclemarket.model.entity.BoatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatRepository extends JpaRepository<BoatEntity, Long> {
    BoatEntity update(BoatEntity boat);
}
