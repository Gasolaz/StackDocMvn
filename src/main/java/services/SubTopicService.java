package services;

import DB.SubTopicDAO;
import models.SubTopic;
import models.Topic;
import java.util.List;

import static DB.SubTopicDAO.searching;
import static DB.TopicDAO.themes;

public class SubTopicService {
    public static List<SubTopic> subTopicThemes = SubTopicDAO.subTopicThemes();
    public static List<SubTopic> searchingService(long a, String b, long c){
        return searching(a, b, c);
    }
}
