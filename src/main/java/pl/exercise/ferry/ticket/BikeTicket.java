package pl.exercise.ferry.ticket;

import pl.exercise.ferry.vehicle.VehicleType;

import java.math.BigDecimal;

public class BikeTicket extends VehicleTicket {
    public BikeTicket(VehicleType vehicleType, String owner) {
        super(vehicleType, owner);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(10);
    }

    @Override
    public String toString() {
        return "| Vehicle-Bike " + getPrice() + " PLN";
    }

}
