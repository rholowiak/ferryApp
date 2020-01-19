package pl.exercise.ferry.ticket;

import pl.exercise.ferry.vehicle.VehicleType;

import java.math.BigDecimal;

public class CarTicket extends VehicleTicket {
    public CarTicket(VehicleType vehicleType, String owner) {
        super(vehicleType, owner);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(20);
    }

    @Override
    public String toString() {
        return "| Vehicle-Car " + getPrice() + " PLN";
    }
}
