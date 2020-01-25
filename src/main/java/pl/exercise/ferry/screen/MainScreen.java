package pl.exercise.ferry.screen;

import pl.exercise.ferry.singleton.Singleton;
import pl.exercise.ferry.ticket.*;
import pl.exercise.ferry.vehicle.VehicleType;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainScreen implements Screen {

  private final Scanner in = new Scanner(System.in);

  public void interact() throws IOException {
    System.out.println("Total amount:" + Singleton.INSTANCE.getTotalAmount() + " PLN");
    System.out.println("Ilosc zakupionych biletów: " + Singleton.INSTANCE.numberOfTicketsPurchased());
    System.out.println(Singleton.INSTANCE.listOfTickets());
    System.out.println("Witamy w systemie zakupów biletów, wybierz akcję:");
    System.out.println("1. Kup bilet");
    System.out.println("2. Zapisz wybór transakcji do pliku bilety");
    System.out.println("3. Przywróć poprzednio zapisaną sesję");
    String firstResponse = in.nextLine();
    if ("1".equalsIgnoreCase(firstResponse)) {
      TicketScreen ticketScreen = new TicketScreen();
      ticketScreen.interact();
    }else if("2".equalsIgnoreCase(firstResponse)){
      FileWriter fileWriter =
              new FileWriter("D:\\JAVA source codes\\ferryApp\\ferryTickets\\ticketNumber " + Singleton.INSTANCE.getEntry() + ".txt",false);
      PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(Singleton.INSTANCE.listOfTickets());// prints a string and then terminates the line
        printWriter.close();
        Singleton.INSTANCE.clear();
    }else if("3".equalsIgnoreCase(firstResponse)){

      List<String> listOfPathToTicket = new ArrayList<>();
      //wyświetlia dostępne pliki w folderze - How to list all files in a directory?
      try (Stream<Path> walk = Files.walk(Paths.get("D:\\JAVA source codes\\ferryApp\\ferryTickets"))) {

        listOfPathToTicket = walk.filter(Files::isRegularFile)
                .map(x -> x.toString()).collect(Collectors.toList());

        listOfPathToTicket.forEach(System.out::println);

      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("Which ticket do you want? Please give Ticket number:");
      int secondResponse = in.nextInt();
      String chosenTicket = listOfPathToTicket.get(secondResponse);

      List<String> sessionEntries = Files.readAllLines(Paths.get(chosenTicket));
      System.out.println(sessionEntries.toString());

      String[] splitEntries = sessionEntries.get(0).split(";");
      System.out.println(Arrays.toString(splitEntries));

      for (String entry: splitEntries) {
        String[] splitEntryParams = entry.split(",");
        System.out.println(Arrays.toString(splitEntryParams));
        if (splitEntryParams[0].equalsIgnoreCase("Person-Child")){
          ChildTicket childTicket = new ChildTicket("unknown");
          Singleton.INSTANCE.addToList(childTicket);
          Singleton.INSTANCE.addAmount(childTicket.getPrice().doubleValue());
        }
        if (splitEntryParams[0].equalsIgnoreCase("Person-Young")){
          YoungTicket youngTicket = new YoungTicket("unknown");
          Singleton.INSTANCE.addToList(youngTicket);
          Singleton.INSTANCE.addAmount(youngTicket.getPrice().doubleValue());
        }
        if (splitEntryParams[0].equalsIgnoreCase("Person-Adult")){
          AdultTicket adultTicket = new AdultTicket("unknown");
          Singleton.INSTANCE.addToList(adultTicket);
          Singleton.INSTANCE.addAmount(adultTicket.getPrice().doubleValue());
        }
        if (splitEntryParams[0].equalsIgnoreCase("Person-Senior")){
          SeniorTicket seniorTicket = new SeniorTicket("unknown");
          Singleton.INSTANCE.addToList(seniorTicket);
          Singleton.INSTANCE.addAmount(seniorTicket.getPrice().doubleValue());
        }
        if (splitEntryParams[0].equalsIgnoreCase("Vehicle-Car")){
          CarTicket carTicket = new CarTicket(VehicleType.CAR,"unknown");
          Singleton.INSTANCE.addToList(carTicket);
          Singleton.INSTANCE.addAmount(carTicket.getPrice().doubleValue());
        }
        if (splitEntryParams[0].equalsIgnoreCase("Vehicle-Bike")){
          BikeTicket bikeTicket = new BikeTicket(VehicleType.BIKE, "unknown");
          Singleton.INSTANCE.addToList(bikeTicket);
          Singleton.INSTANCE.addAmount(bikeTicket.getPrice().doubleValue());
        }
        if (splitEntryParams[0].equalsIgnoreCase("Vehicle-Bus")){
          BusTicket busTicket = new BusTicket(VehicleType.BUS, Double.parseDouble(splitEntryParams[1]));
          Singleton.INSTANCE.addToList(busTicket);
          Singleton.INSTANCE.addAmount(busTicket.getPrice().doubleValue());
        }
        if (splitEntryParams[0].equalsIgnoreCase("Vehicle-Truck")){
          TruckTicket truckTicket = new TruckTicket(VehicleType.TRUCK, Double.parseDouble(splitEntryParams[1]));
          Singleton.INSTANCE.addToList(truckTicket);
          Singleton.INSTANCE.addAmount(truckTicket.getPrice().doubleValue());
        }
      }
      MainScreen mainScreen = new MainScreen();
      mainScreen.interact();

    }else {
      MainScreen mainScreen = new MainScreen();
      mainScreen.interact();
    }
  }
}
