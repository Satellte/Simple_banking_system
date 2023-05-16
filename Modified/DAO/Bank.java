package Modified.DAO;

import java.sql.SQLException;

public class Bank extends AbstractDatabase {
    public Bank(String url, String user, String password) throws SQLException {
        super(url, user, password);
    }

    /**
     * @throws SQLException
     */
    @Override
    public void createTable() throws SQLException {

    }

    /**
     * @param cardNumber
     * @param pin
     * @throws SQLException
     */
    @Override
    public void addAccount(String cardNumber, String pin) throws SQLException {

    }

    /**
     * @param cardNumber
     * @param pin
     * @return
     * @throws SQLException
     */
    @Override
    public boolean checkExistInBase(String cardNumber, String pin) throws SQLException {
        return false;
    }

    /**
     * @param cardNumber
     * @return
     * @throws SQLException
     */
    @Override
    public boolean checkTransferCardExistInBase(String cardNumber) throws SQLException {
        return false;
    }

    /**
     * @param cardNumber
     * @throws SQLException
     */
    @Override
    public void printBalance(String cardNumber) throws SQLException {

    }

    /**
     * @param cardNumber
     * @param amount
     * @return
     * @throws SQLException
     */
    @Override
    public boolean checkBalance(String cardNumber, int amount) throws SQLException {
        return false;
    }

    /**
     * @param cardNumber
     * @throws SQLException
     */
    @Override
    public void addIncome(String cardNumber) throws SQLException {

    }

    /**
     * @param cardNumber
     * @param amount
     * @throws SQLException
     */
    @Override
    public void decreaseBalance(String cardNumber, int amount) throws SQLException {

    }

    /**
     * @param cardNumber
     * @param amount
     * @throws SQLException
     */
    @Override
    public void transferAmount(String cardNumber, int amount) throws SQLException {

    }

    /**
     * @param cardNumber
     * @throws SQLException
     */
    @Override
    public void doTransfer(String cardNumber) throws SQLException {

    }

    /**
     * @param cardNumber
     * @throws SQLException
     */
    @Override
    public void closeAccount(String cardNumber) throws SQLException {

    }
}
