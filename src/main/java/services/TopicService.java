package services;

import models.Topic;
import java.util.List;

import static DB.TopicDAO.themes;

public class TopicService implements ITopicService {

    public List<Topic> topics;

    public TopicService() {
        this.topics = themes();
    }

    public List<Topic> getTopics() {
        return topics;
    }
}
