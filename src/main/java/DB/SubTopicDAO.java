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
        long pages = 0;
        try (Connection conn = connect()){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM subtopics LIMIT 0, 10");
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
            long rows = 10;
            long limitstart = rows*(pageNumber-1);


            if(topic == 0 && search.equals("")) {
                ResultSet rs = statement.executeQuery("SELECT * FROM subtopics LIMIT " + limitstart + ", " + rows );
                searchingForSt(rs, subTopics);
            } else if (topic == 0) {
                String[] searchArray = search.split(" ");
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < searchArray.length; i++){
                    sb.append("sub_topic LIKE '%");
                    sb.append(searchArray[i]);
                    sb.append("%'");
                    if(i != searchArray.length - 1){
                        sb.append(" OR ");
                    }
                }
                search = sb.toString();
                ResultSet rs = statement.executeQuery("SELECT * FROM subtopics WHERE " + search + " LIMIT " + limitstart + ", " + rows);
                searchingForSt(rs, subTopics);
            } else if (search.equals("")){
                ResultSet rs = statement.executeQuery("SELECT * FROM subtopics WHERE topic_id='" + topic + "' LIMIT " + limitstart + ", " + rows);
                searchingForSt(rs, subTopics);
            } else {
                String[] searchArray = search.split(" ");
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                for(int i = 0; i < searchArray.length; i++){
                    sb.append("sub_topic LIKE '%");
                    sb.append(searchArray[i]);
                    sb.append("%'");
                    if(i != searchArray.length - 1){
                        sb.append(" OR ");
                    }
                }
                sb.append(")");
                search = sb.toString();
                System.out.println(search);
                ResultSet rs = statement.executeQuery("SELECT * FROM subtopics WHERE topic_id='" + topic + "' AND " + search + " LIMIT " + limitstart +
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
