package Modified.DAO;

import java.sql.*;
import static Modified.DI.DisplayInterface.*;

/**
 * Bank class is created connection to database with accounts,
 * and also performs manipulations with the database
 */
public class Bank {
public static Connection connection;
public static String pathToBase;
/**
 * setUrlToBase sets the path to the database
 */
    public static void setUrlToBase(String path) {
        pathToBase = path;
    }

    /**
     * connect set connection to database
     */
    public static void connect() throws SQLException {
        String url = "jdbc:sqlite:" + pathToBase;
        connection = DriverManager.getConnection(url);
    }

    /**
     * queryForCreateTable create query for create table HyperSkill
     * with columns CardNumber, pin and balance
     */
    public static void queryForCreateTable() throws SQLException{
        String query = "CREATE TABLE IF NOT EXISTS HyperSkill (CardNumber VARCHAR(16), " +
                "Pin VARCHAR(4), " +
                "Balance DECIMAL(10,2))";
        makeInjection(query);
    }

    /**
     * queryForAddAccount create query for add account to the database
     * @param cardNumber is new generated valid card number
     * @param pin is new generated pin for card number
     */
    public static void queryForAddAccount(String cardNumber, String pin) throws SQLException{
        String query = "INSERT INTO HyperSkill (CardNumber, Pin, Balance) VALUES " +
                "('" + cardNumber + "', '" + pin + "', 0);";
        makeInjection(query);
    }

    /**
     * queryCheckingCardAndPinInBase create query for check card number and pin in database
     * @param cardNumber is logged card number
     * @param pin is pin for logged card number
     * @return boolean answer of existing this card number and pin in database
     */
    public static boolean queryCheckingCardAndPinInBase(String cardNumber, String pin) throws SQLException {
        boolean exist = false;
        String query = "SELECT * FROM HyperSkill WHERE " +
                "CardNumber = " + cardNumber + " and " +
                "Pin = " + pin + ";";
        connect();
        if (checkingBase(query)){
            exist = true;
        }
        closeConnection();
        return exist;
    }

    /**
     * queryForPrintBalance create query for checking balance
     * @param cardNumber is logged card number
     */
    public static void queryForPrintBalance(String cardNumber) throws SQLException {
        long balance;
        String query = "SELECT Balance FROM HyperSkill WHERE " + "CardNumber = " + cardNumber + ";";
        balance = returnBalance(query);
        printBalance(String.valueOf(balance));
    }

    /**
     * returnBalance return current balance
     * @return balance
     */
    public static long returnBalance(String query) throws SQLException {
        long balance = 0;
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                balance = resultSet.getLong("balance");
            }
        }
        return balance;
    }

    /**
     * queryToAddIncome is create query to add income
     * @param cardNumber is logged card number
     * @param income is amount of income
     */
    public static void queryToAddIncome(String cardNumber, long income) throws SQLException {
        String query = "UPDATE HyperSkill " +
                "SET Balance = Balance + " + income +
                " WHERE CardNumber = " + cardNumber + ";";
        makeInjection(query);
    }

    /**
     * doTransfer is decreasing balance of current account
     * and increasing balance of receiver's account by the specified amount
     * @param cardNumber is logged card number
     * @param recipientsCard is receiver's card number
     * @param amountToTransfer is account for transfer
     */
    public static void doTransfer(String cardNumber, String recipientsCard, String amountToTransfer) throws SQLException {
        String decreaseAmount = "UPDATE HyperSkill " +
                "SET Balance = Balance - " + amountToTransfer +
                " WHERE CardNumber = " + cardNumber + ";";
        makeInjection(decreaseAmount);
        String increaseAmount = "UPDATE HyperSkill " +
                "SET Balance = Balance + " + amountToTransfer +
                " WHERE CardNumber = " + recipientsCard + ";";
        makeInjection(increaseAmount);
    }
    public static void closeAccount(String cardNumber) throws SQLException {
        String decreaseAmount = "DELETE FROM HyperSkill " + "WHERE CardNumber = " + cardNumber + ";";
        makeInjection(decreaseAmount);
    }

    /**
     * queryCheckingCardInBase is created query for checking card in base
     * @param cardNumber entered card number
     * @return boolean answer of existing of entered card number
     */
    public static boolean queryCheckingCardInBase(String cardNumber) throws SQLException {
        boolean exist = false;
        String query = "SELECT * FROM HyperSkill WHERE " + "CardNumber = " + cardNumber + ";";
        connect();
        if (checkingBase(query)){
            exist = true;
        } else {
            printMessage(2);
        }
        closeConnection();
        return exist;
    }

    /**
     * queryCheckAvailableAmount is created query for check available amount in the balance
     * @param currentCard is entered card number
     * @param amountToTransfer is entered amount to transfer
     * @return boolean answer of existing amount
     */
    public static boolean queryCheckAvailableAmount(String currentCard, long amountToTransfer) throws SQLException {
        boolean enough = false;
        long balance;
        String query = "SELECT Balance FROM HyperSkill WHERE " + "CardNumber = " + currentCard + ";";
        connect();
        balance = returnBalance(query);
        closeConnection();
        if (balance >= amountToTransfer){
            enough = true;
        }
        return enough;
    }

    /**
     * makeInjection is make injection of query to database
     * @param query some query
     */
    public static void makeInjection(String query) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } else {
            System.out.println("Connection is not established.");
        }
    }

    /**
     * checkingBase is checking any query in database
     * @return boolean answer of query
     */
    public static boolean checkingBase(String query) throws SQLException {
        boolean done = false;
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                done = true;
            }
        }
        return done;
    }

    /**
     * closeConnection is closing connection with database
     */
    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

}