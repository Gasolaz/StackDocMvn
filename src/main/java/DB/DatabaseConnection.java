package DB;

import java.sql.*;

import static resources.Cons.URL_DB;

public class DatabaseConnection {

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL_DB);
        return conn;
    }
}
