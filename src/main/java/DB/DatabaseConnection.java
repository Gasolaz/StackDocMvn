package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static final String TABLE_TOPICS = "topics";
    public static final String TABLE_SUB_TOPICS = "sub_topics";
    public static final String TABLE_DESCRIPTION = "description";
    public static final String ID = "_id";
    public static final String TOPICS_TOPIC = "topic";
    public static final String SUB_TOPICS_SUB_TOPIC = "sub_topic";
    public static final String DESCRIPTION_TOPIC_ID = "topic_id";
    public static final String DESCRIPTION_SUB_TOPIC_ID = "sub_topic_id";
    public static final String DESCRIPTION_DESCRIPTION = "description";

    public static final String INSERT_INTO_TOPICS = "INSERT INTO topics(" + TOPICS_TOPIC + ") VALUES(?)";
    public static final String INSERT_INTO_SUB_TOPICS = "INSERT INTO sub_topics(" + SUB_TOPICS_SUB_TOPIC + ") VALUES(?)";
    public static final String INSERT_INTO_DESCRIPTION = "INSER INTO description(" + DESCRIPTION_TOPIC_ID + ", " +
            DESCRIPTION_SUB_TOPIC_ID + ", " + DESCRIPTION_DESCRIPTION + ") VALUES(?, ?, ?)";

    static Connection conn;
    static String url = "jdbc:sqlite:/home/sarunas/Codebaker/StackDocMvn/src/StackDoc.db";
    static Connection connect() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url);
        return conn;
    }
}
