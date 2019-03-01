package DB;

import models.Description;

import java.sql.*;

public class DescriptionDAO {
    public static Description descriptionGetter(long number) {
        try (Connection conn = DatabaseConnection.connect()) {
            Statement ps = conn.createStatement();
            Statement ps2 = conn.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM subtopics WHERE _id='" + number + "'");
            ResultSet rs2 = ps2.executeQuery("SELECT * FROM examples WHERE sub_topic_id='" + number + "'");
            if (rs.next() && rs2.next()) {
                Description description = new Description(rs.getLong("_id"), rs.getLong("topic_id"),
                        rs.getString("sub_topic"), rs.getString("description_HTML"), rs2.getString("body_HTML"),
                        rs2.getString("body_markdown"));
                return description;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
