package DB;

import models.SubTopic;
import models.Topic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static DB.DatabaseConnection.connect;

public class SubTopicDAO {
    public static List<SubTopic> subTopicThemes() {
        List<SubTopic> subTopics = new ArrayList<>();
        try (Connection conn = connect()){
            Statement statement = conn.createStatement();
//            int limitstart = 0+(5*(pagenr-1))
//            int limitend = 5+(5*(pagenr-1))
            ResultSet rs = statement.executeQuery("SELECT * FROM subtopics LIMIT 0, 5");
            searchingForSt(rs, subTopics);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return subTopics;
    }

    public static List<SubTopic> searching(long topic, String search, long pageNumber) {

        List<SubTopic> subTopics = new ArrayList<>();
        try (Connection conn = connect()){
            Statement statement = conn.createStatement();
            long limitstart = 5*(pageNumber-1);
//            System.out.println(limitstart);
            long rows = 5;
//            System.out.println(limitend);

            if(topic == 0 && search.equals("")) {
                ResultSet rs = statement.executeQuery("SELECT * FROM subtopics LIMIT " + limitstart + ", " + rows );
                searchingForSt(rs, subTopics);
            } else if (topic == 0) {
                ResultSet rs = statement.executeQuery("SELECT * FROM subtopics WHERE sub_topic LIKE '%" + search + "%' LIMIT " + limitstart + ", " + rows);
                searchingForSt(rs, subTopics);
            } else if (search.equals("")){
                ResultSet rs = statement.executeQuery("SELECT * FROM subtopics WHERE topic_id='" + topic + "' LIMIT " + limitstart + ", " + rows);
                searchingForSt(rs, subTopics);
            } else {
                ResultSet rs = statement.executeQuery("SELECT * FROM subtopics WHERE topic_id='" + topic + "' AND sub_topic LIKE '%" + search + "%' LIMIT " + limitstart +
                        ", " + rows);
                searchingForSt(rs, subTopics);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return subTopics;
    }

    public static void searchingForSt(ResultSet rs, List<SubTopic> st) throws SQLException{

        while(rs.next()){
            long id = rs.getLong("_id");
            long topicOfId = rs.getLong("topic_id");
            String str = rs.getString("sub_topic");
            SubTopic subTopic = new SubTopic(id, topicOfId, str);
            st.add(subTopic);
        }
    }
}
