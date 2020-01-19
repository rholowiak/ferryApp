package pl.exercise.ferry.screen;

import pl.exercise.ferry.singleton.Singleton;

import java.util.Scanner;

public class PersonTicketScreen implements Screen {
    private final Scanner in = new Scanner(System.in);
    @Override
    public void interact() {
        System.out.println("Podaj wiek dla osoby, dla której chcesz kupić bilet:");
        int age = in.nextInt();
        if(age < 3){
            System.out.println("Cena biletu 0 PLN");
            Singleton.INSTANCE.addAmount(0);
        }else if(age <18){
            System.out.println("Cena biletu 5 PLN");
            Singleton.INSTANCE.addAmount(5);

        }else if(age < 70){
            System.out.println("Cena biletu 10 PLN");
            Singleton.INSTANCE.addAmount(10);

        }else{
            System.out.println("Cena biletu 5 PLN");
            Singleton.INSTANCE.addAmount(5);

        }
        MainScreen mainScreen = new MainScreen();
        mainScreen.interact();

    }
}
