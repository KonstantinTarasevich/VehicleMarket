package my.vehiclemarket.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "motorcycles")
public class MotorcycleEntity extends BaseVehicleEntity {

    @Column(nullable = false, name = "horse_power")
    private int horsePower;

    public int getHorsePower() {
        return horsePower;
    }

    public MotorcycleEntity setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }
}
