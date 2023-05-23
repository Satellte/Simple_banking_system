package Modified.View;

import java.sql.SQLException;
import java.util.Scanner;
import static Modified.Service.Service.mainMenuSelection;
import static Modified.Service.Service.loginMenuSelection;
import static Modified.Service.Service.checkCardAndPinInBase;

/**
 * The DisplayInterface class is a user interface for the banking system.
 * It provides various methods of input and output of user information
 */
public class View {
    /**
     * The scanner is used as a general method of reading the information entered by the user
     */
    public static Scanner scanner = new Scanner(System.in);
    /**
     * printMainMenu displays the starting menu options:
     * Create an account
     * Log into account
     * Exit
     */
    public static void printMainMenu() throws SQLException {
        System.out.println("""
                1. Create an account
                2. Log into account
                0. Exit""");
        int select = scanner.nextInt();
        mainMenuSelection(select);
    }
    /**
     * printNewGeneratedAccount displays the generated card number and pin
     * @param cardNumber is new generated card number
     * @param pin is new generated pin
     */
    public static void printNewGeneratedAccount(String cardNumber, StringBuilder pin){
        System.out.println();
        System.out.println("\nYour card has been created\n" +
                "Your card number:\n" +
                cardNumber +
                "\nYour card PIN:\n" +
                pin + "\n");
    }
    /**
     * loginScreen offers user to enter the card number and pin to log in
     */
    public static void loginScreen() throws SQLException {
        System.out.println("\nEnter your card number:");
        long cardNumber = scanner.nextLong();
        System.out.println("Enter your PIN:");
        int pin = scanner.nextInt();
        if (checkCardAndPinInBase(String.valueOf(cardNumber), String.valueOf(pin))){
            printLoginMenu(String.valueOf(cardNumber));
        } else {
            printMessage(2);
            printMainMenu();
        }
    }
    /**
     * printLoginMenu displays the login menu options:
     * Balance
     * Add income
     * Do transfer
     * Close account
     * Log out
     * Exit
     * @param currentCard is the card number entered by user in the loginScreen
     */
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
    /**
     * printBalance display to user current balance
     * @param balance is account balance from database
     */
    public static void printBalance(String balance){
        System.out.println();
        System.out.println("Balance: " + balance + "\n");
    }
    /**
     * printInvitationToTransfer display invitation to user to enter the receiver's card number
     */
    public static void printInvitationToTransfer(){
        System.out.println("Transfer\n" +
                "Enter card number:");
    }
    /**
     * printMessage display frequently used messages
     */
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
