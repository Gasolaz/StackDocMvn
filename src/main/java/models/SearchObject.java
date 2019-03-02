package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            Statement statement = conn.createStatement();
            if(topicId == 0 && search.equals("")) {
                ResultSet rs = statement.executeQuery("SELECT count(*) FROM subtopics");
                if (rs.next()) {
                    long result = rs.getLong("count(*)");
                    pages = result / ROWS;
                    if (result % ROWS > 0) {
                        pages++;
                    }
                }
            } else if (search.equals("")){
                ResultSet rs = statement.executeQuery("SELECT count(*) FROM subtopics WHERE topic_id='" + topicId + "'");
                if (rs.next()) {
                    long result = rs.getLong("count(*)");
                    pages = result / ROWS;
                    if (result % ROWS > 0) {
                        pages++;
                    }
                }
            } else if (topicId == 0){
                ResultSet rs = statement.executeQuery("SELECT count(*) FROM subtopics WHERE sub_topic LIKE '%" + search + "%'");
                if (rs.next()) {
                    long result = rs.getLong("count(*)");
                    pages = result / ROWS;
                    if (result % ROWS > 0) {
                        pages++;
                    }
                }
            } else {
                ResultSet rs = statement.executeQuery("SELECT count(*) FROM subtopics WHERE sub_topic LIKE '%" + search + "%' AND topic_id='" + topicId + "'");
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
