package services;

import com.google.gson.Gson;
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import models.SearchObject;
import models.SubTopic;
import models.Topic;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static DB.TopicDAO.themes;

@WebServlet("/api/topics")
public class TopicService extends HttpServlet implements ITopicService {


    public List<Topic> topics;

    public TopicService() {
        this.topics = themes();
    }

    public List<Topic> getTopics() {
        return topics;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String json = new Gson().toJson(topics);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(json);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


//        TopicService topics = new TopicService();
//        request.setAttribute("topics", topics);

        Long topic = Long.parseLong(request.getParameter("topics"));
        long pageNumber = Long.parseLong(request.getParameter("pageNumber"));
        String subTopic = request.getParameter("subtopicsearch");
        SearchObject searchObject = new SearchObject(topic, subTopic, pageNumber);

//        request.setAttribute("searchObject", searchObject);
//        request.setAttribute("selectedTopic", topic);

//        List<SubTopic> filteredSubtopics = searching(topic, subTopic, pageNumber);
        List<SubTopic> filteredSubtopics = SubTopicService.searchingService(topic, subTopic, pageNumber);
//        request.setAttribute("filteredSt", filteredSubtopics);


        String json = new Gson().toJson(filteredSubtopics);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(json);

//        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
