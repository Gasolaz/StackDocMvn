<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="TestPack.Package" %>
<%@ page import="models.Topic" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: sarunas
  Date: 19.2.14
  Time: 19.36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <style>
        table {
            border: 1px solid black;
            border-collapse: collapse;
            margin: auto;
            width: 50%;
            text-align: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: aqua;
            transition: 3s;
        }
        table td {
            border: 1px solid black;
            background-color: red;
            color: white;
        }
        table th {
            background-color: black;
            color: white;
        }
        table:hover {
            cursor: pointer;
            transform: rotate(360deg);
        }
    </style>
</head>
<body>
    <table cellpadding="20px">
        <tr>
            <th>id</th>
            <th>Topic</th>
        </tr>
    <%
        List<Topic> topics = (List<Topic>) request.getAttribute("topics");
        for(Topic topic : topics){
            %>

            <%--out.print("<tr><td>" + topic.getId() + "</td><td>" + topic.getTopic() + "</td></tr>");--%>
        <tr>
            <td>
                <%=  topic.getId()%>
            </td>
            <td>
                <%= topic.getTopic() %>
            </td>
        </tr>
        <%
        }
    %>
    </table>
    <%--<h3> String Information </h3>--%>
    <%--<% List<String> strings = (ArrayList<String>)request.getAttribute("strings");--%>

        <%--for(String string : strings){--%>
            <%--out.print(string);--%>
            <%--out.print("<br>");--%>
        <%--}--%>

    <%--%>--%>

    <%--<h3> <%= request.getParameter("smth") %></h3>--%>
</body>
</html>
