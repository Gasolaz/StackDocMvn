package resources;

public class Cons {

    // All Tables ID
    public static final String ID = "_id";

//    Table Topics
    public static final String TABLE_TOPICS = "topics";
    // Table Topics -> Columns
    public static final String TOPICS_TOPIC = "topic";
    public static final String TOPICS_TOPIC_COUNT = "topic_count";

//    Table Subtopics
    public static final String TABLE_SUB_TOPICS = "sub_topics";
    // Table Subtopics  -> Columns
    public static final String SUB_TOPICS_TOPIC_ID = "topic_id";
    public static final String SUB_TOPICS_SUB_TOPIC = "sub_topic";
    public static final String SUB_TOPICS_DESCRIPTION_HTML = "description_HTML";

//        Table Examples
    public static final String TABLE_EXAMPLES = "examples";
    // Table Examples  -> Columns
    public static final String EXAMPLES_SUB_TOPIC = "sub_topic_id";
    public static final String EXAMPLES_TITLE = "title";
    public static final String EXAMPLES_BODY_HTML = "body_HTML";
    public static final String EXAMPLES_BODY_MARKDOWN = "body_Markdown ";


//    public static final String TABLE_DESCRIPTION = "description";
//    public static final String DESCRIPTION_TOPIC_ID = "topic_id";
//    public static final String DESCRIPTION_SUB_TOPIC_ID = "sub_topic_id";
//    public static final String DESCRIPTION_DESCRIPTION = "description";



}
