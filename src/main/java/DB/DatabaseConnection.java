package DB;

import java.sql.*;

public class DatabaseConnection {
    public static final String TABLE_TOPICS = "topics";
    public static final String TABLE_SUB_TOPICS = "sub_topics";
    public static final String TABLE_DESCRIPTION = "description";
    public static final String ID = "_id";
    public static final String TOPICS_TOPIC = "topic";
    public static final String TOPICS_TOPIC_COUNT = "topic_count";
    public static final String SUB_TOPICS_SUB_TOPIC = "sub_topic";
    public static final String DESCRIPTION_TOPIC_ID = "topic_id";
    public static final String DESCRIPTION_SUB_TOPIC_ID = "sub_topic_id";
    public static final String DESCRIPTION_DESCRIPTION = "description";

    public static final String INSERT_INTO_TOPICS = "INSERT INTO topics(" + TOPICS_TOPIC + ") VALUES(?)";
    public static final String INSERT_INTO_SUB_TOPICS = "INSERT INTO sub_topics(" + SUB_TOPICS_SUB_TOPIC + ") VALUES(?)";
    public static final String INSERT_INTO_DESCRIPTION = "INSERT INTO " + TABLE_DESCRIPTION + "(" + DESCRIPTION_TOPIC_ID + ", " +
            DESCRIPTION_SUB_TOPIC_ID + ", " + DESCRIPTION_DESCRIPTION + ") VALUES(?, ?, ?)";

    public static Connection conn;
    public static String url = "jdbc:sqlite:../../TempStackDoc.db";

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        conn = DriverManager.getConnection(url);
        return conn;
    }
}
