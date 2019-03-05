package controllers;

import com.google.gson.Gson;
import models.SearchObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/api/search")
public class SearchObjectController extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect(request.getContextPath());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Long topic = Long.parseLong(request.getParameter("topics"));
        long pageNumber = Long.parseLong(request.getParameter("pageNumber"));
        String subTopic = request.getParameter("subtopicsearch");

        SearchObject searchObject = new SearchObject(topic, subTopic, pageNumber);

        String json = new Gson().toJson(searchObject);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
