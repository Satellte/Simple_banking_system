package banking;

import static banking.Utils.Menu.printMainMenu;
import static banking.Utils.SQLConnection.createTable;

public class Main {
    public static String bdName;
    public static void main(String[] args) {
        bdName = args[1];
        createTable();
        printMainMenu();
    }
}