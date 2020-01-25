package pl.exercise.ferry.ticket;

import java.math.BigDecimal;

public class SeniorTicket extends PersonTicket {
    public SeniorTicket(String personName) {
        super(personName);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(5);
    }

    @Override
    public String toString() {
        return "Person-Senior;";
    }
}
