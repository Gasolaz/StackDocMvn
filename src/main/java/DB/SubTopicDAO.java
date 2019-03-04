package DB;

import models.SubTopic;
import models.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.connect;
import static resources.Cons.*;

public class SubTopicDAO {

    public static final String SELECT_FROM_SUBTOPICS_START = "SELECT * FROM " + TABLE_SUB_TOPICS;
    public static List<SubTopic> subTopicThemes() {
        List<SubTopic> subTopics = new ArrayList<>();
        try (Connection conn = connect()){
            StringBuilder sb = new StringBuilder();
            sb.append(SELECT_FROM_SUBTOPICS_START + " LIMIT ?, ?");
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ps.setLong(1, 0);
            ps.setLong(2, ROWS);
            ResultSet rs = ps.executeQuery();
            searchingForSt(rs, subTopics);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return subTopics;
    }

    public static List<SubTopic> searching(long topic, String search, long pageNumber) {

        List<SubTopic> subTopics = new ArrayList<>();
        try (Connection conn = connect()){

            long limitStart = ROWS*(pageNumber-1);
            StringBuilder sb = new StringBuilder();

//            if(topic == 0 && search.trim().equals("")) {
//                PreparedStatement ps = conn.prepareStatement(buildingSearchStatement(sb, topic, search));
//                ps.setLong(1, limitStart);
//                ps.setLong(2, ROWS);
//                ResultSet rs = ps.executeQuery();
//                searchingForSt(rs, subTopics);
//            } else if (topic == 0) {
//                PreparedStatement ps = conn.prepareStatement(buildingSearchStatement(sb, topic, search));
//                ps.setLong(1, limitStart);
//                ps.setLong(2, ROWS);
//                ResultSet rs = ps.executeQuery();
//                searchingForSt(rs, subTopics);
//            } else if (search.trim().equals("")){
//                String customSQL = buildingSearchStatement(sb, topic, search);
//                ResultSet rs = statement.executeQuery("SELECT * FROM subtopics WHERE topic_id='" + topic + "' LIMIT " + limitStart + ", " + ROWS);
//                searchingForSt(rs, subTopics);
//            } else {
//                search = makeSearchIntoArray(search);
//                ResultSet rs = statement.executeQuery("SELECT * FROM subtopics WHERE topic_id='" + topic + "' AND " + search + " LIMIT " + limitStart +
//                        ", " + ROWS);
//                searchingForSt(rs, subTopics);
//            }

//            int arraySize = search.trim().split("").length;
//            if(search.trim().equals("") && topic == 0){
//            } else if (topic == 0) {
//                sb.append(search);
//                sb.append(" LIMIT ?, ?");
//            } else if (search.trim().equals("")){
//                sb.append(" WHERE " + SUB_TOPICS_TOPIC_ID + "=?");
//            } else {
//                search = makeSearchIntoArray(search);
//                sb.append(" WHERE " + SUB_TOPICS_TOPIC_ID + "=? AND " + search);
//            }
            sb.append(SELECT_FROM_SUBTOPICS_START);
            int index = 1;
            String[] array = search.trim().split(" ");
            for(String test :array){
                System.out.println(test);
            }
            System.out.println(array.length);
            if(topic > 0){
                sb.append(" WHERE " + SUB_TOPICS_TOPIC_ID + "=?");
            }

            if(!search.equals("")) {

                if (array.length > 0 && topic > 0) {
                    sb.append(" AND (");
                } else if (array.length > 0) {
                    sb.append(" WHERE (");
                }
                for (int i = 0; i < array.length; i++) {
                    sb.append(SUB_TOPICS_SUB_TOPIC + " LIKE '%'||?||'%'");
                    if (i != array.length -1) {
                        sb.append(" OR ");
                    }
                }
                if (array.length > 0) {
                    sb.append(")");
                }
            }
            sb.append(" LIMIT ?, ?");
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            System.out.println(sb.toString());
            if(topic > 0){
                ps.setLong(index++, topic);
            }
            if(!search.equals("")) {
                for (int i = 0; i < array.length; i++) {
                    ps.setString(index++, array[i]);
                }
            }
            ps.setLong(index++, limitStart);
            ps.setLong(index, ROWS);
            ResultSet rs = ps.executeQuery();
            searchingForSt(rs, subTopics);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return subTopics;
    }

    public static void searchingForSt(ResultSet rs, List<SubTopic> st) throws SQLException{

        while(rs.next()){
            long id = rs.getLong(ID);
            long topicOfId = rs.getLong(SUB_TOPICS_TOPIC_ID);
            String str = rs.getString(SUB_TOPICS_SUB_TOPIC);
            SubTopic subTopic = new SubTopic(id, topicOfId, str);
            st.add(subTopic);
        }
    }

    static String makeSearchIntoArray(String search){
        String[] searchArray = search.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
//        for(int i = 0; i < searchArray.length; i++){
//            sb.append(SUB_TOPICS_SUB_TOPIC + " LIKE '%");
//            sb.append(searchArray[i]);
//            sb.append("%'");
//            if(i != searchArray.length - 1){
//                sb.append(" OR ");
//            }
//        }
        sb.append(")");
        return sb.toString();
    }
}
