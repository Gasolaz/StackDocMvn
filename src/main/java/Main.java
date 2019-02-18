import models.Topic;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.DatabaseConnection.connect;
import static DB.DatabaseConnection.conn;


public class Main {

    static final String INSERT_INTO_DATABASE_TABLE_TOPICS = "INSERT INTO Topics(_id, DocTagId, Title, CreationDate, ViewCount, " +
            "LastEditDate, ContributorCount, ExampleCount, ExampleScore, " +
            "SyntaxHtml, ParametersHtml, RemarksHtml, IntroductionMarkdown, SyntaxMarkdown, " +
            "ParametersMarkdown, RemarksMarkdown, HelloWorldVersionsHtml) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, " +
            "?, ?, ?, ?, ?, ?, ?, ?)";

    public static void main(String[] args) {


//        List<String> strings = new ArrayList<String>();
//        String smth = "*";
//        for (int i = 0; i < 4; i++) {
//            strings.add(smth);
//            smth += smth;
//        }
//        System.out.println(strings);
    }



}



