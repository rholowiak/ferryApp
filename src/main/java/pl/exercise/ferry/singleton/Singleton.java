package pl.exercise.ferry.singleton;

import org.w3c.dom.ls.LSOutput;
import pl.exercise.ferry.screen.MainScreen;
import pl.exercise.ferry.ticket.BusTicket;
import pl.exercise.ferry.ticket.Ticket;

import java.io.IOException;
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
            }

            return sb.toString();
        }
        public void clear() throws IOException {
            this.totalAmount = 0;
            list.clear();
            MainScreen mainScreen = new MainScreen();
            mainScreen.interact();
        }
    }

