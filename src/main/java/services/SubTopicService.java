package services;

import DB.SubTopicDAO;
import com.google.gson.Gson;
import models.Description;
import models.SubTopic;
import models.Topic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static DB.DescriptionDAO.descriptionGetter;
import static DB.SubTopicDAO.searching;
import static DB.TopicDAO.themes;

@WebServlet("/api/subtopics")
public class SubTopicService extends HttpServlet {
    public static List<SubTopic> subTopicThemes = SubTopicDAO.subTopicThemes();

    public static List<SubTopic> searchingService(long a, String b, long c) {
        return searching(a, b, c);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String json = new Gson().toJson(subTopicThemes);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(json);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Description description = descriptionGetter(Long.parseLong(request.getParameter("subtopicid")));

        String json = new Gson().toJson(description);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(json);
    }
}
