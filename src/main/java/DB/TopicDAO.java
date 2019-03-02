package DB;

import models.Topic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static resources.Cons.*;

// implements DAO<Topic>

public class TopicDAO extends DatabaseConnection {

//    private List<Topic> topics = new ArrayList<Topic>();
//    public static final String SELECT_TOPIC = "SELECT topic FROM topics";
//
//    public static final String SELECT_SUB_TOPIC = "SELECT sub_topic FROM sub_topics";
//    public static final String SELECT_DESCRIPTION = "SELECT description FROM description WHERE ";
//
//    public static final String SELECT_FROM_TOPICS_ALL = "SELECT * FROM topics";

    public static List<Topic> themes() {
        List<Topic> topics = new ArrayList<>();
        try (Connection conn = connect()){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery( SELECT_TOPICS_WHERE_TOPIC_COUNT + " DESC ");

            while (rs.next()) {
                long id = (rs.getLong("_id"));
                String str = (rs.getString("topic"));
                Topic topic = new Topic(id, str);
                topics.add(topic);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return topics;
    }

}


// servlet - controlleris javoj, requestas getas, response postas.