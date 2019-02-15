package models;

public class Description {
    int id;
    int topic_id;
    int sub_topic_id;

    public Description(int id, int topic_id, int sub_topic_id) {
        this.id = id;
        this.topic_id = topic_id;
        this.sub_topic_id = sub_topic_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public int getSub_topic_id() {
        return sub_topic_id;
    }

    public void setSub_topic_id(int sub_topic_id) {
        this.sub_topic_id = sub_topic_id;
    }
}
