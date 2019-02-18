<%@ page import="static DB.DatabaseConnection.connect" %>
<%@ page import="javax.xml.transform.Result" %>
<%@ page import="java.sql.*" %>
<%@ page import="TestPack.ObjectRnd" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:useBean id="atr" class="TestPack.Package"/>
<head>
    <title>Test</title>
</head>
<body>
 <h5>
     <%
//        try {
//            Connection conn = connect();
//            Statement ps = conn.createStatement();
//            ResultSet rs = ps.executeQuery("SELECT topic FROM topics");
//            while(rs.next()){
//                out.print(rs.getString("topic"));
//                out.print("<br>");
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
         ObjectRnd rnd = atr.method();
         int index = 1;
         for(String str : rnd.getStr()){
             out.print(index + ". " + str);
             out.print("<br>");
             index++;
         }
         out.print("************");
         out.print("<br>");
         index = 1;
         for(String another : rnd.getStr1()) {
             out.print(index + ". " + another);
             out.print("<br>");
             index++;
         }
     %>
 </h5>
</body>
</html>
