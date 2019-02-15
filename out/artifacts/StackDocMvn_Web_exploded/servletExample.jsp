<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="TestPack.Package" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:useBean id="atr" class="TestPack.Package" scope="request"/>
<head>
    <title>Test</title>
</head>
<body>
 <h5>
     <%
        for(String string : atr.method()){
            out.print(string);
            out.print("<br>");
        }
     %>
 </h5>
</body>
</html>
