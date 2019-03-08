package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static services.AdminService.updateSubTopicDescription;


@WebServlet("/admin/update")
public class UpdateController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        updateSubTopicDescription(Long.parseLong(request.getParameter("topicid")), request.getParameter("desctiptionHTML"));
//        List<Topic> filteredTopics = TopicController.sear/TopicController
//        objectToJson(response, filteredSubtopics);
        response.sendRedirect(request.getContextPath());
    }

}
