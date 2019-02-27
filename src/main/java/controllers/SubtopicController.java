package controllers;

import DB.DescriptionDAO;
import models.Description;
import models.SearchObject;
import models.SubTopic;
import models.Topic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static DB.DescriptionDAO.descriptionGetter;

@WebServlet("/subtopic")
public class SubtopicController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Description description = descriptionGetter(Long.parseLong(request.getParameter("subtopicid")));
        request.setAttribute("descriptionObject", description);
        request.getRequestDispatcher("subtopic.jsp").forward(request, response);
    }
}
