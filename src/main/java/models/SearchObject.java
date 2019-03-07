package models;

import java.sql.*;

import static DB.DatabaseConnection.connect;
import static resources.Cons.*;


public class SearchObject {
    private long topicId;
    private String search;
    private long pages;
    private long pageNumber;

    public SearchObject(long topicId, String search, long pageNumber) {
        this.topicId = topicId;
        this.search = search;
        this.pageNumber = pageNumber;
        try (Connection conn = connect()){
            StringBuilder sb = new StringBuilder();
            sb.append(SELECT_COUNT_FROM_SUBTOPICS_START);
            int index = 1;
            String[] array = search.trim().split(" ");
            if(topicId > 0){
                sb.append(" WHERE " + SUB_TOPICS_TOPIC_ID + "=?");
            }
            if(!search.equals("")) {
                sb.append(topicId > 0 ? " AND (" : " WHERE (");
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
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            if(topicId > 0){
                ps.setLong(index++, topicId);
            }
            if(!search.trim().equals("")) {
                for (String element : array) {
                    ps.setString(index++, element);
                }
            }
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                long result = rs.getLong("count(*)");
                pages = result / ROWS;
                if (result % ROWS > 0) {
                    pages++;
                }
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
