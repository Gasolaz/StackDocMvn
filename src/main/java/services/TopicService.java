package services;

import models.Topic;
import java.util.List;

import static DB.TopicDAO.themes;

public class TopicService {
    public List<Topic> topics = themes();
}
