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