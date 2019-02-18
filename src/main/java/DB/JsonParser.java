package DB;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class JsonParser extends DatabaseConnection{

    public static void jsonToDb(String json) {
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("/home/sarunas/Codebaker/StackDocMvn/src/main/Json/" + json +".json"));
            JSONArray jsonArray = (JSONArray) obj;
            for (Object ms : jsonArray) {
                JSONObject element = (JSONObject) ms;
//                long id = (Long) element.get("Id");
//                long docTagId = (Long) element.get("DocTagId");
//                String title = (String) element.get("Title");
//                String creationDate = (String) element.get("CreationDate");
//                long viewCount = (Long) element.get("ViewCount");
//                String LastEditDate = (String) element.get("LastEditDate");
//                long ContributorCount = (Long) element.get("ContributorCount");
//                long ExampleCount = (Long) element.get("ExampleCount");
//                long ExampleScore = (Long) element.get("ExampleScore");
//                String SyntaxHtml = (String) element.get("SyntaxHtml");
//                String ParametersHtml = (String) element.get("ParametersHtml");
//                String RemarksHtml = (String) element.get("RemarksHtml");
//                String IntroductionMarkdown = (String) element.get("IntroductionMarkdown");
//                String SyntaxMarkdown = (String) element.get("SyntaxMarkdown");
//                String ParametersMarkdown = (String) element.get("ParametersMarkdown");
//                String RemarksMarkdown = (String) element.get("RemarksMarkdown");
//                String HelloWorldVersionsHtml = (String) element.get("HelloWorldVersionsHtml");


                try {
                    conn = connect();
                    System.out.println(conn);

//                    Statement stmt = conn.createStatement();
//                    ResultSet rs = stmt.executeQuery("SELECT * FROM Topics");
//                    while(rs.next()){
//                        System.out.println(rs.getArray(1));
//                    }

//                    Statement statement = conn.createStatement();
//                    ResultSet rs = statement.executeQuery("SELECT Title FROM Topics");
//                    while(rs.next()){
//                        System.out.println(rs.getString("Title"));
//                    }

//                    PreparedStatement ps = conn.prepareStatement(INSERT_INTO_DATABASE_TABLE_TOPICS);
//                    ps.setLong(1, id);
//                    ps.setLong(2, docTagId);
//                    ps.setString(3, title);
//                    ps.setString(4, creationDate);
//                    ps.setLong(5, viewCount);
//                    ps.setString(6, LastEditDate);
//                    ps.setLong(7, ContributorCount);
//                    ps.setLong(8, ExampleCount);
//                    ps.setLong(9, ExampleScore);
//                    ps.setString(10, SyntaxHtml);
//                    ps.setString(11, ParametersHtml);
//                    ps.setString(12, RemarksHtml);
//                    ps.setString(13, IntroductionMarkdown);
//                    ps.setString(14, SyntaxMarkdown);
//                    ps.setString(15, ParametersMarkdown);
//                    ps.setString(16, RemarksMarkdown);
//                    ps.setString(17, HelloWorldVersionsHtml);
//                    ps.executeUpdate();

                } catch (SQLException e) {
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
