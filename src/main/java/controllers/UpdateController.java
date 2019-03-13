package controllers;

import models.Topic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static services.AdminService.updateSubTopicDescription;


@WebServlet("/admin/update")
public class UpdateController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("subtopicid"));
        System.out.println(request.getParameter("descriptionHTML"));
        System.out.println(request.getParameter("subtopic_name"));
        System.out.println(request.getParameter("body_html"));
        updateSubTopicDescription(Long.parseLong(request.getParameter("subtopicid")), request.getParameter("descriptionHTML"));
        response.sendRedirect(request.getContextPath());
    }

}
