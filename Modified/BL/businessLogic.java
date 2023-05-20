package Modified.BL;

import java.sql.SQLException;
import java.util.Random;
import static Modified.DAO.Bank.*;
import static Modified.DI.DisplayInterface.*;

/**
 * businessLogic is a class that performs data generation,
 * validation, switching between different menus
 * and calling methods for database operation
 */
public class businessLogic {
    /**
     * mainMenuSelection depending on the user's choice
     * calls the methods of card generation and pin or login invitation
     * @param select is user's selection
     */
    public static void mainMenuSelection(int select) throws SQLException {
        switch (select) {
            case 1 -> createAccount();
            case 2 -> loginScreen();
            case 0 -> {
                printMessage(3);
                System.exit(0);
            }
            default -> {
                printMessage(4);
                printMainMenu();
            }
        }
    }

    /**
     * createAccount calls the method for generating the card and pin,
     * and then calls the method for writing the generated data to the database
     */
    static void createAccount() throws SQLException {
        String cardNumber = generateValidCardNumber();
        StringBuilder pin = new StringBuilder();
        Random randomPin = new Random();
        int pincode = randomPin.nextInt(10000);
        while (pincode < 1000 ){
            pincode = randomPin.nextInt(10000);
        }
        pin.append(pincode);
        printNewGeneratedAccount(cardNumber, pin);
        connect();
        queryForAddAccount(cardNumber, pin.toString());
        closeConnection();
        printMainMenu();
    }

    /**
     * generateValidCardNumber returns valid new card number
     * @return 16 digit of new valid card number
     */
    public static String generateValidCardNumber() {
        String cardNumber;
        boolean isValid;
        do {
            cardNumber = generateCardNumber();
            isValid = validateCardNumber(cardNumber);
        } while (!isValid);
        return cardNumber;
    }

    /**
     * generateCardNumber generates first fifteenth digits of the new card number
     * @return 16 digit of new card number
     */
    public static String generateCardNumber() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder("400000");
        for (int i = 0; i < 9; i++) {
            builder.append(random.nextInt(10));
        }
        builder.append(calculateLuhnDigit(builder.toString()));
        return builder.toString();
    }

    /**
     * validateCardNumber is validate new generated card number
     * @param cardNumber is generated 16 digits of new card number
     * @return 16 digits of new generated card number
     */
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

    /**
     * calculateLuhnDigit is calculated last sixteenth digit of card number for validate
     */
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

    /**
     * loginMenuSelection depending on the user's choice calls the methods of manipulation with account
     */
    public static void loginMenuSelection(String currentCard, int selection) throws SQLException {
        switch (selection) {
            case 1 -> {
                connect();
                queryForPrintBalance(currentCard);
                closeConnection();
                printLoginMenu(currentCard);
            }
            case 2 -> {
                printMessage(9);
                long income = scanner.nextLong();
                connect();
                queryToAddIncome(currentCard, income);
                closeConnection();
                printLoginMenu(currentCard);
            }
            case 3 -> {
                printInvitationToTransfer();
                long recipientsCard = scanner.nextLong();
                if (queryCheckingCardInBase(String.valueOf(recipientsCard))){
                    printMessage(8);
                    long amountToTransfer = scanner.nextLong();
                    if (queryCheckAvailableAmount(currentCard, amountToTransfer)) {
                        connect();
                        doTransfer(currentCard, String.valueOf(recipientsCard), String.valueOf(amountToTransfer));
                        closeConnection();
                        printMessage(1);
                    } else printMessage(5);
                } else printMessage(2);
                printLoginMenu(currentCard);
            }
            case 4 -> {
                connect();
                closeAccount(currentCard);
                closeConnection();
                printMainMenu();
            }
            case 5 -> {
                printMessage(7);
                printMainMenu();
            }
            case 0 -> System.exit(0);
            default -> {
                printMessage(4);
                printLoginMenu(currentCard);
            }
        }
    }
}
