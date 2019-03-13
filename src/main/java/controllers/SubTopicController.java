package controllers;

import services.SubTopicService;
import com.google.gson.Gson;
import models.Description;
import models.SubTopic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static services.AdminService.objectToJson;
import static services.DescriptionService.descriptionGetter;
import static services.SubTopicService.searching;

@WebServlet("/api/subtopics")
public class SubTopicController extends HttpServlet {
    private static List<SubTopic> subTopicThemes = SubTopicService.subTopicThemes();

    static List<SubTopic> searchingService(long a, String b, long c) {
        return searching(a, b, c);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        objectToJson(response, subTopicThemes);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Description description = descriptionGetter(Long.parseLong(request.getParameter("subtopicid")));
        objectToJson(response, description);
    }
}
