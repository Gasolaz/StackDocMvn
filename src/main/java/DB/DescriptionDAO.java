package DB;

import models.Description;

import java.sql.*;

import static resources.Cons.*;

public class DescriptionDAO {
    public static Description descriptionGetter(long number) {
        try (Connection conn = DatabaseConnection.connect()) {
            Statement ps = conn.createStatement();
            Statement ps2 = conn.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM subtopics WHERE _id='" + number + "'");
            ResultSet rs2 = ps2.executeQuery("SELECT * FROM examples WHERE sub_topic_id='" + number + "'");
            if (rs.next() && rs2.next()) {
                Description description = new Description(rs.getLong(ID), rs.getLong(SUB_TOPICS_TOPIC_ID),
                        rs.getString(SUB_TOPICS_SUB_TOPIC), rs.getString(SUB_TOPICS_DESCRIPTION_HTML), rs2.getString( EXAMPLES_BODY_HTML),
                        rs2.getString(EXAMPLES_BODY_MARKDOWN));
                return description;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
