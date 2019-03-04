package models;

import com.sun.org.apache.regexp.internal.RE;
import sun.misc.REException;

import java.sql.*;

import static DB.DatabaseConnection.connect;
import static resources.Cons.ROWS;


public class SearchObject {
    long topicId;
    String search;
    long pages;
    // private final int ROWS = 10;
    long pageNumber;

    public SearchObject(long topicId, String search, long pageNumber) {
        this.topicId = topicId;
        this.search = search;
        this.pageNumber = pageNumber;
        try (Connection conn = connect()){
//            Statement statement = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("SELECT count(*) FROM subtopics");
            PreparedStatement ps2 = conn.prepareStatement("SELECT count(*) FROM subtopics WHERE topic_id='" + topicId + "'");
            PreparedStatement ps3 = conn.prepareStatement("SELECT count(*) FROM subtopics WHERE sub_topic LIKE '%" + search + "%'");
            PreparedStatement ps4 = conn.prepareStatement("SELECT count(*) FROM subtopics WHERE sub_topic LIKE '%" + search + "%' AND topic_id='" + topicId + "'");
            ps.setString(1, search);
            ps2.setLong(1, topicId);
            ps3.setString(1, search);
            ps4.setString(1, search);
            ps4.setLong(2, topicId);

            if(topicId == 0 && search.equals("")) {
//                ResultSet rs = statement.executeQuery("SELECT count(*) FROM subtopics");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    long result = rs.getLong("count(*)");
                    pages = result / ROWS;
                    if (result % ROWS > 0) {
                        pages++;
                    }
                }
            } else if (search.equals("")){
//                ResultSet rs = statement.executeQuery("SELECT count(*) FROM subtopics WHERE topic_id='" + topicId + "'");
                ResultSet rs = ps2.executeQuery();
                if (rs.next()) {
                    long result = rs.getLong("count(*)");
                    pages = result / ROWS;
                    if (result % ROWS > 0) {
                        pages++;
                    }
                }
            } else if (topicId == 0){
//                ResultSet rs = statement.executeQuery("SELECT count(*) FROM subtopics WHERE sub_topic LIKE '%" + search + "%'");
                ResultSet rs = ps3.executeQuery();
                if (rs.next()) {
                    long result = rs.getLong("count(*)");
                    pages = result / ROWS;
                    if (result % ROWS > 0) {
                        pages++;
                    }
                }
            } else {
//                ResultSet rs = statement.executeQuery("SELECT count(*) FROM subtopics WHERE sub_topic LIKE '%" + search + "%' AND topic_id='" + topicId + "'");
                ResultSet rs = ps4.executeQuery();
                if (rs.next()) {
                    long result = rs.getLong("count(*)");
                    pages = result / ROWS;
                    if (result % ROWS > 0) {
                        pages++;
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public long getTopicId() {
        return topicId;
    }

    public String getSearch() {
        return search;
    }

    public long getPages() {
        return pages;
    }
}
