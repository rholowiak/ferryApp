package pl.exercise.ferry.ticket;

import pl.exercise.ferry.pricing.PriceVisitor;
import pl.exercise.ferry.vehicle.VehicleType;

public class BikeTicket extends VehicleTicket {

  BikeTicket(VehicleType vehicleType, String owner) {
    super(vehicleType, owner);
  }

  @Override
  public <T> T accept(PriceVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
