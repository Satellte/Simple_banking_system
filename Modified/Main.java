package Modified;

import java.sql.SQLException;
import static Modified.DAO.Bank.*;
import static Modified.DI.DisplayInterface.printMainMenu;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                "/Simple Banking System (Java)/task/" + args[1];
        setUrlToBase(url);
        connect();
        queryForCreateTable();
        closeConnection();
        printMainMenu();
    }
}

