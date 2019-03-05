package services;

import DB.DatabaseConnection;
import models.Description;

import java.sql.*;

import static resources.Cons.*;

public class DescriptionService {
    public static Description descriptionGetter(long number) {
        try (Connection conn = DatabaseConnection.connect()) {
            PreparedStatement ps = conn.prepareStatement(SELECT_SUBTOPICS_BY_ID);
            ps.setLong(1, number);
            PreparedStatement ps2 = conn.prepareStatement(SELECT_FROM_EXAMPLES_BY_SUBTOPIC_ID);
            ps2.setLong(1, number);
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
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
