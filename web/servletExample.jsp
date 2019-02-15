<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:useBean id="atr" class="TestPack.Package"/>
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
