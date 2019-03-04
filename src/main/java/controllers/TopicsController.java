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

import com.google.gson.Gson;
import models.*;

import services.SubTopicService;
import services.TopicService;

import static DB.SubTopicDAO.searching;


@WebServlet("")
public class TopicsController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.getRequestDispatcher("test.jsp");

//        response.sendRedirect("index.html");

        request.getRequestDispatcher("build/static/index.html").forward(request, response);

//        request.getRequestDispatcher("index.html").forward(request, response);


//        TopicService topics = new TopicService();
//
//
//        String json = new Gson().toJson(topics);


//
//

//        request.setAttribute("topics", topics);



//        String text = "smth";
//
//
//        for (SubTopic subtopic: subTopics) {
//            out.println(subtopic.getSubTopic() + " " + subtopic.getTopicId());
//        }

//        request.setAttribute("subTopics", subTopics);

//        request.getRequestDispatcher("index.jsp").forward(request, response);

//        response.sendRedirect("index.jsp");

//        request.getRequestDispatcher("test.jsp");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

