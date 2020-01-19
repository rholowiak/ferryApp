package pl.exercise.ferry.singleton;

import pl.exercise.ferry.ticket.BusTicket;
import pl.exercise.ferry.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
        public static final Singleton INSTANCE = new Singleton();
        private double totalAmount = 0;

        List<Ticket> list = new ArrayList<Ticket>();

        private Singleton() {
        }

        public void addAmount(double price){
            this.totalAmount = totalAmount + price;
        }

        public double getTotalAmount() {
            return totalAmount;
        }
        //dodać metody dodające tickety do listy

    }

