//public class CommentsClass {
//}

//        try {
//
//            conn = connect();
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM Topics");
//            List<Topic> topics = new ArrayList<Topic>();
////            List<Integer> id = new ArrayList<>();
////            Map<Long, String> topics = new HashMap<Long, String>();
//            while(rs.next()){
//                Topic topic = new Topic(rs.getLong("_id"), rs.getString("topic"));
////                System.out.println(rs.getString("topic"));
//                topics.add(topic);
////                topics.put(rs.getLong("_id"), rs.getString("topic"));
//            }
//            System.out.println("randomasdasdawd");
//
//            request.setAttribute("topics", topics);
//
//        } catch (SQLException e){
//            e.printStackTrace();
//            System.out.println("failed");
//        }

//        System.out.println("id = "+topic);
//        System.out.println("searchst = " + subTopic);


//    public List<Topic> getAll(){
////        try {
////            conn = connect();
////            Statement statement = conn.createStatement();
////            ResultSet rs = statement.executeQuery("SELECT * FROM Topics");
////            List<Topic> topics = new ArrayList<Topic>();
//////            List<Integer> id = new ArrayList<>();
//////            Map<Long, String> topics = new HashMap<Long, String>();
////            while(rs.next()){
////                Topic topic = new Topic(rs.getLong("_id"), rs.getString("topic"));
//////                System.out.println(rs.getString("topic"));
////                topics.add(topic);
//////                topics.put(rs.getLong("_id"), rs.getString("topic"));
////            }
//
////            return topics;
////
////        } catch (SQLException e){
////            e.printStackTrace();
////            System.out.println("failed");
////        }
////
////        return null;
//    }
//
//    @Override
//    public void save(Topic topic) {
//
//    }
//
//    @Override
//    public void update(Topic topic, String[] params) {
//
//    }
//
//    @Override
//    public void delete(Topic topic) {
//
//    }
//
//    @Override
//    public Optional<Topic> get(long id) {
//        return Optional.empty();
//    }
//            Statement st = conn.createStatement();
//            System.out.println(topic);
//            long topicId = 5;
//            ResultSet rs2 = st.executeQuery("SELECT * FROM Topics WHERE topic='" + topic + "'");
//            while (rs2.next()){
//                topicId = rs2.getLong("_id");
//            }

//            ResultSet rs = statement.executeQuery("SELECT * FROM subtopics as st INNER JOIN Topics as t WHERE t.topic='" + topic + "' AND st.sub_topic='" + search + "'");

//                    PreparedStatement ps = conn.prepareStatement(INSERT_INTO_DATABASE_TABLE_TOPICS);
//                    ps.setLong(1, id);
//                    ps.setLong(2, docTagId);
//                    ps.setString(3, title);
//                    ps.setString(4, creationDate);
//                    ps.setLong(5, viewCount);
//                    ps.setString(6, LastEditDate);
//                    ps.setLong(7, ContributorCount);
//                    ps.setLong(8, ExampleCount);
//                    ps.setLong(9, ExampleScore);
//                    ps.setString(10, SyntaxHtml);
//                    ps.setString(11, ParametersHtml);
//                    ps.setString(12, RemarksHtml);
//                    ps.setString(13, IntroductionMarkdown);
//                    ps.setString(14, SyntaxMarkdown);
//                    ps.setString(15, ParametersMarkdown);
//                    ps.setString(16, RemarksMarkdown);
//                    ps.setString(17, HelloWorldVersionsHtml);
//                    ps.executeUpdate();

//                    System.out.println(conn);

//                    Statement stmt = conn.createStatement();
//                    ResultSet rs = stmt.executeQuery("SELECT * FROM Topics");
//                    while(rs.next()){
//                        System.out.println(rs.getArray(1));
//                    }

//                    Statement statement = conn.createStatement();
//                    ResultSet rs = statement.executeQuery("SELECT Title FROM Topics");
//                    while(rs.next()){
//                        System.out.println(rs.getString("Title"));
//                    }

//                long id = (Long) element.get("Id");
//                long docTagId = (Long) element.get("DocTagId");
//                String title = (String) element.get("Title");
//                String creationDate = (String) element.get("CreationDate");
//                long viewCount = (Long) element.get("ViewCount");
//                String LastEditDate = (String) element.get("LastEditDate");
//                long ContributorCount = (Long) element.get("ContributorCount");
//                long ExampleCount = (Long) element.get("ExampleCount");
//                long ExampleScore = (Long) element.get("ExampleScore");
//                String SyntaxHtml = (String) element.get("SyntaxHtml");
//                String ParametersHtml = (String) element.get("ParametersHtml");
//                String RemarksHtml = (String) element.get("RemarksHtml");
//                String IntroductionMarkdown = (String) element.get("IntroductionMarkdown");
//                String SyntaxMarkdown = (String) element.get("SyntaxMarkdown");
//                String ParametersMarkdown = (String) element.get("ParametersMarkdown");
//                String RemarksMarkdown = (String) element.get("RemarksMarkdown");
//                String HelloWorldVersionsHtml = (String) element.get("HelloWorldVersionsHtml");