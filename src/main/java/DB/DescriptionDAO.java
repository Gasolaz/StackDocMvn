package DB;

import models.Description;

import java.sql.*;

public class DescriptionDAO {
    public static Description descriptionGetter(long number) {
        try (Connection conn = DatabaseConnection.connect()) {
//            System.out.println(number);
            Statement ps = conn.createStatement();
            Statement ps2 = conn.createStatement();
//            ps.setLong(1, number);
            ResultSet rs = ps.executeQuery("SELECT * FROM subtopics WHERE _id='" + number + "'");
            ResultSet rs2 = ps2.executeQuery("SELECT * FROM examples WHERE sub_topic_id='" + number + "'");
            if (rs.next() && rs2.next()) {
//                System.out.println("daeita");
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
