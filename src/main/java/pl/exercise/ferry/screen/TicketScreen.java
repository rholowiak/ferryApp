package pl.exercise.ferry.screen;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class TicketScreen implements Screen{

    private final Scanner in = new Scanner(System.in);

    @Override
    public void interact() {
        System.out.println("Wybierz bilet, który chcesz kupić:");
        System.out.println("1. Osoba");
        System.out.println("2. Pojazd");
        String secondResponse = in.nextLine();
        if("1".equals(secondResponse)){
            PersonTicketScreen personTicketScreen = new PersonTicketScreen();
            personTicketScreen.interact();
        }
        if("2".equals(secondResponse)){
            VehicleTicketScreen vehicleTicketScreen = new VehicleTicketScreen();
            vehicleTicketScreen.interact();
        }else {
            MainScreen mainScreen = new MainScreen();
            mainScreen.interact();
        }
    }
}
