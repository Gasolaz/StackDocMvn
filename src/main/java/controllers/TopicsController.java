package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

import models.*;

import static DB.DatabaseConnection.*;

@WebServlet("")
public class TopicsController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        try {
//
//            conn = connect();
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM Topics");
//            List<Topic> topics = new ArrayList<Topic>();
////            List<Integer> id = new ArrayList<>();
////            Map<Long, String> topics = new HashMap<Long, String>();
//            while(rs.next()){
//                Topic topic = new Topic(rs.getLong("_id"), rs.getString("topic"));
////                System.out.println(rs.getString("topic"));
//                topics.add(topic);
////                topics.put(rs.getLong("_id"), rs.getString("topic"));
//            }
//            System.out.println("randomasdasdawd");
//
//            request.setAttribute("topics", topics);
//
//        } catch (SQLException e){
//            e.printStackTrace();
//            System.out.println("failed");
//        }
        List<Topic> topics = DB.DatabaseConnection.themes();
        request.setAttribute("topics", topics);

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String topic = request.getParameter("topic");
//        String subTopic = request.getParameter("subTopic");

    }
}

