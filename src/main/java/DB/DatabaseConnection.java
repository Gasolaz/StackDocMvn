package DB;

import models.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static Connection conn;
    public static String url = "jdbc:sqlite:/home/sarunas/Codebaker/StackDocMvn/TempStackDoc.db";

    public static void main(String[] args) {
        System.out.println(themes());
    }

    public static List<Topic> themes() {
        List<Topic> topics = new ArrayList<>();
        try {
            conn = connect();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Topics");

            while (rs.next()) {
                long id = (rs.getLong("_id"));
                String str = (rs.getString("topic"));
                Topic topic = new Topic(id, str);
                topics.add(topic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topics;
    }

    public static Connection connect() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url);
        return conn;
    }
}
