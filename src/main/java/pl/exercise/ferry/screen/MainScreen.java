package pl.exercise.ferry.screen;

import pl.exercise.ferry.singleton.Singleton;

import java.util.Scanner;

public class MainScreen implements Screen {

  private final Scanner in = new Scanner(System.in);

  public void interact() {
    System.out.println("Total amount:" + Singleton.INSTANCE.getTotalAmount() + " PLN");
    System.out.println("Ilosc zakupionych biletów: " + Singleton.INSTANCE.numberOfTicketsPurchased());
    System.out.println(Singleton.INSTANCE.listOfTickets());
    System.out.println("Witamy w systemie zakupów biletów, wybierz akcję:");
    System.out.println("1. Kup bilet");
    String firstResponse = in.nextLine();
    if ("1".equalsIgnoreCase(firstResponse)) {
      TicketScreen ticketScreen = new TicketScreen();
      ticketScreen.interact();
    }else {
      MainScreen mainScreen = new MainScreen();
      mainScreen.interact();
    }
  }
}
