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
            Singleton.INSTANCE.addAmount(0);
            ChildTicket childTicket = new ChildTicket("unknown");
            Singleton.INSTANCE.addToList(childTicket);
        }else if(age <18){
            System.out.println("Cena biletu 5 PLN");
            Singleton.INSTANCE.addAmount(5);
            YoungTicket youngTicket = new YoungTicket("unknown");
            Singleton.INSTANCE.addToList(youngTicket);

        }else if(age < 70){
            System.out.println("Cena biletu 10 PLN");
            Singleton.INSTANCE.addAmount(10);
            AdultTicket adultTicket = new AdultTicket("unknown");
            Singleton.INSTANCE.addToList(adultTicket);

        }else{
            System.out.println("Cena biletu 5 PLN");
            Singleton.INSTANCE.addAmount(5);
            SeniorTicket seniorTicket = new SeniorTicket("unknown");
            Singleton.INSTANCE.addToList(seniorTicket);

        }
        MainScreen mainScreen = new MainScreen();
        mainScreen.interact();

    }
}
