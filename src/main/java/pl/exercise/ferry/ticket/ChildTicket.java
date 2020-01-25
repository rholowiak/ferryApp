package pl.exercise.ferry.ticket;

import java.math.BigDecimal;

public class ChildTicket extends PersonTicket {
    public ChildTicket(String personName) {
        super(personName);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(0);
    }

    @Override
    public String toString() {
        return "Person-Child;";
    }
}
