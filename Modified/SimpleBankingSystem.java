package Modified;

import java.sql.SQLException;

import static Modified.DAO.Bank.*;
import static Modified.DI.DisplayInterface.printMainMenu;

/**
 * The SimpleBankingSystem class represents a simple banking system program.
 * It allows users to connect to an SQLite database and perform banking operations.
 */
public class SimpleBankingSystem {
    /**
     * The main method of the SimpleBankingSystem program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) throws SQLException {
        String url = "";
        for (String arg : args) {
            if (arg.equals("-fileName")) {
                url = args[1];
                break;
            }
        }
        if (url.isBlank() || url.isEmpty()) {
            url = "Simple_Banking_System.s3db";
        }
        setUrlToBase(url);
        connect();
        queryForCreateTable();
        closeConnection();
        printMainMenu();
    }
}

