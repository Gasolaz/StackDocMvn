<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="TestPack.Package" %><%--
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
</head>
<body>
    <%--<h3> String Information </h3>--%>
    <%--<% List<String> strings = (ArrayList<String>)request.getAttribute("strings");--%>

        <%--for(String string : strings){--%>
            <%--out.print(string);--%>
            <%--out.print("<br>");--%>
        <%--}--%>

    <%--%>--%>

    <h3> <%= request.getParameter("smth") %></h3>
</body>
</html>
