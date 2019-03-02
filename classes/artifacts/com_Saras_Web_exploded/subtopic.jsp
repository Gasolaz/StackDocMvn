<%@ page import="models.Description" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <link rel="stylesheet" href="styles.css">
    <%--<script src="script.js"></script>--%>
</head>
<body>

<%Description description = (Description) request.getAttribute("descriptionObject");%>





<div class="subtopic_container">

    <div class="header">

        <button class="back" type="submit">Back</button>

        <h1><%=description.getSub_topic()%></h1>


    </div>



    <%=description.getDescription()%>
    <%=description.getBody_HTML()%>
    <%=description.getBody_markdown()%>




</div>


</body>
</html>
