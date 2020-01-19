package pl.exercise.ferry.ticket;

import pl.exercise.ferry.vehicle.VehicleType;

import java.math.BigDecimal;

public class TruckTicket extends VehicleTicket {
    private double vehicleWeight;

    public TruckTicket(VehicleType vehicleType, double vehicleWeight) {
        super(vehicleType, "unknown");
        this.vehicleWeight = vehicleWeight;
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(10).multiply(new BigDecimal(vehicleWeight));
    }

    @Override
    public String toString() {
        return "TruckTicket";
    }
}
