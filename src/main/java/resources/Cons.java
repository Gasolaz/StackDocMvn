package resources;

public class Cons {

    //      All Tables ID
    public static final String ID = "_id";

    //      Table: Topics
    public static final String TABLE_TOPICS = "topics";
    //    Table Topics -> Columns
    public static final String TOPICS_TOPIC = "topic";
    public static final String TOPICS_TOPIC_COUNT = "topic_count";

    //      Table: Subtopics
    public static final String TABLE_SUB_TOPICS = "subtopics";
    //    Table Subtopics  -> Columns
    public static final String SUB_TOPICS_TOPIC_ID = "topic_id";
    public static final String SUB_TOPICS_SUB_TOPIC = "sub_topic";
    public static final String SUB_TOPICS_DESCRIPTION_HTML = "description_HTML";

    //      Table: Examples
    public static final String TABLE_EXAMPLES = "examples";
    //     Table Examples  -> Columns
    public static final String EXAMPLES_SUB_TOPIC_ID = "sub_topic_id";
    public static final String EXAMPLES_TITLE = "title";
    public static final String EXAMPLES_BODY_HTML = "body_HTML";
    public static final String EXAMPLES_BODY_MARKDOWN = "body_Markdown";

//    public static final String TABLE_DESCRIPTION = "description";
//    public static final String DESCRIPTION_TOPIC_ID = "topic_id";
//    public static final String DESCRIPTION_SUB_TOPIC_ID = "sub_topic_id";
//    public static final String DESCRIPTION_DESCRIPTION = "description";
//    public static final String INSERT_INTO_DESCRIPTION = "INSERT INTO " + TABLE_DESCRIPTION + "(" + DESCRIPTION_TOPIC_ID + ", " +
//        DESCRIPTION_SUB_TOPIC_ID + ", " + DESCRIPTION_DESCRIPTION + ") VALUES(?, ?, ?)";

    //      Table: Admins
    public static final String TABLE_ADMINS = "admins";
    // Table Admins -> Columns
    public static final String ADMINS_PASSWORD = "hashed_pass";
    public static final String ADMINS_SALT = "salt";

    //      Database -> CRUD

    //      Creation
    public static final String CREATE_TABLE_TOPICS = "CREATE TABLE IF NOT EXISTS \"" + TABLE_TOPICS + "\" (\"" + ID +
            "\" INTEGER NOT NULL, \"" + TOPICS_TOPIC + "\" TEXT NOT NULL, \"" + TOPICS_TOPIC_COUNT + "\" " +
            "INTEGER, PRIMARY KEY(\"" + ID + "\"))" ;
    public static final String CREATE_TABLE_SUB_TOPICS = "CREATE TABLE IF NOT EXISTS \"" + TABLE_SUB_TOPICS + "\" (\"" + ID +
            "\" INTEGER NOT NULL, \"" + SUB_TOPICS_TOPIC_ID + "\" INTEGER NOT NULL, \"" + SUB_TOPICS_SUB_TOPIC +
            "\" TEXT NOT NULL, \"" + SUB_TOPICS_DESCRIPTION_HTML + "\" TEXT NOT NULL, PRIMARY KEY(\"" + ID + "\"))";
    public static final String CREATE_TABLE_EXAMPLES = "CREATE TABLE IF NOT EXISTS \"" + TABLE_EXAMPLES + "\" (\"" + ID + "\" INTEGER NOT NULL, \"" +
            EXAMPLES_SUB_TOPIC_ID + "\" INTEGER NOT NULL, \"" +  EXAMPLES_TITLE + "\" TEXT NOT NULL, \"" +
            EXAMPLES_BODY_HTML + "\" TEXT NOT NULL, \"" + EXAMPLES_BODY_MARKDOWN + "\" TEXT NOT NULL, PRIMARY KEY(\"" +
            ID + "\"))";
    public static final String CREATE_TABLE_ADMINS = "CREATE TABLE IF NOT EXISTS \"" + TABLE_ADMINS + "\" (\"" + ID +
            "\" INTEGER NOT NULL, \"" + ADMINS_PASSWORD + "\" TEXT NOT NULL, \"" + ADMINS_SALT +
            "\" TEXT NOT NULL, PRIMARY KEY (\"" + ID + "\"))";

    //      Insertion
    public static final String INSERT_INTO_TOPICS = "INSERT INTO " + TABLE_TOPICS + "(" + TOPICS_TOPIC + ") VALUES(?)";
    public static final String INSERT_INTO_SUB_TOPICS = "INSERT INTO " + TABLE_SUB_TOPICS + "(" + SUB_TOPICS_TOPIC_ID + ", " + SUB_TOPICS_SUB_TOPIC + ", " + SUB_TOPICS_DESCRIPTION_HTML + ") VALUES(?, ?, ?)";
    public static final String INSERT_INTO_EXAMPLE_EXAMPLE = "INSERT INTO " + TABLE_EXAMPLES + "(" + ID + ", " + EXAMPLES_SUB_TOPIC_ID + ", " + EXAMPLES_TITLE + ", " + EXAMPLES_BODY_HTML + ", " + EXAMPLES_BODY_MARKDOWN + ") VALUES(?, ?, ?, ?, ?, ?)";


    //      Selection
    public static final String SELECT_TOPICS_BY_ID = "SELECT * FROM " + TABLE_TOPICS + " WHERE " + ID + "=?"; // SubTopic line:18
    public static final String SELECT_SUBTOPICS_BY_ID = "SELECT * FROM " + TABLE_SUB_TOPICS + " WHERE " + ID + "=?"; // DescriptionService line:12
    public static final String SELECT_FROM_EXAMPLES_BY_SUBTOPIC_ID = "SELECT * FROM " + TABLE_EXAMPLES + " WHERE " + EXAMPLES_SUB_TOPIC_ID + "=?";
    public static final String SELECT_TOPICS_BY_COUNT = "SELECT * FROM " + TABLE_TOPICS + " ORDER BY " + TOPICS_TOPIC_COUNT + " DESC";
    public static final String SELECT_FROM_SUBTOPICS_START = "SELECT * FROM " + TABLE_SUB_TOPICS;
    public static final String SELECT_COUNT_FROM_SUBTOPICS_START = "SELECT count(*) FROM " + TABLE_SUB_TOPICS;
    public static final String SELECT_ADMIN_BY_PASSWORD = "SELECT * FROM " + TABLE_ADMINS + " WHERE " + ADMINS_PASSWORD + "=?";
    public static final String SELECT_EXAMAPLE_BY_SUB_TOPIC_ID = "SELECT * FROM " + TABLE_EXAMPLES + " WHERE " + EXAMPLES_SUB_TOPIC_ID + "=?";

    //      Deletion
    public static final String DELETE_SUB_TOPIC_FROM_SUB_TOPICS = "DELETE FROM " + TABLE_SUB_TOPICS + " WHERE " + ID + "=?";

    //      Update
    public static final String UPDATE_SUBTOPICS_DESCRIPTION = "UPDATE " + TABLE_SUB_TOPICS + " SET " +
            SUB_TOPICS_DESCRIPTION_HTML + "=? WHERE " + ID + "=?";

    //      URL's
    public static final String URL_DB = "jdbc:sqlite:../../../src/TempStackDoc.db"; // DatabaseConnection line:28
    public static final String URL_DB_FILE = "../../../src/TempStackDoc.db";

    //      Variables
    public static final int ROWS = 10; // SearchObject

}