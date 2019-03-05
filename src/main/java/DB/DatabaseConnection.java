package DB;

import java.sql.*;

import static resources.Cons.URL_DB;

public class DatabaseConnection {
//    public static final String TABLE_TOPICS = "topics";
//    public static final String TABLE_SUB_TOPICS = "sub_topics";
//    public static final String TABLE_DESCRIPTION = "description";
//    public static final String ID = "_id";
//    public static final String TOPICS_TOPIC = "topic";
//    public static final String SUB_TOPICS_SUB_TOPIC = "sub_topic";
//    public static final String DESCRIPTION_TOPIC_ID = "topic_id";
//    public static final String DESCRIPTION_SUB_TOPIC_ID = "sub_topic_id";
//    public static final String DESCRIPTION_DESCRIPTION = "description";



    public static Connection conn;

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        conn = DriverManager.getConnection(URL_DB);
        return conn;
    }
}
