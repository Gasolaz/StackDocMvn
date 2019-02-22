package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static DB.DatabaseConnection.connect;

public class SubTopic {
    long id;
    String topicId;
    String subTopic;

    public SubTopic(long id, long topicId, String subTopic) {
        this.id = id;
        try (Connection conn = connect()){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT topic FROM Topics WHERE _id = '" + topicId + "'");
            while(rs.next()){
                this.topicId = rs.getString("topic");
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
//        this.topicId = topicId;
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
