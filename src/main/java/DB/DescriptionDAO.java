package DB;

import models.Description;

import java.sql.*;

public class DescriptionDAO {
    public static Description descriptionGetter(long number){
        try (Connection conn = DatabaseConnection.connect()){
//            System.out.println(number);
            Statement ps = conn.createStatement();
//            ps.setLong(1, number);
            ResultSet rs = ps.executeQuery("SELECT * FROM descriptions WHERE sub_topic_id='" + number + "'");
            if(rs.next()) {
//                System.out.println("daeita");
                Description description = new Description(rs.getLong("_id"), rs.getLong("sub_topic_id"),
                        rs.getString("sub_topic"), rs.getString("description"));
                return description;
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
