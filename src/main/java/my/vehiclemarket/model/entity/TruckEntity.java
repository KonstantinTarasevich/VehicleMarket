package my.vehiclemarket.model.entity;

import jakarta.persistence.*;
import my.vehiclemarket.model.enums.TruckTypeEnum;

@Entity
@Table(name = "trucks")
public class TruckEntity extends BaseVehicleEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "truck_type")
    private TruckTypeEnum truckType;

    @Column(nullable = false, name = "load_capacity")
    private int loadCapacity;

    public TruckTypeEnum getTruckType() {
        return truckType;
    }

    public TruckEntity setTruckType(TruckTypeEnum truckType) {
        this.truckType = truckType;
        return this;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public TruckEntity setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
        return this;
    }
}
