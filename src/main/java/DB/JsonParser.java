package DB;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JsonParser extends DatabaseConnection{

    public static void jsonToDb(String json) {
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("/home/sarunas/Codebaker/JsonaiKurieActuallyReikalingi/topics.json"));
            JSONArray jsonArray = (JSONArray) obj;
            for (Object ms : jsonArray) {
                JSONObject element = (JSONObject) ms;
//                long subtopicId = (Long) element.get("sub_topic_id");
//                String subTopic = (String) element.get("sub_topic");
//                String description = (String) element.get("description");
                long id = (Long) element.get("Id");
                long topicsId = (Long) element.get("DocTagId");
                String sub_topic = (String) element.get("Title");
                String description = (String) element.get("ParametersHtml");
                if(description.equals("")){
                    description = (String) element.get("RemarksHtml");
                    if(description.equals("")){
                        continue;
                    }
                }

                try {
                    Class.forName("org.sqlite.JDBC");
                    conn = connect();

                    PreparedStatement ps = conn.prepareStatement("INSERT INTO subtopics(_id, topic_id, sub_topic, description_HTML) VALUES(?, ?, ?, ?)");
                    ps.setLong(1, id);
                    ps.setLong(2, topicsId);
                    ps.setString(3, sub_topic);
                    ps.setString(4, description);
                    ps.executeUpdate();



                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if(conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
