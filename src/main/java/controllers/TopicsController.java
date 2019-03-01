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

import services.SubTopicService;
import services.TopicService;

import static DB.SubTopicDAO.searching;


@WebServlet("")
public class TopicsController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TopicService topics = new TopicService();
        request.setAttribute("topics", topics);

        List<SubTopic> subTopics = SubTopicService.subTopicThemes;
        request.setAttribute("subTopics", subTopics);

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TopicService topics = new TopicService();
        request.setAttribute("topics", topics);

        Long topic = Long.parseLong(request.getParameter("topics"));
        long pageNumber = Long.parseLong(request.getParameter("pageNumber"));
        String subTopic = request.getParameter("subtopicsearch");
        SearchObject searchObject = new SearchObject(topic, subTopic, pageNumber);

        request.setAttribute("searchObject", searchObject);
        request.setAttribute("selectedTopic", topic);
        List<SubTopic> filteredSubtopics = SubTopicService.searchingService(topic, subTopic, pageNumber);
        request.setAttribute("filteredSt", filteredSubtopics);

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}

