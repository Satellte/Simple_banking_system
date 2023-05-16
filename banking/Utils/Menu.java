package banking.Utils;
import java.util.Random;
import java.util.Scanner;

import static banking.Utils.SQLConnection.*;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public static void printMainMenu(){
        System.out.println("""
                1. Create an account
                2. Log into account
                0. Exit""");
        int select = scanner.nextInt();
        mainMenu(select);
    }
    static void mainMenu(int select){
        switch (select) {
            case 1 -> createAccount();
            case 2 -> logInAccount();
            case 0 -> {
                System.out.println("\nBye!");
                System.exit(0);
            }
            default -> {
                System.out.println("Wrong input\n");
                printMainMenu();
            }
        }
    }

    static void createAccount(){
        String cardNumber = generateValidCardNumber();

        StringBuilder pin = new StringBuilder();
        Random randomPin = new Random();
        int pincode = randomPin.nextInt(10000);
        while (pincode < 1000 ){
            pincode = randomPin.nextInt(10000);
        }
        pin.append(pincode);
        addAccount(cardNumber, pin.toString());
        System.out.println("\nYour card has been created\n" +
                "Your card number:\n" +
                cardNumber +
                "\nYour card PIN:\n" +
                pin + "\n");
        printMainMenu();
    }

    static void logInAccount(){
        System.out.println("Enter your card number:");
        long enteredCardNumber = scanner.nextLong();
        System.out.println("Enter your PIN:");
        int enteredPin = scanner.nextInt();

        if (checkExistInBase(String.valueOf(enteredCardNumber), String.valueOf(enteredPin))){
            System.out.println("\nYou have successfully logged in!\n");
            submenu(String.valueOf(enteredCardNumber), String.valueOf(enteredPin));
       } else {
           System.out.println("Wrong card number or PIN!\n");
            printMainMenu();
       }

    }
    public static void submenu(String cardNumber, String pin){
        System.out.println("""
                1. Balance
                2. Add income
                3. Do transfer
                4. Close account
                5. Log out
                0. Exit""");
        int selection = scanner.nextInt();
        switch (selection) {
            case 1 -> {
                printBalance(cardNumber);
                submenu(cardNumber, pin);
            }
            case 2 -> {
                addIncome(cardNumber);
                submenu(cardNumber, pin);
            }
            case 3 -> {
                doTransfer(cardNumber);
                submenu(cardNumber, pin);
            }
            case 4 -> {
                closeAccount(cardNumber);
                printMainMenu();
            }
            case 5 -> {
                System.out.println("You have successfully logged out!\n");
                printMainMenu();
            }
            case 0 -> System.exit(0);
            default -> {
                System.out.println("Wrong input\n");
                submenu(cardNumber, pin);
            }
        }
    }
    public static String generateValidCardNumber() {
        String cardNumber;
        boolean isValid;
        do {
            cardNumber = generateCardNumber();
            isValid = validateCardNumber(cardNumber);
        } while (!isValid);
        return cardNumber;
    }
    public static String generateCardNumber() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder("400000");
        for (int i = 0; i < 9; i++) {
            builder.append(random.nextInt(10));
        }
        builder.append(calculateLuhnDigit(builder.toString()));
        return builder.toString();
    }
    public static boolean validateCardNumber(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
    public static int calculateLuhnDigit(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        int remainder = sum % 10;
        if (remainder == 0) {
            return 0;
        }
        return 10 - remainder;
    }

}
