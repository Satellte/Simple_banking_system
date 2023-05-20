package Modified.DAO;

import java.sql.*;
import static Modified.DI.DisplayInterface.*;

public class Bank {
public static Connection connection;
public static String pathToBase;
    public static void setUrlToBase(String path) {
        pathToBase = path;
    }
    public static void connect() throws SQLException {
        String url = "jdbc:sqlite:" + pathToBase;
        connection = DriverManager.getConnection(url);
    }
    public static void queryForCreateTable() throws SQLException{
        String query = "CREATE TABLE IF NOT EXISTS HyperSkill (CardNumber VARCHAR(16), " +
                "Pin VARCHAR(4), " +
                "Balance DECIMAL(10,2))";
        makeInjection(query);
    }
    public static void queryForAddAccount(String cardNumber, String pin) throws SQLException{
        String query = "INSERT INTO HyperSkill (CardNumber, Pin, Balance) VALUES " +
                "('" + cardNumber + "', '" + pin + "', 0);";
        makeInjection(query);
    }
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
    public static void queryForPrintBalance(String cardNumber) throws SQLException {
        long balance;
        String query = "SELECT Balance FROM HyperSkill WHERE " + "CardNumber = " + cardNumber + ";";
        balance = returnBalance(query);
        printBalance(String.valueOf(balance));
    }
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
    public static void queryToAddIncome(String cardNumber, long income) throws SQLException {
        String query = "UPDATE HyperSkill " +
                "SET Balance = Balance + " + income +
                " WHERE CardNumber = " + cardNumber + ";";
        makeInjection(query);
    }
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
    public static void makeInjection(String query) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } else {
            System.out.println("Connection is not established.");
        }
    }
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
    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

}