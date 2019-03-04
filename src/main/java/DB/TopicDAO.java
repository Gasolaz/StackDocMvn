package DB;

import models.Topic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TopicDAO extends DatabaseConnection {

    public static List<Topic> themes() {
        List<Topic> topics = new ArrayList<>();
        try (Connection conn = connect()){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM topics ORDER BY topic_count DESC");

            while (rs.next()) {
                long id = (rs.getLong(ID));
                String str = (rs.getString(TOPICS_TOPIC));
                Topic topic = new Topic(id, str);
                topics.add(topic);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return topics;
    }

}
