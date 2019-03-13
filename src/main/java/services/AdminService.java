package services;

import DB.Encoder;
import com.google.gson.Gson;
import models.Example;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DB.DatabaseConnection.connect;
import static resources.Cons.*;

public class AdminService {

    public static boolean checkIfExists(String pass) {

        try (Connection conn = connect()){
            Encoder enc = new Encoder();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + TABLE_ADMINS); //select admin table
            while (rs.next()){
                byte[] salt = rs.getBytes(ADMINS_SALT); //taking salt from database's row
                String hashedEnteredPass = enc.get_SHA_256_SecurePassword(pass, salt); //hashing entered password
                String hashedPassInDB = rs.getString(ADMINS_PASSWORD); //getting already existing password from the database
                if(hashedEnteredPass.equals(hashedPassInDB)){ //if hashed entered password is equal to already existing password
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException e){
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

    public static void objectToJson(HttpServletResponse response, Object src) throws IOException {
        String json = new Gson().toJson(src);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public static void updateSubTopicDescription(long id, String descriptionHTML) {

        try(Connection conn = connect()){
            PreparedStatement ps = conn.prepareStatement(UPDATE_SUBTOPICS_DESCRIPTION);
            ps.setString(1, descriptionHTML);
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Example> getExamples(long id) {

        List<Example> examplesList = new ArrayList<>();

        try(Connection conn = connect()){
            PreparedStatement ps = conn.prepareStatement(SELECT_EXAMAPLE_BY_SUB_TOPIC_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Example example = new Example(rs.getLong(ID), id, rs.getString(EXAMPLES_BODY_HTML));
                examplesList.add(example);
            }
            return examplesList;

        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return null;
        }
    }
}
