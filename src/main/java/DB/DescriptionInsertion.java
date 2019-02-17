package DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DescriptionInsertion extends DatabaseConnection {
    public static final String INSERT_INTO_DESCRIPTION = "INSERT INTO description(topic_id, sub_topic_id, description) VALUES(?, ?, ?)";
    public static final String INSERT_INTO_TOPICS = "INSERT INTO topics(topic) VALUES(?)";
    public static final String INSERT_INTO_SUB_TOPICS = "INSERT INTO sub_topics(sub_topic) VALUES(?)";

    static void insertIntoDescription(){
        try {
            JsonParser.jsonToDb("someRandomDescriptionJson");
            conn = connect();
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO_DESCRIPTION);
            ps.setLong(1, 1);
            ps.setLong(2, 2);
            ps.setString(3, "description");
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    static void insertIntoTopics() {
        try {
            JsonParser.jsonToDb("topicsJson");
            conn = connect();
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO_TOPICS);
            ps.setString(1, "topicText");
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    static void insertIntoSubTopics() {
        try {
            JsonParser.jsonToDb("subTopicsJson");
            conn = connect();
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO_SUB_TOPICS);
            ps.setString(1, "subTopicText");
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
