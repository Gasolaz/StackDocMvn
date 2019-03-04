package models;

import java.sql.*;
import java.util.ResourceBundle;

import static DB.DatabaseConnection.connect;
import static resources.Cons.SELECT_TOPICS_BY_ID;
import static resources.Cons.TOPICS_TOPIC;

public class SubTopic {
    long id;
    String topicId;
    String subTopic;

    public SubTopic(long id, long topicId, String subTopic) {
        this.id = id;
        try (Connection conn = connect()){
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT topic FROM Topics WHERE _id = '" + topicId + "'");
            PreparedStatement ps = conn.prepareStatement(SELECT_TOPICS_BY_ID);
            ps.setLong(1, topicId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                this.topicId = rs.getString(TOPICS_TOPIC);
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        this.subTopic = subTopic;
    }

    public long getId() {
        return id;
    }

    public String getTopicId() {
        return topicId;
    }

    public String getSubTopic() {
        return subTopic;
    }
}
