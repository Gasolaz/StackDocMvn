
import static DB.JsonParser.jsonToDb;


public class Main {

    static final String INSERT_INTO_DATABASE_TABLE_TOPICS = "INSERT INTO Topics(_id, DocTagId, Title, CreationDate, ViewCount, " +
            "LastEditDate, ContributorCount, ExampleCount, ExampleScore, " +
            "SyntaxHtml, ParametersHtml, RemarksHtml, IntroductionMarkdown, SyntaxMarkdown, " +
            "ParametersMarkdown, RemarksMarkdown, HelloWorldVersionsHtml) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, " +
            "?, ?, ?, ?, ?, ?, ?, ?)";

    public static void main(String[] args) {
        jsonToDb("w.e");
    }


}



