import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;

public class Main {

    static final String INSERT_INTO_DATABASE_TABLE_TOPICS = "INSERT INTO Topics(_id, DocTagId, Title, CreationDate, ViewCount, " +
            "LastEditDate, ContributorCount, ExampleCount, ExampleScore, " +
            "SyntaxHtml, ParametersHtml, RemarksHtml, IntroductionMarkdown, SyntaxMarkdown, " +
            "ParametersMarkdown, RemarksMarkdown, HelloWorldVersionsHtml) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, " +
            "?, ?, ?, ?, ?, ?, ?, ?)";
    static Connection conn;

    public static Connection connect() throws SQLException {
        Connection conn = null;
        String url = "jdbc:sqlite:/home/sarunas/Codebaker/StackDocMvn/src/StackDoc.db";
        conn = DriverManager.getConnection(url);
        return conn;
    }

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("/home/sarunas/Codebaker/StackDocMvn/src/main/Json/topics.json"));
            JSONArray jsonArray = (JSONArray) obj;
            for(Object ms : jsonArray) {
                JSONObject element = (JSONObject) ms;

                long id = (Long) element.get("Id");
                long docTagId = (Long) element.get("DocTagId");
                String title = (String) element.get("Title");
                String creationDate = (String) element.get("CreationDate");
                long viewCount = (Long) element.get("ViewCount");
                String LastEditDate = (String) element.get("LastEditDate");
                long ContributorCount = (Long) element.get("ContributorCount");
                long ExampleCount = (Long) element.get("ExampleCount");
                long ExampleScore = (Long) element.get("ExampleScore");
                String SyntaxHtml = (String) element.get("SyntaxHtml");
                String ParametersHtml = (String) element.get("ParametersHtml");
                String RemarksHtml = (String) element.get("RemarksHtml");
                String IntroductionMarkdown = (String) element.get("IntroductionMarkdown");
                String SyntaxMarkdown = (String) element.get("SyntaxMarkdown");
                String ParametersMarkdown = (String) element.get("ParametersMarkdown");
                String RemarksMarkdown = (String) element.get("RemarksMarkdown");
                String HelloWorldVersionsHtml = (String) element.get("HelloWorldVersionsHtml");

                try {
                    conn = connect();

                    PreparedStatement ps = conn.prepareStatement(INSERT_INTO_DATABASE_TABLE_TOPICS);
                    ps.setLong(1, id);
                    ps.setLong(2, docTagId);
                    ps.setString(3, title);
                    ps.setString(4, creationDate);
                    ps.setLong(5, viewCount);
                    ps.setString(6, LastEditDate);
                    ps.setLong(7, ContributorCount);
                    ps.setLong(8, ExampleCount);
                    ps.setLong(9, ExampleScore);
                    ps.setString(10, SyntaxHtml);
                    ps.setString(11, ParametersHtml);
                    ps.setString(12, RemarksHtml);
                    ps.setString(13, IntroductionMarkdown);
                    ps.setString(14, SyntaxMarkdown);
                    ps.setString(15, ParametersMarkdown);
                    ps.setString(16, RemarksMarkdown);
                    ps.setString(17, HelloWorldVersionsHtml);
                    ps.executeUpdate();

                } catch (SQLException e){
                    e.printStackTrace();
                } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException e){
                        System.out.println("pzda");
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

//  System.out.println(conn);
//                    if(conn != null){
//                        System.out.println("connected");
//                    }

//                    if(once){
//                        Statement statement = conn.createStatement();
//                        statement.execute("CREATE TABLE Topics (_id INTEGER PRIMARY KEY, DocTagId INTEGER, Name TEXT," +
//                                " CreationDate VARCHAR(255), LastEditDate VARCHAR(255), LastEditUserId INTEGER, ReleaseDate VARCHAR(255))");
//                        once = false;
//                    }


//                    Statement stmt = conn.createStatement();
//                    ResultSet rs = stmt.executeQuery("SELECT * FROM Topics");
//                    while(rs.next()){
//                        System.out.println(rs.getArray(1));
//                    }


