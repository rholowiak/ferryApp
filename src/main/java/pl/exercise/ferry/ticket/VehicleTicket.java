package pl.exercise.ferry.ticket;

import java.math.BigDecimal;
import pl.exercise.ferry.vehicle.VehicleType;

public abstract class VehicleTicket extends AbstractTicket {

  private final VehicleType vehicleType;
  private final String owner;

  VehicleTicket(VehicleType vehicleType, String owner) {
    this.vehicleType = vehicleType;
    this.owner = owner;
  }
}
