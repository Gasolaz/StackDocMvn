package DB;

import models.Description;
import static resources.Cons.*;
import java.sql.*;

public class DescriptionDAO {
    public static Description descriptionGetter(long number) {
        try (Connection conn = DatabaseConnection.connect()) {
            PreparedStatement ps = conn.prepareStatement(SELECT_SUBTOPICS_BY_ID);
            PreparedStatement ps2 = conn.prepareStatement(SELECT_EXAMPLES_BY_SUBTOPIC_ID);
            ps.setLong(1, number);
            ps2.setLong(1, number);
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
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
