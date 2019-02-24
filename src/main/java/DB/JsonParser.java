package DB;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JsonParser extends DatabaseConnection{

    public static void jsonToDb(String json) {
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("/home/sarunas/Codebaker/StackDocMvn/src/main/Json/subTopicNoQuotes.json"));
            JSONArray jsonArray = (JSONArray) obj;
            for (Object ms : jsonArray) {
                JSONObject element = (JSONObject) ms;
                long topicId = (Long) element.get("topic_id");
                String subTopic = (String) element.get("sub_topic");


                try {
                    conn = connect();

                    PreparedStatement ps = conn.prepareStatement("INSERT INTO subtopics(topic_id, sub_topic) VALUES(?, ?)");
                    ps.setLong(1, topicId);
                    ps.setString(2, subTopic);
                    ps.executeUpdate();

                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
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
