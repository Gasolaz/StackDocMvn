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

import static resources.Cons.INSERT_INTO_EXAMPLE_EXAMPLE;

public class JsonParser extends DatabaseConnection{

    public static void jsonToDb(String json) {
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("/home/sarunas/Codebaker/JsonaiKurieActuallyReikalingi/examples.json"));
            JSONArray jsonArray = (JSONArray) obj;
//            int index = 0;
            for (Object ms : jsonArray) {
                JSONObject element = (JSONObject) ms;
                //These tags are not linked to Cons
                long id = (Long) element.get("Id");
                long sub_topic_id = (Long) element.get("DocTopicId");
                String title = (String) element.get("Title");
                String body_html = (String) element.get("BodyHtml");
                String body_markdown = (String) element.get("BodyMarkdown");
//                long subtopicId = (Long) element.get("sub_topic_id");
//                String subTopic = (String) element.get("sub_topic");
//                String description = (String) element.get("description");
//                long id = (Long) element.get("Id");
//                long topicsId = (Long) element.get("DocTagId");
//                String sub_topic = (String) element.get("Title");
//                String description = (String) element.get("ParametersHtml");
//                if(description.equals("")){
//                    description = (String) element.get("RemarksHtml");
//                    if(description.equals("")){
//                        continue;
//                    }
//                }

                try {
                    conn = connect();
                    PreparedStatement ps = conn.prepareStatement(INSERT_INTO_EXAMPLE_EXAMPLE);
                    ps.setLong(1, id);
                    ps.setLong(2, sub_topic_id);
                    ps.setString(3, title);
                    ps.setString(4, body_html);
                    ps.setString(5, body_markdown);
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
