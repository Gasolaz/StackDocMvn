package models;

public class Topic {
    private long id;
    private String topic;

    public Topic(long id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }
}