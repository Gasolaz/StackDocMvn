package models;

public class SearchObject {
    long topicId;
    String search;

    public SearchObject(long topicId, String search) {
        this.topicId = topicId;
        this.search = search;
    }

    public long getTopicId() {
        return topicId;
    }

    public String getSearch() {
        return search;
    }
}
