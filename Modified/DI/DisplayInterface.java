package Modified.DI;

import java.sql.SQLException;
import java.util.Scanner;
import static Modified.BL.businessLogic.*;
import static Modified.DAO.Bank.*;

public class DisplayInterface {
    public static Scanner scanner = new Scanner(System.in);
    public static void printMainMenu() throws SQLException {
        System.out.println("""
                1. Create an account
                2. Log into account
                0. Exit""");
        int select = scanner.nextInt();
        mainMenuSelection(select);
    }
    public static void printNewGeneratedAccount(String cardNumber, StringBuilder pin){
        System.out.println();
        System.out.println("\nYour card has been created\n" +
                "Your card number:\n" +
                cardNumber +
                "\nYour card PIN:\n" +
                pin + "\n");
    }
    public static void loginScreen() throws SQLException {
        System.out.println("\nEnter your card number:");
        long cardNumber = scanner.nextLong();
        System.out.println("Enter your PIN:");
        int pin = scanner.nextInt();
        if (queryCheckingCardAndPinInBase(String.valueOf(cardNumber), String.valueOf(pin))){
            printLoginMenu(String.valueOf(cardNumber));
        } else {
            printMessage(2);
            printMainMenu();
        }
    }
    public static void printLoginMenu(String currentCard) throws SQLException {
        System.out.println();
        System.out.println("""
                1. Balance
                2. Add income
                3. Do transfer
                4. Close account
                5. Log out
                0. Exit""");
        int select = scanner.nextInt();
        loginMenuSelection(currentCard, select);
    }
    public static void printBalance(String balance){
        System.out.println();
        System.out.println("Balance: " + balance + "\n");
    }
    public static void printInvitationToTransfer(){
        System.out.println("Transfer\n" +
                "Enter card number:");
    }
    public static void printMessage(int code){
        switch (code) {
        case 1 -> System.out.println("Success");
        case 2 -> System.out.println("The card doesn't exist\n");
        case 3 -> System.out.println("Bye!");
        case 4 -> System.out.println("Wrong input\n");
        case 5 -> System.out.println("Not enough money\n");
        case 7 -> System.out.println("You have successfully logged out!\n");
        case 8 -> System.out.println("Enter how much money you want to transfer:");
        case 9 -> System.out.println("Enter income:");
        }

    }
}
