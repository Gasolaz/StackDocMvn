package controllers;

import com.google.gson.Gson;
import models.SubTopic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static services.AdminService.deleteSubTopic;


@WebServlet("/admin/delete")
public class DeleteController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        deleteSubTopic(Long.parseLong(request.getParameter("subtopicid")));

        List<SubTopic> filteredSubtopics = SubTopicController.searchingService(0, "", 1);

        String json = new Gson().toJson(filteredSubtopics);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
