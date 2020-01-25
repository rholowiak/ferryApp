package pl.exercise.ferry.ticket;

import pl.exercise.ferry.vehicle.VehicleType;

import java.math.BigDecimal;

public class BusTicket extends VehicleTicket {
    private double vehicleLong;

    public BusTicket(VehicleType vehicleType, double vehicleLong) {
        super(vehicleType, "unknown");
        this.vehicleLong = vehicleLong;
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(5).multiply(new BigDecimal(vehicleLong));
    }

    @Override
    public String toString() {
        return "Vehicle-Bus," + vehicleLong + ";";
    }
}
