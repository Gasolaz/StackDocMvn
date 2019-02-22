package DB;

import java.sql.SQLException;
import java.sql.Statement;

public class TableCreations extends DatabaseConnection {
    static void tableCreation(){
        try {
            conn = connect();
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_TOPICS + "(" + ID + " INTEGER PRIMARY KEY, " + TOPICS_TOPIC + " TEXT NOT NULL)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_SUB_TOPICS + "(" + ID + " INTEGER PRIMARY KEY, " + SUB_TOPICS_SUB_TOPIC + " TEXT NOT NULL)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_DESCRIPTION + "(" + ID + " INTEGER PRIMARY KEY, topic_id INTEGER NOT NULL, " +
                    "sub_topic_id INTEGER NOT NULL, header TEXT NOT NULL, description TEXT NOT NULL)");
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
