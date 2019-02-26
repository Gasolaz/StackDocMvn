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

            Object obj = parser.parse(new FileReader("/home/sarunas/Codebaker/StackDocMvn/src/main/Json/subTopicDescription.json"));
            JSONArray jsonArray = (JSONArray) obj;
            for (Object ms : jsonArray) {
                JSONObject element = (JSONObject) ms;
                long subtopicId = (Long) element.get("sub_topic_id");
                String subTopic = (String) element.get("sub_topic");
                String description = (String) element.get("description");

                try {
                    conn = connect();


                    PreparedStatement ps = conn.prepareStatement("INSERT INTO descriptions(sub_topic_id, sub_topic, description) VALUES(?, ?, ?)");
                    ps.setLong(1, subtopicId);
                    ps.setString(2, subTopic);
                    ps.setString(3, description);
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
