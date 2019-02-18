package models;

public class SubTopic {
    int id;
    String sub_topic;

    public SubTopic(int id, String sub_topic) {
        this.id = id;
        this.sub_topic = sub_topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSub_topic() {
        return sub_topic;
    }

    public void setSub_topic(String sub_topic) {
        this.sub_topic = sub_topic;
    }
}
