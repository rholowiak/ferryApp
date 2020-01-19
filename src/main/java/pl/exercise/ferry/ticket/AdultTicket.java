package pl.exercise.ferry.ticket;

import java.math.BigDecimal;

public class AdultTicket extends PersonTicket {
    public AdultTicket(String personName) {
        super(personName);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(10);
    }

    @Override
    public String toString() {
        return "| Person-Adult " + getPrice() + " PLN";
    }
}
