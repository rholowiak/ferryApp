package pl.exercise.ferry.screen;

import pl.exercise.ferry.singleton.Singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainScreen implements Screen {

  private final Scanner in = new Scanner(System.in);

  public void interact() throws IOException {
    System.out.println("Total amount:" + Singleton.INSTANCE.getTotalAmount() + " PLN");
    System.out.println("Ilosc zakupionych biletów: " + Singleton.INSTANCE.numberOfTicketsPurchased());
    System.out.println(Singleton.INSTANCE.listOfTickets());
    System.out.println("Witamy w systemie zakupów biletów, wybierz akcję:");
    System.out.println("1. Kup bilet");
    System.out.println("2. Zapisz wybór transakcji");
    String firstResponse = in.nextLine();
    if ("1".equalsIgnoreCase(firstResponse)) {
      TicketScreen ticketScreen = new TicketScreen();
      ticketScreen.interact();
    }else if("2".equalsIgnoreCase(firstResponse)){
//      Files.createFile(Paths.get("D:\\JAVA source codes\\ferryApp\\plik1.txt"));
      FileWriter fileWriter = new FileWriter("D:\\JAVA source codes\\ferryApp\\plik1.txt", true);
      PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("Ilosc zakupionych biletów: %d \n", Singleton.INSTANCE.numberOfTicketsPurchased()); // prints a formatted string
        printWriter.println(Singleton.INSTANCE.listOfTickets());// prints a string and then terminates the line
        printWriter.println();
        printWriter.close();
        Singleton.INSTANCE.clear();
    }else {
      MainScreen mainScreen = new MainScreen();
      mainScreen.interact();
    }
  }
}
