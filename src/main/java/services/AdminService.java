package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.DatabaseConnection.connect;
import static resources.Cons.*;

public class AdminService {

    public static boolean checkIfExists(String pass) {

        try(Connection conn = connect()){
            PreparedStatement ps = conn.prepareStatement(SELECT_ADMIN_BY_PASSWORD);
            ps.setString(1, pass);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void deleteSubTopic(long id) {

        try(Connection conn = connect()){
            PreparedStatement ps = conn.prepareStatement(DELETE_SUB_TOPIC_FROM_SUB_TOPICS);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insertSubTopic(long topicId, String subTopic, String description) {

        try(Connection conn = connect()) {
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO_SUB_TOPICS);
            ps.setLong(1, topicId);
            ps.setString(2, subTopic);
            ps.setString(3, description);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
