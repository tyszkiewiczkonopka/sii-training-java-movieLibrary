package handlers;

import models.Actor;

import java.util.Scanner;

public class UserInputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static MenuOptions getMenuOptionFromUser(){
        return MenuOptions.values()[getSelectedOptionFromUser() - 1]; // odejmujemy jedynkę, bo w metodzie dodawaliśmy jedynkę
    }

    private static int getSelectedOptionFromUser() {
        int result = getIntegerFromUser();

        scanner.nextLine();

        if(result > 0 && result < MenuOptions.values().length + 1){ // zasada indeksu od 0 wymusza dodanie 1
            return result;
        }else {
            System.out.println("You selected non existing option: " + result + "\n" +
                    "Please try again.");
            return getSelectedOptionFromUser(); // metoda wywoływana do skutku, aż użytkownik poda to czego oczekujemy
        }
    }

    private static int getIntegerFromUser() {
        while (!scanner.hasNextInt()){
            scanner.nextLine();
            System.out.println("It is not an integer, please try again.");
        }
        return scanner.nextInt();
    }

    public static Actor getActorFromUser(){
        System.out.println("Type which actor's filmography you want to display");
        String[] usersActor = scanner.nextLine().split(" ");

        return new Actor(usersActor[0], usersActor[1]);
    }

}