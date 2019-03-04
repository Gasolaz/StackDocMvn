package resources;

public class Cons {

//    All Tables ID
    public static final String ID = "_id";

//    Table: Topics
    public static final String TABLE_TOPICS = "topics";
    // Table Topics -> Columns
    public static final String TOPICS_TOPIC = "topic";
    public static final String TOPICS_TOPIC_COUNT = "topic_count";

//    Table: Subtopics
    public static final String TABLE_SUB_TOPICS = "sub_topics";
    // Table Subtopics  -> Columns
    public static final String SUB_TOPICS_TOPIC_ID = "topic_id";
    public static final String SUB_TOPICS_SUB_TOPIC = "sub_topic";
    public static final String SUB_TOPICS_DESCRIPTION_HTML = "description_HTML";

//    Table: Examples
    public static final String TABLE_EXAMPLES = "examples";
    // Table Examples  -> Columns
    public static final String EXAMPLES_SUB_TOPIC_ID = "sub_topic_id";
    public static final String EXAMPLES_TITLE = "title";
    public static final String EXAMPLES_BODY_HTML = "body_HTML";
    public static final String EXAMPLES_BODY_MARKDOWN = "body_Markdown";


//    public static final String TABLE_DESCRIPTION = "description";
//    public static final String DESCRIPTION_TOPIC_ID = "topic_id";
//    public static final String DESCRIPTION_SUB_TOPIC_ID = "sub_topic_id";
//    public static final String DESCRIPTION_DESCRIPTION = "description";

//    Database -> CRUD
    public static final String INSERT_INTO_TOPICS = "INSERT INTO " + TABLE_TOPICS + TOPICS_TOPIC + " VALUES(?)";
    public static final String INSERT_INTO_SUB_TOPICS = "INSERT INTO " + TABLE_SUB_TOPICS + SUB_TOPICS_SUB_TOPIC + " VALUES(?)";
    public static final String INSERT_INTO_SUB_TOPICS_DESCRIPTION = "INSERT INTO" + TABLE_SUB_TOPICS + SUB_TOPICS_DESCRIPTION_HTML + "VALUES(?)";
    public static final String INSERT_INTO_EXAMPLES_TITLE = "INSERT INTO" + TABLE_EXAMPLES + EXAMPLES_TITLE + "VALUES(?)";
    public static final String INSERT_INTO_EXAMPLES_BODY_HTML = "INSERT INTO" + TABLE_EXAMPLES  + EXAMPLES_BODY_HTML + "VALUES(?)";
    public static final String INSERT_INTO_EXAMPLES_BODY_MARKDOWN = "INSERT INTO" + TABLE_EXAMPLES + EXAMPLES_BODY_MARKDOWN + "VALUES(?)";

    public static final String SELECT_TOPICS_BY_ID = "SELECT * FROM " + TABLE_TOPICS + " WHERE " + ID; // SubTopic line:18
    public static final String SELECT_TOPICS_WHERE_TOPIC_COUNT = "SELECT * FROM " + TABLE_TOPICS + " ORDER BY " + TOPICS_TOPIC_COUNT; // TopicDAO line:29
    public static final String SELECT_SUBTOPICS_BY_ID = "SELECT * FROM " + TABLE_SUB_TOPICS + " WHERE" + ID; // DescriptionDAO line:12
    public static final String SELECT_SUBTOPICS_BY = "SELECT * FROM " + TABLE_SUB_TOPICS + " WHERE "; // SubtopicDAO line:43
    public static final String SELECT_SUBTOPICS_BY_TOPIC_ID = "SELECT * FROM " + TABLE_SUB_TOPICS + " WHERE " + SUB_TOPICS_TOPIC_ID; // SubtopicDAO line:46,50
    public static final String SELECT_EXAMPLES_BY_SUBTOPIC_ID = "SELECT * FROM " + TABLE_EXAMPLES  + " WHERE " + EXAMPLES_SUB_TOPIC_ID; // DescriptionDAO line:13



//    URL's
    public static final String URL_DB = "jdbc:sqlite:../../TempStackDoc.db"; // DatabaseConnection line:28

//    Variables
    public static final int ROWS = 10; // SearchObject

}
