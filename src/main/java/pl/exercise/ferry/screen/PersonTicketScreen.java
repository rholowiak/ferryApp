package pl.exercise.ferry.screen;

import pl.exercise.ferry.singleton.Singleton;
import pl.exercise.ferry.ticket.AdultTicket;
import pl.exercise.ferry.ticket.ChildTicket;
import pl.exercise.ferry.ticket.SeniorTicket;
import pl.exercise.ferry.ticket.YoungTicket;

import java.io.IOException;
import java.util.Scanner;

public class PersonTicketScreen implements Screen {
    private final Scanner in = new Scanner(System.in);
    @Override
    public void interact() throws IOException {
        System.out.println("Podaj wiek dla osoby, dla której chcesz kupić bilet:");
        int age = in.nextInt();
        if(age < 3){
            System.out.println("Cena biletu 0 PLN");
            ChildTicket childTicket = new ChildTicket("unknown");
            Singleton.INSTANCE.addAmount(childTicket.getPrice().doubleValue());
            Singleton.INSTANCE.addToList(childTicket);
        }else if(age <18){
            System.out.println("Cena biletu 5 PLN");
            YoungTicket youngTicket = new YoungTicket("unknown");
            Singleton.INSTANCE.addAmount(youngTicket.getPrice().doubleValue());
            Singleton.INSTANCE.addToList(youngTicket);

        }else if(age < 70){
            System.out.println("Cena biletu 10 PLN");
            AdultTicket adultTicket = new AdultTicket("unknown");
            Singleton.INSTANCE.addAmount(adultTicket.getPrice().doubleValue());
            Singleton.INSTANCE.addToList(adultTicket);

        }else{
            System.out.println("Cena biletu 5 PLN");
            SeniorTicket seniorTicket = new SeniorTicket("unknown");
            Singleton.INSTANCE.addAmount(seniorTicket.getPrice().doubleValue());
            Singleton.INSTANCE.addToList(seniorTicket);

        }
        MainScreen mainScreen = new MainScreen();
        mainScreen.interact();

    }
}
