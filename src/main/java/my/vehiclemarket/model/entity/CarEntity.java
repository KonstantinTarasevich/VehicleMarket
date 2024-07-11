package my.vehiclemarket.model.entity;

import jakarta.persistence.*;
import my.vehiclemarket.model.enums.CarTypeEnum;
import my.vehiclemarket.model.enums.EngineTypeEnum;
import my.vehiclemarket.model.enums.TransmissionTypeEnum;

@Entity
@Table(name = "cars")
public class CarEntity extends BaseVehicleEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "transmission_type")
    private TransmissionTypeEnum transmissionType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "car_type")
    private CarTypeEnum carType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "engine_type")
    private EngineTypeEnum engineType;

    @Column(nullable = false, name = "horse_power")
    private int horsePower;

    public TransmissionTypeEnum getTransmissionType() {
        return transmissionType;
    }

    public CarEntity setTransmissionType(TransmissionTypeEnum transmissionType) {
        this.transmissionType = transmissionType;
        return this;
    }

    public CarTypeEnum getCarType() {
        return carType;
    }

    public CarEntity setCarType(CarTypeEnum carType) {
        this.carType = carType;
        return this;
    }

    public EngineTypeEnum getEngineType() {
        return engineType;
    }

    public CarEntity setEngineType(EngineTypeEnum engineType) {
        this.engineType = engineType;
        return this;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public CarEntity setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

}
