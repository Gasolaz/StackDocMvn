package DB;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static DB.DatabaseConnection.connect;
import static resources.Cons.*;

public class TableCreation {

    public static void createTables() throws IOException {

        File file = new File(URL_DB_FILE);

        if (file.createNewFile()) {

            try (Connection conn = connect()) {

                Statement statement = conn.createStatement();

                statement.executeUpdate(CREATE_TABLE_TOPICS);
                statement.executeUpdate(CREATE_TABLE_SUB_TOPICS);
                statement.executeUpdate(CREATE_TABLE_EXAMPLES);

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
