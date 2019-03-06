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

// Class used to parse data into DB
public class JsonParser extends DatabaseConnection{
    public static void jsonToDb() {
        JSONParser parser = new JSONParser();
        try (Connection conn = connect()) {

            Object obj = parser.parse(new FileReader("Path/to/json.json"));
            JSONArray jsonArray = (JSONArray) obj;
            for (Object ms : jsonArray) {
                JSONObject element = (JSONObject) ms;

                // These tags are not linked to Cons

                long id = (Long) element.get("Id");
                long sub_topic_id = (Long) element.get("DocTopicId");
                String title = (String) element.get("Title");
                String body_html = (String) element.get("BodyHtml");
                String body_markdown = (String) element.get("BodyMarkdown");

                PreparedStatement ps = conn.prepareStatement(INSERT_INTO_EXAMPLE_EXAMPLE);
                ps.setLong(1, id);
                ps.setLong(2, sub_topic_id);
                ps.setString(3, title);
                ps.setString(4, body_html);
                ps.setString(5, body_markdown);
                ps.executeUpdate();

            }
        } catch (SQLException | ClassNotFoundException
                | ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
