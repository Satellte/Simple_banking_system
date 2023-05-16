package Modified.DAO;
import java.sql.SQLException;

public class Bank extends AbstractDatabase {

    public Bank(String url, String user, String password) throws SQLException {
        super(url, user, password);
    }
    public Bank(String url) throws SQLException {
        super(url);
    }

    @Override
    public void doSomething() throws SQLException {
        // выполняем операции с базой данных
        // ...
    }

    // Метод для демонстрации использования MyDatabase
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "myusername";
        String password = "mypassword";

        MyDatabase db = new MyDatabase(url, user, password);
        db.doSomething();
        db.close();
    }
}