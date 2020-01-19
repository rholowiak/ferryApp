package pl.exercise.ferry.ticket;

import pl.exercise.ferry.vehicle.VehicleType;

public abstract class PersonTicket extends AbstractTicket{
    private final String personName;

    public PersonTicket(String personName){
        this.personName = personName;
    }
}

