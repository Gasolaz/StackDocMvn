package models;

public class Description {
    private long id;
    private long topic_id;
    private String sub_topic;
    private String description;
    private String body_HTML;
    private String body_markdown;

    public Description(long id, long sub_topic_id, String sub_topic, String description, String body_HTML, String body_markdown) {
        this.id = id;
        this.topic_id = sub_topic_id;
        this.sub_topic = sub_topic;
        this.description = description;
        this.body_HTML = body_HTML;
        this.body_markdown = body_markdown;
    }
}
