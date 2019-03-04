<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page import="models.Topic" %>--%>
<%--<%@ page import="java.util.Map" %>--%>
<%--<%@ page import="models.SubTopic" %>--%>
<%--<%@ page import="models.SearchObject" %>--%>
<%--<%@ page import="services.TopicService" %>&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: sarunas--%>
  <%--Date: 19.2.14--%>
  <%--Time: 19.36--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Test</title>--%>
    <%--&lt;%&ndash;<link rel="stylesheet" href="reset.css">&ndash;%&gt;--%>
    <%--<link rel="stylesheet" href="styles/styles.css">--%>
    <%--&lt;%&ndash;<script src="script.js"></script>&ndash;%&gt;--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="container">--%>


    <%--<h1>StackOverflow Documentation Search Engine</h1>--%>

    <%--<form--%>
            <%--onsubmit="onSubmit()"--%>
            <%--class="topics_form">--%>
        <%--<select onchange="changeState(event, 'topics')" class="select_topics">--%>
            <%--<option selected="selected" value=0></option>--%>
            <%--<%--%>
                <%--TopicService topics = (TopicService) request.getAttribute("topics");--%>
                <%--if (topics != null) {--%>
                    <%--for (Topic topic : topics.getTopics()) {--%>
                        <%--if (request.getAttribute("selectedTopic") != null &&--%>
                                <%--(Long) request.getAttribute("selectedTopic") == topic.getId()) {--%>
            <%--%>--%>
            <%--<option selected="selected" value=<%=topic.getId()%>><%=topic.getTopic()%>--%>
            <%--</option>--%>
            <%--<% continue;--%>
            <%--}%>--%>
            <%--<option value=<%=topic.getId()%>>--%>
                <%--<%=topic.getTopic()%>--%>
            <%--</option>--%>
            <%--<%--%>
                    <%--}--%>
                <%--}--%>
            <%--%>--%>
        <%--</select>--%>
        <%--<input--%>
                <%--onchange="changeState(event, 'search_keyword')"--%>
                <%--autofocus--%>
                <%--type="text"--%>
                <%--class="search"--%>
                <%--placeholder="Search...">--%>
        <%--&lt;%&ndash;<input type="hidden" name="pageNumber" value="1">&ndash;%&gt;--%>
        <%--<button class="search_button" type="submit">Search</button>--%>
    <%--</form>--%>

    <%--&lt;%&ndash;<table cellpadding="10px">&ndash;%&gt;--%>
    <%--<%--%>
        <%--List<SubTopic> subTopics;--%>
        <%--if (request.getAttribute("filteredSt") == null) {--%>
            <%--subTopics = (List<SubTopic>) request.getAttribute("subTopics");--%>
        <%--} else {--%>
            <%--subTopics = (List<SubTopic>) request.getAttribute("filteredSt");--%>
        <%--}--%>

    <%--%>--%>


    <%--<div class="header">--%>
        <%--<p>Topic</p>--%>
        <%--<p>Subtopic</p>--%>
    <%--</div>--%>

    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<th>Topic</th>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<th>Subtopic</th>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>

    <%--&lt;%&ndash;</table>&ndash;%&gt;--%>


    <%--<div class="subtopics">--%>
        <%--<% for (SubTopic subTopic : subTopics) { %>--%>

        <%--<form action="subtopic" method="post" class="tableform">--%>
            <%--<input type="hidden" value="<%=subTopic.getId()%>" name="subtopicid">--%>
            <%--<button type="submit">--%>
                <%--<span class="topicSpan">--%>
                    <%--<%= subTopic.getTopicId()%>--%>
                <%--</span>--%>
                <%--<span class="subtopicSpan">--%>
                    <%--<%=subTopic.getSubTopic()%>--%>
                <%--</span></button>--%>
        <%--</form>--%>
        <%--<%--%>
            <%--}--%>
        <%--%>--%>

    <%--</div>--%>


    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td><%= subTopic.getTopicId()%></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td><%= subTopic.getSubTopic() %></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>


    <%--<div class="pages">--%>

        <%--<%--%>
            <%--SearchObject searchObject = (SearchObject) request.getAttribute("searchObject");--%>
            <%--if (searchObject == null) {--%>
                <%--searchObject = new SearchObject(0, "", 1);--%>
            <%--}--%>
            <%--long pages = searchObject.getPages();--%>
            <%--if (pages > 20) {--%>
                <%--pages = 20;--%>
            <%--}--%>
        <%--%>--%>

        <%--&lt;%&ndash;<% if()&ndash;%&gt;--%>
        <%--<button onclick="onClickBack()" class="back">Previous</button>--%>
        <%--&lt;%&ndash;<form action="" method="POST">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input name="existingSearchObject" type="hidden" value="<%=searchObject%>">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input name="number" type="hidden" value="-1">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<button type="submit" class="previous">previous</button>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</form>&ndash;%&gt;--%>


        <%--<p onchange="changeState(event, 'pageNumber')" class="numba!"><%=searchObject.getPageNumber()%>--%>
        <%--</p>--%>
        <%--&lt;%&ndash;<% for(int i = 1; i <=pages; i++){%>&ndash;%&gt;--%>


        <%--&lt;%&ndash;<form action="" method="post">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input name="topics" type="hidden" value="<%=searchObject.getTopicId()%>">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input name="subtopicsearch" type="hidden" value="<%=searchObject.getSearch()%>">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="hidden" value="<%=i%>" name="pageNumber">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<button class="page" type="submit"><%=i%></button>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</form>&ndash;%&gt;--%>
        <%--&lt;%&ndash;&lt;%&ndash;%>--%>

        <%--&lt;%&ndash;}&ndash;%&gt;--%>
        <%--&lt;%&ndash;%>&ndash;%&gt;--%>

        <%--&lt;%&ndash;<form action="" method="POST">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input name="topics" type="hidden" value="<%=searchObject.getTopicId()%>">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input name="subtopicsearch" type="hidden" value="<%=searchObject.getSearch()%>">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input name="pageNumber" type="hidden" value="<%=searchObject.getPageNumber()+1%>">&ndash;%&gt;--%>
        <%--<button onclick="onClickNext()" class="next">next</button>--%>
        <%--&lt;%&ndash;</form>&ndash;%&gt;--%>

    <%--</div>--%>

<%--</div>--%>

<%--</body>--%>
<%--</html>--%>
