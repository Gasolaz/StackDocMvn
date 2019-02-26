<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Topic" %>
<%@ page import="java.util.Map" %>
<%@ page import="models.SubTopic" %>
<%@ page import="models.SearchObject" %><%--
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
    <%--<link rel="stylesheet" href="reset.css">--%>
    <link rel="stylesheet" href="styles.css">
    <%--<script src="script.js"></script>--%>
</head>
<body>

<div class="container">

    <form action="" class="topics_form" method="post">
        <select class="select_topics" name="topics">
        <option selected="selected" value=0></option>
        <%
            List<Topic> topics = (List<Topic>) request.getAttribute("topics");
            if(topics != null) {
                for(Topic topic : topics){
                    if(request.getAttribute("selectedTopic") != null &&
                            (Long) request.getAttribute("selectedTopic") == topic.getId()) {
        %>
            <option selected="selected" value=<%=topic.getId()%>><%=topic.getTopic()%></option>
                        <% continue;
                    }%>
        <option value=<%=topic.getId()%>>
                <%=topic.getTopic()%>
        </option>
        <%
                }
            }
        %>
    </select>
        <input autofocus name="subtopicsearch" type="text" class="search" placeholder="Search...">
        <input type="hidden" name="pageNumber" value="1">
        <button class="search_button" type="submit">Search</button>
    </form>

    <table cellpadding="10px">
        <%
            List<SubTopic> subTopics;
            if(request.getAttribute("filteredSt") == null) {
                subTopics = (List<SubTopic>) request.getAttribute("subTopics");
            } else {
                subTopics = (List<SubTopic>) request.getAttribute("filteredSt");
            }

        %>
        <tr>
            <th>Topic</th>
            <th>Subtopic</th>
        </tr>

    </table>


    <div class="subtopics">
            <% for(SubTopic subTopic : subTopics){ %>

        <form action="subtopic" method="post" class="tableform">
            <input type="hidden" value="<%=subTopic.getId()%>" name="subtopicid">
            <button type="submit">
                <span class="topicSpan">
                    <%= subTopic.getTopicId()%>
                </span>
                <span class="subtopicSpan">
                    <%=subTopic.getSubTopic()%>
                </span></button>
        </form>
    <%
            }
        %>

    </div>





<%--<tr>--%>
            <%--<td><%= subTopic.getTopicId()%></td>--%>
            <%--<td><%= subTopic.getSubTopic() %></td>--%>
        <%--</tr>--%>




    <div class="pages">

            <%SearchObject searchObject = (SearchObject) request.getAttribute("searchObject");
            if(searchObject == null) {
                searchObject = new SearchObject(0, "");
            }
            long pages = searchObject.getPages();
            if(pages > 20){
                pages = 20;
            }
            %>

        <%--<form action="" method="POST">--%>
            <%--<input name="existingSearchObject" type="hidden" value="<%=searchObject%>">--%>
            <%--<input name="number" type="hidden" value="-1">--%>
            <%--<button type="submit" class="previous">previous</button>--%>
        <%--</form>--%>



        <% for(int i = 1; i <=pages; i++){%>


        <form action="" method="post">
            <input name="topics" type="hidden" value="<%=searchObject.getTopicId()%>">
            <input name="subtopicsearch" type="hidden" value="<%=searchObject.getSearch()%>">
            <input type="hidden" value="<%=i%>" name="pageNumber">
            <button class="page" type="submit"><%=i%></button>
        </form>
        <%

            }
        %>

        <%--<form action="" method="POST">--%>
            <%--<input name="existingSearchObject" type="hidden" value="<%=searchObject%>">--%>
            <%--<input name="number" type="hidden" value="1">--%>
            <%--<button type="submit" class="next">next</button>--%>
        <%--</form>--%>

    </div>

</div>

</body>
</html>
