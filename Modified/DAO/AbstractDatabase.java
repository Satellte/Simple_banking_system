package Modified.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDatabase {

    private Connection connection;

    public abstract void createTable() throws SQLException;
    public abstract void addAccount(String cardNumber, String pin) throws SQLException;
    public abstract boolean checkExistInBase(String cardNumber, String pin) throws SQLException;
    public abstract boolean checkTransferCardExistInBase(String cardNumber) throws SQLException;
    public abstract void printBalance(String cardNumber) throws SQLException;
    public abstract boolean checkBalance(String cardNumber, int amount) throws SQLException;
    public abstract void addIncome (String cardNumber) throws SQLException;
    public abstract void decreaseBalance (String cardNumber, int amount) throws SQLException;
    public abstract void transferAmount (String cardNumber, int amount) throws SQLException;
    public abstract void doTransfer (String cardNumber) throws SQLException;
    public abstract void closeAccount(String cardNumber) throws SQLException;

    public AbstractDatabase(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void close() throws SQLException {
        if (this.connection != null) {
            this.connection.close();
        }
    }

}
