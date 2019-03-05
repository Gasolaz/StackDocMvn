package services;

import DB.DatabaseConnection;
import models.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static resources.Cons.*;

public class TopicService extends DatabaseConnection {

    public static List<Topic> themes() {
        List<Topic> topics = new ArrayList<>();
        try (Connection conn = connect()){
            PreparedStatement ps = conn.prepareStatement(SELECT_TOPICS_BY_COUNT);
            ResultSet rs = ps.executeQuery();
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
