package pl.exercise.ferry.ticket;

import pl.exercise.ferry.vehicle.VehicleType;

import java.math.BigDecimal;

public class CarTicket extends VehicleTicket {
    CarTicket(VehicleType vehicleType, String owner) {
        super(vehicleType, owner);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(20);
    }
}
