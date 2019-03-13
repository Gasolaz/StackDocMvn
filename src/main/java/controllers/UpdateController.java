package controllers;

import DB.JsonParser;
import com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.model.core.ID;
import models.Example;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static DB.DatabaseConnection.connect;
import static resources.Cons.*;
import static services.AdminService.updateSubTopicDescription;

@WebServlet("/admin/update")
public class UpdateController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("examplesList"));
        JSONParser parser = new JSONParser();
        List<Example> exampleList = new ArrayList<>();
        try (Connection conn = connect()){
            Object obj = parser.parse(request.getParameter("examplesList"));
            JSONArray jsonArray = (JSONArray) obj;
            for (Object ms : jsonArray) {
                JSONObject element = (JSONObject) ms;

                long id = (Long) element.get("id");
                String body_html = (String) element.get("body_html");

                Example example = new Example(id, Long.parseLong(request.getParameter("subtopicid")), body_html);
                exampleList.add(example);
            }

            for(Example example : exampleList) {
                Statement statement = conn.createStatement();
                if(example.getBody_html().equals("")){
                    statement.executeUpdate("DELETE FROM " + TABLE_EXAMPLES + " WHERE " + ID + "='" + example.getId() + "'");
                } else {
                    statement.executeUpdate("UPDATE " + TABLE_EXAMPLES + " SET " + EXAMPLES_BODY_HTML + "='" + example.getBody_html() + "' WHERE " + ID + "='" + example.getId() + "'");
                }
            }

        } catch (SQLException | ClassNotFoundException | ParseException e) {
            e.printStackTrace();
        }
        updateSubTopicDescription(Long.parseLong(request.getParameter("subtopicid")), request.getParameter("descriptionHTML"));
        response.sendRedirect(request.getContextPath());
    }

}
