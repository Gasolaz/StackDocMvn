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
            long id = 0;
            long topic_id = 0;
            String sub_topic = "";
            String description_html = "";
            String body_markdown = "";
            if (rs.next()) {
                id = rs.getLong(ID);
                topic_id = rs.getLong(SUB_TOPICS_TOPIC_ID);
                sub_topic = rs.getString(SUB_TOPICS_SUB_TOPIC);
                description_html = rs.getString(SUB_TOPICS_DESCRIPTION_HTML);
            }
            StringBuilder sb = new StringBuilder();
            while (rs2.next()){
                sb.append(rs2.getString(EXAMPLES_BODY_HTML));
                body_markdown = rs2.getString(EXAMPLES_BODY_MARKDOWN);
            }
            Description description = new Description(id, topic_id, sub_topic, description_html, sb.toString(), body_markdown);
            return description;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
