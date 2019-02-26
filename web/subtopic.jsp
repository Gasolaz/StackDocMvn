<%@ page import="models.Description" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <link rel="stylesheet" href="styles.css">
    <script src="script.js"></script>
</head>
<body>

<%Description description = (Description) request.getAttribute("descriptionObject");%>


<div class="subtopic_container">


    <h1><%=description.getSub_topic()%>
    </h1>
    <p><%=description.getDescription()%>
    </p>


    <button type="submit" onclick="back()">Back</button>


</div>


</body>
</html>
