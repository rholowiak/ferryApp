package pl.exercise.ferry.singleton;

import org.w3c.dom.ls.LSOutput;
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

        // metoda dodająca tickety do listy
        public void addToList(Ticket ticket){
            list.add(ticket);
        }

        public int numberOfTicketsPurchased (){
            return list.size();
        }

        public String listOfTickets() {
            StringBuilder sb = new StringBuilder();

            for (Ticket ticket : list) {
                sb.append(ticket);
                sb.append("\t");
            }

            return sb.toString();
        }
    }

