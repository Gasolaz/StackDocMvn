package models;

public class Description {
    long id;
    long topic_id;
    String sub_topic;
    String description;

    public Description(long id, long sub_topic_id, String sub_topic, String description) {
        this.id = id;
        this.topic_id = sub_topic_id;
        this.sub_topic = sub_topic;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public long getSub_topic_id() {
        return topic_id;
    }

    public String getSub_topic() {
        return sub_topic;
    }

    public String getDescription() {
        return description;
    }
}
