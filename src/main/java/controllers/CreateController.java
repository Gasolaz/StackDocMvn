package controllers;

import models.SubTopic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static services.AdminService.*;

@WebServlet("/admin/create")
public class CreateController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        insertSubTopic(Long.parseLong(request.getParameter("topics")), request.getParameter("subtopicname"),
                request.getParameter("descriptionHTML"));
        List<SubTopic> filteredSubtopics = SubTopicController.searchingService(0, "", 1);
        objectToJson(response, filteredSubtopics);
    }

}
