package models;

import java.sql.*;

import static DB.DatabaseConnection.connect;
import static resources.Cons.SELECT_TOPICS_BY_ID;
import static resources.Cons.TOPICS_TOPIC;

public class SubTopic {
    private long id;
    private String topicId;
    private String subTopic;

    public SubTopic(long id, long topicId, String subTopic) {
        this.id = id;
        try (Connection conn = connect()){
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
}
