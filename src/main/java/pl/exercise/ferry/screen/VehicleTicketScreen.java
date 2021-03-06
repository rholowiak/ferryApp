package pl.exercise.ferry.screen;

import pl.exercise.ferry.singleton.Singleton;
import pl.exercise.ferry.ticket.*;
import pl.exercise.ferry.vehicle.VehicleType;

import java.io.IOException;
import java.util.Scanner;

public class VehicleTicketScreen implements Screen {
    private final Scanner in = new Scanner(System.in);

    @Override
    public void interact() throws IOException {
        System.out.println("Podaj typ pojazdu:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Bus");
        System.out.println("4. Truck");
        int vehicleType = in.nextInt();

        switch (vehicleType){
            case 1:
                System.out.println("Cena biletu 20 PLN");
                CarTicket carTicket = new CarTicket(VehicleType.CAR,"unknown");
                Singleton.INSTANCE.addToList(carTicket);
                Singleton.INSTANCE.addAmount(carTicket.getPrice().doubleValue());
                break;
            case 2:
                System.out.println("Cena biletu 10 PLN");
                BikeTicket bikeTicket = new BikeTicket(VehicleType.BIKE, "unknown");
                Singleton.INSTANCE.addToList(bikeTicket);
                Singleton.INSTANCE.addAmount(bikeTicket.getPrice().doubleValue());
                break;
            case 3:
                System.out.println("Podaj długość pojazdu w metrach:");
                double vehicleLong = in.nextDouble();
                BusTicket busTicket = new BusTicket(VehicleType.BUS, vehicleLong);
                System.out.println("Cena biletu " + busTicket.getPrice() + " PLN");
                Singleton.INSTANCE.addToList(busTicket);
//                Singleton.INSTANCE.addAmount(vehicleLong * 5);
                Singleton.INSTANCE.addAmount(busTicket.getPrice().doubleValue());
                break;
            case 4:
                System.out.println("Podaj ciężar pojazdu w tonach:");
                double vehicleWeight = in.nextDouble();
                TruckTicket truckTicket = new TruckTicket(VehicleType.TRUCK, vehicleWeight);
                System.out.println("Cena biletu " + truckTicket.getPrice() + " PLN");
                Singleton.INSTANCE.addToList(truckTicket);
//                Singleton.INSTANCE.addAmount(vehicleWeight * 10);
                Singleton.INSTANCE.addAmount(truckTicket.getPrice().doubleValue());

                break;
            default:
                VehicleTicketScreen vehicleTicketScreen = new VehicleTicketScreen();
                vehicleTicketScreen.interact();
        }
        MainScreen mainScreen = new MainScreen();
        mainScreen.interact();
    }
}
