package banking.Utils;
import java.sql.*;
import java.util.Scanner;

import org.sqlite.*;

import static banking.Main.bdName;
import static banking.Utils.Menu.validateCardNumber;

public class SQLConnection {
    static Scanner scanner = new Scanner(System.in);
    public static void createTable() {
        String url = "jdbc:sqlite:/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                "/Simple Banking System (Java)/task/" + bdName;
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);
        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS card (" +
                        "id INTEGER PRIMARY KEY," +
                        "number TEXT NOT NULL," +
                        "pin TEXT NOT NULL," +
                        "balance INTEGER DEFAULT 0);"
                );
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addAccount(String cardNumber, String pin) {
        String url = "jdbc:sqlite:/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                "/Simple Banking System (Java)/task/" + bdName;
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);
        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                    statement.executeUpdate("INSERT INTO card (number, pin, balance) VALUES " +
                            "('" + cardNumber + "', '" + pin + "', 0);");
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean checkExistInBase(String cardNumber, String pin) {
        ResultSet resultSet;
        boolean exist = false;
            String url = "jdbc:sqlite:/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                    "/Simple Banking System (Java)/task/" + bdName;
            SQLiteDataSource dataSource = new SQLiteDataSource();
            dataSource.setUrl(url);

            try (Connection con = dataSource.getConnection()) {
                try (Statement statement = con.createStatement()) {
                    resultSet = statement.executeQuery("SELECT * " +
                            "FROM card " +
                            "WHERE number = " + cardNumber +
                            " and pin = " + pin + ";");
                    if (resultSet.next()) {
                        exist = true;
                    }
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return exist;
        }
    public static boolean checkTransferCardExistInBase(String cardNumber) {
        ResultSet resultSet;
        boolean exist = false;
        String url = "jdbc:sqlite:/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                "/Simple Banking System (Java)/task/" + bdName;
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                resultSet = statement.executeQuery("SELECT * " +
                        "FROM card " +
                        "WHERE number = " + cardNumber + ";");
                if (resultSet.next()) {
                    exist = true;
                }
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }
    public static void printBalance(String cardNumber){
        ResultSet resultSet;
        String url = "jdbc:sqlite:/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                "/Simple Banking System (Java)/task/" + bdName;
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                resultSet = statement.executeQuery("SELECT balance " +
                        "FROM card " +
                        "WHERE number = " + cardNumber + ";");
                if (resultSet.next()) {
                    int balance = resultSet.getInt("balance");
                    System.out.println("\nBalance: " + balance + "\n");
                }
                con.close();
            } catch (SQLException e) {
                System.out.println("Statement is not working!");
            }
        } catch (SQLException e) {
            System.out.println("не выполнено подключение к базе данных");
        }
    }
    public static boolean checkBalance(String cardNumber, int amount){
        boolean exist = false;
        ResultSet resultSet;
        String url = "jdbc:sqlite:/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                "/Simple Banking System (Java)/task/" + bdName;
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                resultSet = statement.executeQuery("SELECT * " +
                        "FROM card " +
                        "WHERE number = " + cardNumber +" AND balance >= " + amount + ";");
                if (resultSet.next()) {
                    exist = true;
                }
                con.close();
            } catch (SQLException e) {
                System.out.println("Statement is not working!");
            }
        } catch (SQLException e) {
            System.out.println("не выполнено подключение к базе данных");
        }
        return exist;
    }
    public static void addIncome (String cardNumber){

        System.out.println("\nEnter income:");
        int addIncome = scanner.nextInt();

        ResultSet resultSet;
        String url = "jdbc:sqlite:/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                "/Simple Banking System (Java)/task/" + bdName;
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                resultSet = statement.executeQuery("SELECT balance " +
                        "FROM card " +
                        "WHERE number = " + cardNumber + ";");
                if (resultSet.next()) {
                    int balance = resultSet.getInt("balance");
                    int totalincome = balance + addIncome;
                    statement.executeUpdate("UPDATE card SET balance = " + totalincome + " WHERE number = "+
                            cardNumber + ";");
                }
                System.out.println("Income was added!\n");
                con.close();
            } catch (SQLException e) {
                System.out.println("Statement is not working!");
            }
        } catch (SQLException e) {
            System.out.println("не выполнено подключение к базе данных");
        }
    }
    public static void decreaseBalance (String cardNumber, int amount){

        ResultSet resultSet;
        String url = "jdbc:sqlite:/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                "/Simple Banking System (Java)/task/" + bdName;
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                resultSet = statement.executeQuery("SELECT balance " +
                        "FROM card " +
                        "WHERE number = " + cardNumber + ";");
                if (resultSet.next()) {
                    int balance = resultSet.getInt("balance");
                    int decreaseAmount = balance - amount;
                    statement.executeUpdate("UPDATE card SET balance = " + decreaseAmount + " WHERE number = "+
                            cardNumber + ";");
                }
                System.out.println("Income was added!\n");
                con.close();
            } catch (SQLException e) {
                System.out.println("Statement is not working!");
            }
        } catch (SQLException e) {
            System.out.println("не выполнено подключение к базе данных");
        }
    }
    public static void transferAmount (String cardNumber, int amount){

        ResultSet resultSet;
        String url = "jdbc:sqlite:/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                "/Simple Banking System (Java)/task/" + bdName;
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                resultSet = statement.executeQuery("SELECT balance " +
                        "FROM card " +
                        "WHERE number = " + cardNumber + ";");
                if (resultSet.next()) {
                    int balance = resultSet.getInt("balance");
                    int totalincome = balance + amount;
                    statement.executeUpdate("UPDATE card SET balance = " + totalincome + " WHERE number = "+
                            cardNumber + ";");
                }
                System.out.println("Income was added!\n");
                con.close();
            } catch (SQLException e) {
                System.out.println("Statement is not working!");
            }
        } catch (SQLException e) {
            System.out.println("не выполнено подключение к базе данных");
        }

    }
    public static void doTransfer (String cardNumber){
        System.out.println("\nTransfer\nEnter card number:");

        String transferToCard = String.valueOf(scanner.nextLong());


        if (transferToCard.length() != 16){
            System.out.println("Probably you made a mistake in the card number. Please try again!\n");
        } else if (!validateCardNumber(transferToCard)){
            System.out.println("Probably you made a mistake in the card number. Please try again!\n");
        } else if (!checkTransferCardExistInBase(transferToCard)){
            System.out.println("Such a card does not exist.\n");
        } else if (transferToCard.equals(cardNumber)){
            System.out.println("Probably you made a mistake in the card number. Please try again!\n");
        } else {
            System.out.println("Enter how much money you want to transfer:");
            int amountToTransfer = scanner.nextInt();
            if (!checkBalance(cardNumber, amountToTransfer)) {
            System.out.println("Not enough money!");
            } else {
                transferAmount(transferToCard, amountToTransfer);
                decreaseBalance(cardNumber, amountToTransfer);
                System.out.println("Success!");
            }
        }
    }
    public static void closeAccount(String cardNumber){
        String url = "jdbc:sqlite:/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                "/Simple Banking System (Java)/task/" + bdName;
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                statement.executeQuery("DELETE FROM card " +
                        "WHERE number = " + cardNumber + ";");
                con.close();
            } catch (SQLException e) {
                System.out.println("Statement is not working!");
            }
        } catch (SQLException e) {
            System.out.println("не выполнено подключение к базе данных");
        }
    }
}