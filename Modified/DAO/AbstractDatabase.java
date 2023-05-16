package Modified.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDatabase {

    private Connection connection;

    public AbstractDatabase(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public AbstractDatabase(String url) throws SQLException {
        this.connection = DriverManager.getConnection(url);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void close() throws SQLException {
        if (this.connection != null) {
            this.connection.close();
        }
    }
    public abstract void doSomething() throws SQLException;
}
