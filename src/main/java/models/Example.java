package models;

public class Example {

    private long id;
    private long sub_topic_id;
    private String body_html;

    public Example(long id, long sub_topic_id, String body_html) {
        this.id = id;
        this.sub_topic_id = sub_topic_id;
        this.body_html = body_html;
    }
}
